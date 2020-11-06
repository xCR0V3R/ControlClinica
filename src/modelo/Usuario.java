
package modelo;
//...
//agree
public abstract class Usuario {
  private String iptip; 
  private String fecha; 
  private String nombre; 
  private String correo; 
  private String pswd; 
  private int dni;

    public Usuario(){
        
    }
    public Usuario(String iptip, String fecha, String nombre, String correo, String pswd, int dni) {
        this.iptip = iptip;
        this.fecha = fecha;
        this.nombre = nombre;
        this.correo = correo;
        this.pswd = pswd;
        this.dni = dni;
    }

  
  
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getIptip() {
        return iptip;
    }

    public void setIptip(String iptip) {
        this.iptip = iptip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
  
  
}
