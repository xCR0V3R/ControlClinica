
package entidades;


public class Horario {
    private String idhor;
    private String codes;
    private String dias;
    private String hinicio;
    private String hfin;

    public Horario() {
    }

    public Horario(String idhor, String codes, String dias, String hinicio, String hfin) {
        this.idhor = idhor;
        this.codes = codes;
        this.dias = dias;
        this.hinicio = hinicio;
        this.hfin = hfin;
    }

    public String getHfin() {
        return hfin;
    }

    public void setHfin(String hfin) {
        this.hfin = hfin;
    }

    public String getIdhor() {
        return idhor;
    }

    public void setIdhor(String idhor) {
        this.idhor = idhor;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHinicio() {
        return hinicio;
    }

    public void setHinicio(String hinicio) {
        this.hinicio = hinicio;
    }
    
    
}
