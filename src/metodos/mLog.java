

package metodos;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import modelo.*;import daos.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class mLog {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    DAORegistro dao=new DAORegistro();
    Logueo log;
    String dNom; String dNac; private String dTip;int dDNI;private String dCorreo;private String dPswd;
    private String dEsp;
    SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
    
    public mLog(){}
    
    public mLog(Logueo log){
        this.log=log;
        
    }
    
    public void inicializarLog(){
        log.setTitle("Sistema CliniMAX");
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        esIcono(log);
    }
    
     public void inRegistro(){
        log.nuevRegistro.setTitle("Registro");
        log.nuevRegistro.setLocationRelativeTo(null);
        log.nuevRegistro.setVisible(true);        
        esIcono(log.nuevRegistro);
        log.jlEspecialidad.setVisible(false);
        log.jcbxEspecialidad1.setVisible(false);
     }
     
     public void esIcono(JFrame loge){
         loge.setIconImage(new ImageIcon(getClass().getResource(URLIcono)).getImage());
     }
     
        public void support(String direc){
        if(Desktop.isDesktopSupported()){
               Desktop desk=Desktop.getDesktop();
               if(desk.isSupported(Desktop.Action.BROWSE)){
                   try{
                   URI uri=new URI(direc);
                   desk.browse(uri);
                   }catch (Exception ex) {
                       
                   }
               }
           }
    }
        
        public void obtenerData(){
        dNom=log.txtNombre.getText();
        dNac=formato.format(this.log.dateNacimiento.getDate());
        dDNI=Integer.parseInt(this.log.txtDNI.getText());
        dCorreo=log.txCorreo.getText();
        dPswd=log.txContra.getText();
        String tipo="";
        tipo=log.jcbTipoUser.getSelectedItem().toString();
        if(tipo.equals("Medico")) dTip="U002";
        if(tipo.equals("Administrador")) dTip="U001";
        if(tipo.equals("-Seleccionar-")) dTip="U000";
        
        if(dTip.equals("U002")){
            dEsp=log.jcbxEspecialidad1.getSelectedItem().toString();
        }
        }
        
       
        public void regAdmi(){
            Administrador a=new Administrador(dTip,dNac, dNom, dCorreo, dPswd, dDNI);
            dao.addAdmi(a);
         }
        
       /* public String tipoEsp(String esp){
            if(esp.equals("Medicina General")) return "E01";
            if(esp.equals("Medicina General")) return "E02";
            if(esp.equals("Medicina General")) return "E03";
            if(esp.equals("Medicina General")) return "E01";
            if(esp.equals("Medicina General")) return "E01";
            if(esp.equals("Medicina General")) return "E01";
            if(esp.equals("Medicina General")) return "E01";
            if(esp.equals("Medicina General")) return "E01";
        }*/
        
      /*  public void regMed(Logueo log){
            String nom=log.txtNombre.getText();
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            String nac=formato.format(log.dtNacimiento.getDate().toString());
            System.out.println("ESTO ES NACIMIENTO: "+nac);
            String tip="U001";
            int DNI=Integer.parseInt(log.txtDNI.getText());
            String correo=log.txtCorreo.getText();
            String contra=log.txtContraseña.getText();
            String esp=log.jcbxEspecialidad1.getSelectedItem().toString();
            Medico md=new Medico(correo, correo, tip, esp, nom, correo, esp, DNI)
        }*/

    public String getdTip() {
        return dTip;
    }

    public void setdTip(String dTip) {
        this.dTip = dTip;
    }

    public String getdCorreo() {
        return dCorreo;
    }

    public String getdPswd() {
        return dPswd;
    }

    public String getdEsp() {
        return dEsp;
    }
}
