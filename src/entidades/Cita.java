
package entidades;

public class Cita {
    private String idCita;
    private String nompac;
    private String diacit;
    private String horacit;
    private String estadopac;
    private int dnipac;
    private String codmed;
    private String nomed;
    private String esp;
    private String telefono;
//fx
    public Cita(String nompac, String diacit, String horacit, String esp, int dnipac, String nomed, String telefono) {
        this.nompac = nompac;
        this.diacit = diacit;
        this.horacit = horacit;
        this.esp = esp;
        this.dnipac = dnipac;
        this.nomed = nomed;
        this.telefono=telefono;
    }

    public Cita() {
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getNompac() {
        return nompac;
    }

    public void setNompac(String nompac) {
        this.nompac = nompac;
    }

    public String getDiacit() {
        return diacit;
    }

    public void setDiacit(String diacit) {
        this.diacit = diacit;
    }

    public String getHoracit() {
        return horacit;
    }

    public void setHoracit(String horacit) {
        this.horacit = horacit;
    }

    public String getEstadopac() {
        return estadopac;
    }

    public void setEstadopac(String estadopac) {
        this.estadopac = estadopac;
    }

    public int getDnipac() {
        return dnipac;
    }

    public void setDnipac(int dnipac) {
        this.dnipac = dnipac;
    }

    public String getCodmed() {
        return codmed;
    }

    public void setCodmed(String codmed) {
        this.codmed = codmed;
    }

    public String getNomed() {
        return nomed;
    }

    public void setNomed(String nomed) {
        this.nomed = nomed;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }
    
    
}
