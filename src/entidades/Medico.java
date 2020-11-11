

package entidades;

public class Medico extends Usuario {
    private String codes; 
    private String codmed;

   public Medico(){
          }

    public Medico(String codes, String iptip, String fecha, String nombre, char sexo, String correo, String pswd, int dni) {
        super(iptip, fecha, nombre, sexo, correo, pswd, dni);
        this.codes = codes;
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
