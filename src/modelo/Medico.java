

package modelo;

public class Medico extends Usuario {
    private String codes; 
    private String codmed;

    public Medico() {
    }

    public Medico(String codes, String codmed, String iptip, String fecha, String nombre, String correo, String pswd) {
        super(iptip, fecha, nombre, correo, pswd);
        this.codes = codes;
        this.codmed = codmed;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getCodmed() {
        return codmed;
    }

    public void setCodmed(String codmed) {
        this.codmed = codmed;
    }
    
    
    
    
}
