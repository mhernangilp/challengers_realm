
package MetProg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Combate {
    private Personaje pjDesafiante;
    private int[] saludDesafiante;
    private Personaje pjDesafiado;
    private int[] saludDesafiado;
    private Integer ronda;
    
    // Esta funcion se encargara de recorrer los esbirros de forma recursiva e ir sumando la salud de cada uno
    private int recorrerEsbirros(ArrayList<Esbirro> e, int salud) {
        for (int i = 0; i < e.size(); i++) {
            Esbirro esbirro = e.get(i);
            if (esbirro instanceof Demonio) {
                salud = salud + esbirro.getSalud();
                Demonio demon = (Demonio) esbirro;
                salud = recorrerEsbirros(demon.getEsbirros(), salud);
            }
            else {
                salud = salud + esbirro.getSalud();
            }
        }
        return salud;
    }
    
    public void aceptarCombate(Database data, Desafio desafio) throws Exception{
        
        // Inicializacion de los clientes
        Cliente c1 = (Cliente) data.getUsuarioByNick(desafio.getDesafiante());
        Cliente c2 = (Cliente) data.getUsuarioByNick(desafio.getDesafiado());
        
        // Inicializacion ronda y personajes
        this.ronda = 1;
        pjDesafiante = (Personaje) data.pedirPersonaje((c1).getPersonaje().getTipo());
        pjDesafiado = (Personaje) data.pedirPersonaje((c2).getPersonaje().getTipo());
        
        // Personajes de usuario para jugar la ronda
        PersonajeUsuario pUs1 = c1.getPersonaje();
        PersonajeUsuario pUs2 = c2.getPersonaje();
        
        System.out.println("Desafio aceptado >:)");
        System.out.println("\nDesea cambiar sus armas o armaduras? (si/no)");
        
        // Aquí se activará la función correspondiente para cambiar las armas del desafiado, si así lo desea
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();
        opcion = opcion.toUpperCase();
        
        switch (opcion){
            case "SI": c2.elegirEquipo(data, pUs2.getTipo());
                    break;
            case "NO":
                    break;
            default: System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                    break;
        }
        
        System.out.println("\nCOMIENZA EL COMBATE!!!");
        
        // Salud total de los personajes
        int saludEsbDesafiante = recorrerEsbirros(pjDesafiante.getEsbirros(), 0);
        int saludEsbDesafiado = recorrerEsbirros(pjDesafiado.getEsbirros(), 0);
        
        // La salud de los jugadores será un array, en la primera posición la salud propia del personaje y la segunda los esbirros
        saludDesafiante = new int[] {pjDesafiante.getSalud(), saludEsbDesafiante};
        saludDesafiado = new int[] {pjDesafiado.getSalud(),saludEsbDesafiado};
        
        while (saludDesafiante[0] > 0 && saludDesafiado[0] > 0) {
            jugarRonda(pjDesafiante, pjDesafiado, saludDesafiante, saludDesafiado, pUs1, pUs2, desafio);
        }
        this.terminarCombate(data, desafio);
    }
    
    private void jugarRonda(Personaje p1, Personaje p2, int[] s1, int[] s2, PersonajeUsuario pUsuario1, PersonajeUsuario pUsuario2, Desafio desafio) throws InterruptedException {
        
        // 0.- Print del inicio del combate
        
        System.out.print("\n|-----------------------------------------------------\n");
        System.out.print("|Ronda: " + this.ronda + "\n|\n");
        
        
        // 1.- Calcular el potencial de ataque y de defensa de cada personaje
        
        int potAtaq1 = calcularPotAtaque(p1, pUsuario1);
        int potAtaq2 = calcularPotAtaque(p2, pUsuario2);
        
        int potDef1 = calcularPotDefensa(p1, pUsuario1);
        int potDef2 = calcularPotDefensa(p2, pUsuario2);
        
        // Se aplican las debilidades y fortalezas
        
        // Al potencial del desafiante
        potAtaq1 = potAtaq1 + setModificadores(desafio.getDesafiante(), desafio);
        potDef1 = potDef1 + setModificadores(desafio.getDesafiante(), desafio);
        
        // Al potencial del desafiado
        potAtaq2 = potAtaq2 + setModificadores(desafio.getDesafiado(), desafio);
        potDef2 = potDef2 + setModificadores(desafio.getDesafiado(), desafio);
        
        // 2.- Calcular tantos numeros aleatorios entre 1 y 6
        
        // En el ataque:
        int[] exitosAtaq = new int[] {0, 0};    // posicion 0 = desafiante, posicion 1 = desafiado
        Random rand = new Random();
        
        // Exitos para desafiante (p1)
        for (int i = 0; i < potAtaq1; i++) {
            int n = rand.nextInt(1, 7);
            if (n >=5) {
                if (p1 instanceof Vampiro) {
                    Vampiro v1 = (Vampiro) p1;
                    v1.setPuntosSangre(v1.getPuntosSangre() + 4);
                    if (v1.getPuntosSangre() > 10) {
                        v1.setPuntosSangre(10);
                    }
                }
                exitosAtaq[0] = exitosAtaq[0] + 1;
            }
        }
        
        // Exitos para desafiado (p2)
        for (int i = 0; i < potAtaq2; i++) {
            int n = rand.nextInt(1, 7);
            if (n >=5) {
                if (p2 instanceof Vampiro) {
                    Vampiro v2 = (Vampiro) p2;
                    v2.setPuntosSangre(v2.getPuntosSangre() + 4);
                    if (v2.getPuntosSangre() > 10) {
                        v2.setPuntosSangre(10);
                    }
                }
                exitosAtaq[1] = exitosAtaq[1] + 1;
            }
        }
        
        System.out.print("|Ataque del desafiante (J1): " + exitosAtaq[0] + "\n");
        System.out.print("|Ataque del desafiado (J2): " + exitosAtaq[1] + "\n|\n");
        
        // En la defensa:
        
        int[] exitosDef = new int[] {0, 0};    // posicion 0 = desafiante, posicion 1 = desafiado
        
        // Exitos para desafiante (p1)
        for (int i = 0; i < potDef1; i++) {
            int n = rand.nextInt(1, 7);
            if (n >=5) {
                exitosDef[0] = exitosDef[0] + 1;
            }
        }
        
        // Exitos para desafiado (p2)
        for (int i = 0; i < potDef2; i++) {
            int n = rand.nextInt(1, 7);
            if (n >=5) {
                exitosDef[1] = exitosDef[1] + 1;
            }
        }
        
        // Decoración para el printeo de las rondas
        System.out.print("|Defensa del desafiante (J1): " + exitosDef[0] + "\n");
        System.out.print("|Defensa del desafiado (J2): " + exitosDef[1] + "\n|\n");
        
        System.out.print("|Salud desafiante (J1): " + s1[0] + " Escudo de esbirros: " + s1[1] + "\n");
        System.out.print("|Salud desafiado (J2): " + s2[0] + " Escudo de esbirros: " + s2[1] + "\n|\n");
        
        // 3.- Reducir en 1 la salud si el ataque supera o iguala a la defensa
        
        // Si el ataque del desafiante supera a la defensa del desafiado:
        if (exitosAtaq[0] >= exitosDef[1]) {
            actualizarSalud(s2, -1);
            String tipoj1 = pUsuario1.getTipo();
            tipoj1 = tipoj1.toUpperCase();
            // Mensaje para decorar las rondas
            String mensaje = "|El " + tipoj1;
            
            if (tipoj1.equals("LICANTROPO")) {
                mensaje = mensaje + " LE METE UN ZARPAZO al ";
            } else if (tipoj1.equals("VAMPIRO")) {
                mensaje = mensaje + " LE HINCA EL DIENTE al ";
            } else {
                mensaje = mensaje + " LE METE UN TIRO al ";
            }
            
            if (p2 instanceof Licantropo) {
                mensaje = mensaje + "LICANTROPO del JUGADOR2!! (-1 de salud)";
                Licantropo l2 = (Licantropo) p2;
                l2.setRabia(l2.getRabia()+ 1);
                if (l2.getRabia()> 3) {
                    l2.setRabia(3);
                }
            } else if (p2 instanceof Cazador) {
                mensaje = mensaje + "CAZADOR del JUGADOR2!! (-1 de salud)";
                Cazador c2 = (Cazador) p2;
                c2.setVoluntad(c2.getVoluntad()- 1);
                if (c2.getVoluntad()< 0) {
                    c2.setVoluntad(0);
                }
            } else {
                mensaje = mensaje + "VAMPIRO del JUGADOR2!! (-1 de salud)";
            }
            
            System.out.println(mensaje);
            
        }
        // Si sucede lo contrario:
        else if (exitosAtaq[1] >= exitosDef[0]) {
            actualizarSalud(s1, -1);
            String tipoj2 = pUsuario2.getTipo();
            tipoj2 = tipoj2.toUpperCase();
            String mensaje = "|El " + tipoj2;
            
            if (tipoj2.equals("LICANTROPO")) {
                mensaje = mensaje + " LE METE UN ZARPAZO al ";
            } else if (tipoj2.equals("VAMPIRO")) {
                mensaje = mensaje + " LE HINCA EL DIENTE al ";
            } else {
                mensaje = mensaje + " LE METE UN TIRO al ";
            }
            
            if (p1 instanceof Licantropo) {
                mensaje = mensaje + "LICANTROPO del JUGADOR1!! (-1 de salud)";
                Licantropo l1 = (Licantropo) p1;
                l1.setRabia(l1.getRabia()+ 1);
                if (l1.getRabia() > 3) {
                    l1.setRabia(3);
                }
            } else if (p1 instanceof Cazador) {
                mensaje = mensaje + "CAZADOR del JUGADOR1!! (-1 de salud)";
                Cazador c1 = (Cazador) p1;
                c1.setVoluntad(c1.getVoluntad()- 1);
                if (c1.getVoluntad()< 0) {
                    c1.setVoluntad(0);
                }
            } else {
                mensaje = mensaje + "VAMPIRO del JUGADOR1!! (-1 de salud)";
            }
            
            System.out.println(mensaje);
        }        
        
        // Se suma 1 a la ronda
        this.ronda++;
        
        TimeUnit.SECONDS.sleep(2);
        
    }
    
    private void terminarCombate(Database data, Desafio desafio) {
        int[] esbirroSinDerrotar = new int[2];
        Historial log;
        
        if (saludDesafiante[1] == 0){
            esbirroSinDerrotar[0] = 0;
        } else{
            esbirroSinDerrotar[0] = 1;
        }
        if (saludDesafiado[1] == 0){
            esbirroSinDerrotar[1] = 0;
        } else{
            esbirroSinDerrotar[1] = 1;
        }
        // Si hay empate:
        if (saludDesafiante[0] == 0 && saludDesafiado[0] == 0) {
            System.out.println("\nHA HABIDO UN EMPATE\n");
            Cliente c1 = (Cliente) data.getUsuarioByNick(desafio.getDesafiante());
            PersonajeUsuario pj1 = c1.getPersonaje();
            pj1.actualizarOro(desafio.getOroApostado());
            log = new Historial(desafio.getDesafiante(), desafio.getDesafiado(), ronda, "EMPATE", esbirroSinDerrotar, desafio.getOroApostado());
        } 
        // Si gana el desafiado
        else if (saludDesafiante[0] == 0) {
            System.out.println("\nHA GANADO EL DESAFIADO (J2), FELICIDADES!!\n");
            Cliente c2 = (Cliente) data.getUsuarioByNick(desafio.getDesafiado());
            PersonajeUsuario pj2 = c2.getPersonaje();
            pj2.actualizarOro(desafio.getOroApostado());
            log = new Historial(desafio.getDesafiante(), desafio.getDesafiado(), ronda, desafio.getDesafiado(), esbirroSinDerrotar, desafio.getOroApostado());
        } 
        // Si gana el desafiante:
        else {
            System.out.println("\nHA GANADO EL DESAFIANTE (J1), FELICIDADES!!\n");
            Cliente c1 = (Cliente) data.getUsuarioByNick(desafio.getDesafiante());
            PersonajeUsuario pj1 = c1.getPersonaje();
            Cliente c2 = (Cliente) data.getUsuarioByNick(desafio.getDesafiado());
            PersonajeUsuario pj2 = c2.getPersonaje();
            pj1.actualizarOro(2*desafio.getOroApostado());
            pj2.actualizarOro(-desafio.getOroApostado());
            log = new Historial(desafio.getDesafiante(), desafio.getDesafiado(), ronda, desafio.getDesafiante(), esbirroSinDerrotar, desafio.getOroApostado());
        }
        
        ((Cliente) data.getUsuarioByNick(desafio.getDesafiado())).getPersonaje().getHistorial().add(log);
        ((Cliente) data.getUsuarioByNick(desafio.getDesafiante())).getPersonaje().getHistorial().add(log);
        data.eliminarDesafio(desafio);
    }
    
    // Esta funcion se encargará del rechazo del combate, quitando el diezmo de lo que se apostó al desafiado, y sumándoselo al desafiante
    public void rechazarCombate(Database data, Desafio desafio){
        System.out.println("Desafio rechazado :(");
        
        Cliente c1 = (Cliente) data.getUsuarioByNick(desafio.getDesafiado());
        PersonajeUsuario pj1 = c1.getPersonaje();
        
        Cliente c2 = (Cliente) data.getUsuarioByNick(desafio.getDesafiante());
        PersonajeUsuario pj2 = c2.getPersonaje();
        
        long diezmo = (long) (desafio.getOroApostado() * 0.10);
        pj1.actualizarOro(-diezmo);
        pj2.actualizarOro(diezmo);
        data.eliminarDesafio(desafio);
    }
    
    // Esta función se encargará de aplicar las debilidades o fortalezas de los personajes
    private Integer setModificadores(String jugador, Desafio d) {
        ArrayList<Debilidad> debilidades = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<Fortaleza>();
        Integer p = 0;
        
        // Se cargarán las debilidades o fortalezas dependiendo del jugador
        if (jugador.equals(d.getDesafiante())) {
            debilidades = d.getDebDesafiante();
            fortalezas = d.getFortDesafiante();
        } else {
            debilidades = d.getDebDesafiado();
            fortalezas = d.getFortDesafiado();
        }
        
        // Se recorren las debilidades y las fortalezas, disminuyendo o aumentando el potencial respectivamente
        for (int i = 0; i < debilidades.size(); i++) {
            p = p - debilidades.get(i).getValor();
        }
        for (int i = 0; i < fortalezas.size(); i++) {
            p = p + fortalezas.get(i).getValor();
        }
        
        return p;
    }
    
    // Esta función se encargará de actualizar la salud sumando el valor del parámetro
    private void actualizarSalud(int[] salud, int valor) {
        if (salud[1] != 0) {
                salud[1] = salud[1] + valor;
            }
            else {
                salud[0] = salud[0] + valor;
            }
    }
    
    // --------------------------- POTENCIAL ATAQUE ---------------------------
    
    private int calcularPotAtaque(Personaje p, PersonajeUsuario pUsuario) {
        
        // Se cargan las armas activas
        String[] armasActivas = pUsuario.getArmaActiva();
        int ataqEquipo = 0;
            
        if (armasActivas != null) {
            for (String armaActiva : armasActivas) {
                if (armaActiva != null) {
                    // Se suma los modificadores de ataque de cada arma
                    ataqEquipo = ataqEquipo + p.getArmas().get(armaActiva).getModifAtaque();
                }
            }
        }
        
        // Lo mismo con la armadura
        Armadura armaduraActiva = p.getArmaduras().get(pUsuario.getArmaduraActiva());
        
        if (armaduraActiva != null) {
            ataqEquipo = ataqEquipo + armaduraActiva.getModifAtaque();
        }
        
        int potencial = p.getPoder() + ataqEquipo;
        
        if (p instanceof Vampiro) {         // Para el vampiro, primero se verifica si sus puntos de sangre son mayores o igual a 5 para sumar 2 y luego cobrar el coste de sangre, si no nunca se sumarian 2
            
            Vampiro v = (Vampiro) p;
            if (v.getPuntosSangre() >= 5) {
                potencial = potencial + 2;
            }
            
            Disciplina d = (Disciplina) v.getHabilidad();
            
            // Si se puede pagar la habilidad, lo hace y consigue el ataque de la habilidad
            if (v.getPuntosSangre() >= d.getCosteSangre()) {
                potencial = potencial + d.getAtaque();
                v.setPuntosSangre(v.getPuntosSangre() - d.getCosteSangre());
            }
            
        } else if (p instanceof Licantropo) {       // Para el Licantropo, se suma la cantidad de rabia actual y si ademas puede pagar el don, se suma el ataque del don.
        
            Licantropo l = (Licantropo) p;
            potencial = potencial + l.getRabia();
            
            Don d = (Don) l.getHabilidad();
            
            // Con el Licántropo igual, pero no se restará la rabia
            if (l.getRabia() >= d.getCosteRabia()) {
                potencial = potencial + d.getAtaque();
            }
            
        } else {                                    // Para el Cazador, se suma el ataque de la habilidad y la voluntad actual si o si.
            
            Cazador c = (Cazador) p;
            potencial = potencial + c.getHabilidad().getAtaque() + c.getVoluntad();
            
        }
        
        return potencial;
    
    }
    
    // --------------------------- POTENCIAL DEFENSA ---------------------------
    
    private int calcularPotDefensa(Personaje p, PersonajeUsuario pUsuario) {
    
        // Lo mismo para la defensa, pero sumando el valor de las modificaciones de la defensa de cada arma o armadura
        String[] armasActivas = pUsuario.getArmaActiva();
        int defEquipo = 0;
            
        if (armasActivas != null) {
            for (String armaActiva : armasActivas) {
                if (armaActiva != null) {
                    defEquipo = defEquipo + p.getArmas().get(armaActiva).getModifDefensa();
                }
            }
        }
        
        Armadura armaduraActiva = p.getArmaduras().get(pUsuario.getArmaduraActiva());
        
        if (armaduraActiva != null) {
            defEquipo = defEquipo + armaduraActiva.getModifDefensa();
        }
        
        int potencial = p.getPoder() + defEquipo;
        
        if (p instanceof Vampiro) {
            
            Vampiro v = (Vampiro) p;
            if (v.getPuntosSangre() >= 5) {
                potencial = potencial + 2;
            }
            
            Disciplina d = (Disciplina) v.getHabilidad();
            
            if (v.getPuntosSangre() >= d.getCosteSangre()) {
                potencial = potencial + d.getDefensa();
                v.setPuntosSangre(v.getPuntosSangre() - d.getCosteSangre());
            }
            
        } else if (p instanceof Licantropo) {
        
            Licantropo l = (Licantropo) p;
            potencial = potencial + l.getRabia();
            
            Don d = (Don) l.getHabilidad();
            
            if (l.getRabia() >= d.getCosteRabia()) {
                potencial = potencial + d.getDefensa();
            }
            
        } else {
            
            Cazador c = (Cazador) p;
            potencial = potencial + c.getHabilidad().getDefensa()+ c.getVoluntad();
            
        }
        
        return potencial;
    
    }
    
}
