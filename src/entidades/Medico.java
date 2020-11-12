

package entidades;

public class Medico extends Usuario {
    private String codes; 
    private String codmed;
    private String idhorario;
    private String asistencia;
   public Medico(){
          }

    public Medico(String codes, String iptip, String fecha, String nombre, char sexo, String correo, String pswd, int dni,String idhorario,String asistencia ) {
        super(iptip, fecha, nombre, sexo, correo, pswd, dni);
        this.codes = codes;this.idhorario=idhorario;this.asistencia=asistencia;
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

    public String getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(String idhorario) {
        this.idhorario = idhorario;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    
    
    
    
}
