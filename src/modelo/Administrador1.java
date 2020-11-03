
package modelo;
//..
//agree
public class Administrador1 extends Usuario1 {
    private String codad;  

    public Administrador1() {
    }

    public Administrador1(String codad, String iptip, String fecha, String nombre, String correo, String pswd) {
        super(iptip, fecha, nombre, correo, pswd);
        this.codad = codad;
    }
    


    public String getCodad() {
        return codad;
    }

    public void setCodad(String codad) {
        this.codad = codad;
    }

   
    
    
    
}
