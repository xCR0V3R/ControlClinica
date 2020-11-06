
package modelo;

public class Administrador extends Usuario {
    private String codad;  

    public Administrador() {
       
    }
    public Administrador(String iptip, String fecha, String nombre, String correo, String pswd, int dni) {
        super(iptip, fecha, nombre, correo, pswd, dni);
        
    }

    public String getCodad() {
        return codad;
    }

    public void setCodad(String codad) {
        this.codad = codad;
    }

    
   

   
    
    
    
}
