
package MetProg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combate {
    private Personaje pjDesafiante;
    private int[] saludDesafiante;
    private Personaje pjDesafiado;
    private int[] saludDesafiado;
    private Integer ronda;
    
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
        System.out.println("\nDesea cambiar sus armas o armaduras? (si/no)\n");
        
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
        
        System.out.println("\nCOMIENZA EL COMBATE!!!\n");
        
        // Salud total de los personajes
        int saludEsbDesafiante = recorrerEsbirros(pjDesafiante.getEsbirros(), 0);
        int saludEsbDesafiado = recorrerEsbirros(pjDesafiado.getEsbirros(), 0);
        
        saludDesafiante = new int[] {pjDesafiante.getSalud(), saludEsbDesafiante};
        saludDesafiado = new int[] {pjDesafiado.getSalud(),saludEsbDesafiado};
        
        while (saludDesafiante[0] > 0 && saludDesafiado[0] > 0) {
            jugarRonda(pjDesafiante, pjDesafiado, saludDesafiante, saludDesafiado, pUs1, pUs2, desafio);
        }
        this.terminarCombate(data, desafio);
    }
    
    private void jugarRonda(Personaje p1, Personaje p2, int[] s1, int[] s2, PersonajeUsuario pUsuario1, PersonajeUsuario pUsuario2, Desafio desafio) {
        
        // 0.- Print del inicio del combate
        
        System.out.println("|------------------------------");
        System.out.println("\n|Ronda: " + this.ronda);
        
        
        // 1.- Calcular el potencial de ataque y de defensa de cada personaje
        
        int potAtaq1 = calcularPotAtaque(p1, pUsuario1);
        int potAtaq2 = calcularPotAtaque(p2, pUsuario2);
        
        int potDef1 = calcularPotDefensa(p1, pUsuario1);
        int potDef2 = calcularPotDefensa(p2, pUsuario2);
        
        // Se aplican las debilidades y fortalezas
        
        // Al potencial del desafiante
        setModificadores(potAtaq1, desafio.getDesafiante(), desafio);
        setModificadores(potDef1, desafio.getDesafiante(), desafio);
        
        // Al potencial del desafiado
        setModificadores(potAtaq2, desafio.getDesafiado(), desafio);
        setModificadores(potDef2, desafio.getDesafiado(), desafio);
        
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
        
        System.out.println("|Ataque del desafiante (J1): " + exitosAtaq[0]);
        System.out.println("|Ataque del desafiado (J2): " + exitosAtaq[1] + "\n");
        
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
        
        System.out.println("|Defensa del desafiante (J1): " + exitosDef[0]);
        System.out.println("|Defensa del desafiado (J2): " + exitosDef[1] + "\n");
        
        // 3.- Reducir en 1 la salud si el ataque supera o iguala a la defensa
        
        if (exitosAtaq[0] >= exitosDef[1]) {
            actualizarSalud(s2, -1);
            String j2 = pUsuario2.getTipo();
            if (p2 instanceof Licantropo) {
                System.out.println("|El LICANTROPO del JUGADOR1 LE METE UN ZARPAZO al " + j2 + " del JUGADOR2!! (-1 de salud)");
                Licantropo l2 = (Licantropo) p2;
                l2.setRabia(l2.getRabia()+ 1);
                if (l2.getRabia()> 3) {
                    l2.setRabia(3);
                }
            } else if (p1 instanceof Cazador) {
                System.out.println("|El CAZADOR del JUGADOR1 LE METE UN TIRO al " + j2 + " del JUGADOR2!! (-1 de salud)");
                Cazador c2 = (Cazador) p1;
                c2.setVoluntad(c2.getVoluntad()- 1);
                if (c2.getVoluntad()< 0) {
                    c2.setVoluntad(0);
                }
            } else {
                System.out.println("|El VAMPIRO del JUGADOR1 LE HINCA EL DIENTE al " + j2 + " del JUGADOR2!! (-1 de salud)");
            }
        }
        else if (exitosAtaq[1] >= exitosDef[0]) {
            actualizarSalud(s1, -1);
            String j1 = pUsuario1.getTipo();
            if (p1 instanceof Licantropo) {
                System.out.println("|El LICANTROPO del JUGADOR2 LE METE UN ZARPAZO al " + j1 + " del JUGADOR1!! (-1 de salud)");
                Licantropo l1 = (Licantropo) p1;
                l1.setRabia(l1.getRabia()+ 1);
                if (l1.getRabia() > 3) {
                    l1.setRabia(3);
                }
            } else if (p1 instanceof Cazador) {
                System.out.println("|El CAZADOR del JUGADOR2 LE METE UN TIRO al " + j1 + " del JUGADOR1!! (-1 de salud)");
                Cazador c1 = (Cazador) p1;
                c1.setVoluntad(c1.getVoluntad()- 1);
                if (c1.getVoluntad()< 0) {
                    c1.setVoluntad(0);
                }
            } else {
                System.out.println("|El VAMPIRO del JUGADOR2 LE HINCA EL DIENTE al " + j1 + " del JUGADOR1!! (-1 de salud)");
            }
        }        
        
        // Se suma 1 a la ronda
        this.ronda++;
        
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
        if (saludDesafiante[0] == 0 && saludDesafiado[0] == 0) {
            System.out.println("HA HABIDO UN EMPATE");
            log = new Historial(desafio.getDesafiante(), desafio.getDesafiado(), ronda, "EMPATE", esbirroSinDerrotar, desafio.getOroApostado());
        } else if (saludDesafiante[0] == 0) {
            System.out.println("HA GANADO EL DESAFIADO (P2), FELICIDADES!!");
            log = new Historial(desafio.getDesafiante(), desafio.getDesafiado(), ronda, desafio.getDesafiado(), esbirroSinDerrotar, desafio.getOroApostado());
        } else {
            System.out.println("HA GANADO EL DESAFIANTE (P1), FELICIDADES!!");
            log = new Historial(desafio.getDesafiante(), desafio.getDesafiado(), ronda, desafio.getDesafiante(), esbirroSinDerrotar, desafio.getOroApostado());
        }
        ((Cliente) data.getUsuarioByNick(desafio.getDesafiado())).getPersonaje().getHistorial().add(log);
        ((Cliente) data.getUsuarioByNick(desafio.getDesafiante())).getPersonaje().getHistorial().add(log);
        data.eliminarDesafio(desafio);
    }
    
    public void rechazarCombate(Database data, Desafio desafio){
        System.out.println("Desafio rechazado :(");
        
        Cliente c1 = (Cliente) data.getUsuarioByNick(desafio.getDesafiado());
        PersonajeUsuario pj1 = c1.getPersonaje();
        
        Cliente c2 = (Cliente) data.getUsuarioByNick(desafio.getDesafiante());
        PersonajeUsuario pj2 = c2.getPersonaje();
        
        long diezmo = (long) (desafio.getOroApostado() * 0.10);
        pj1.setOro(pj1.getOro() - diezmo);
        pj2.setOro(pj2.getOro() + diezmo + desafio.getOroApostado());
    }
    
    private void setModificadores(int potencial, String jugador, Desafio d) {
        ArrayList<Debilidad> debilidades = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<Fortaleza>();
        
        if (jugador.equals(d.getDesafiante())) {
            debilidades = d.getDebDesafiante();
            fortalezas = d.getFortDesafiante();
        } else {
            debilidades = d.getDebDesafiado();
            fortalezas = d.getFortDesafiado();
        }
        
        // Se recorren las debilidades y las fortalezas, disminuyendo o aumentando el potencial respectivamente
        for (int i = 0; i < debilidades.size(); i++) {
            potencial = potencial - debilidades.get(i).getValor();
        }
        for (int i = 0; i < fortalezas.size(); i++) {
            potencial = potencial - fortalezas.get(i).getValor();
        }
    }
    
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
        
        String[] armasActivas = pUsuario.getArmaActiva();
        int ataqEquipo = 0;
            
        if (armasActivas != null) {
            for (String armaActiva : armasActivas) {
                if (armaActiva != null) {
                    ataqEquipo = ataqEquipo + p.getArmas().get(armaActiva).getModifAtaque();
                }
            }
        }
        
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
            
            if (v.getPuntosSangre() >= d.getCosteSangre()) {
                potencial = potencial + d.getAtaque();
                v.setPuntosSangre(v.getPuntosSangre() - d.getCosteSangre());
            }
            
        } else if (p instanceof Licantropo) {       // Para el Licantropo, se suma la cantidad de rabia actual y si ademas puede pagar el don, se suma el ataque del don.
        
            Licantropo l = (Licantropo) p;
            potencial = potencial + l.getRabia();
            
            Don d = (Don) l.getHabilidad();
            
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
