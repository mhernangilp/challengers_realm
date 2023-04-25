
package MetProg;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Historial {
    private String usuarioDesafiante;
    private String usuarioDesafiado;
    private Integer rondasEmpleadas;
    private Date fechaCombate;
    private String usuarioVencedor;
    private int[] esbirroSinDerrotar;
    private long oroGanado;

    public Historial(String usuarioDesafiante, String usuarioDesafiado, Integer rondasEmpleadas, String usuarioVencedor, int[] esbirroSinDerrotar, long oroGanado) {
        this.usuarioDesafiante = usuarioDesafiante;
        this.usuarioDesafiado = usuarioDesafiado;
        this.rondasEmpleadas = rondasEmpleadas;
        this.usuarioVencedor = usuarioVencedor;
        this.esbirroSinDerrotar = esbirroSinDerrotar;
        this.oroGanado = oroGanado;
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate date = LocalDate.now();
        this.fechaCombate = Date.from(date.atStartOfDay(timeZone).toInstant());
    }

    public String getUsuarioDesafiante() {
        return usuarioDesafiante;
    }

    public String getUsuarioDesafiado() {
        return usuarioDesafiado;
    }

    public Integer getRondasEmpleadas() {
        return rondasEmpleadas;
    }

    public Date getFechaCombate() {
        return fechaCombate;
    }

    public String getUsuarioVencedor() {
        return usuarioVencedor;
    }

    public int[] getEsbirroSinDerrotar() {
        return esbirroSinDerrotar;
    }

    public long getOroGanado() {
        return oroGanado;
    }
}
