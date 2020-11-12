

package metodos;
import entidades.Administrador;
import entidades.Medico;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import daos.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class mLog {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    DAORegistro dao=new DAORegistro();
    Logueo log;
    String dNom; String dNac; private String dTip;int dDNI;private String dCorreo;private String dPswd;
    private String dEsp; private char dSexo;
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
        if(log.jrbMasculino.isSelected()) dSexo='M';
        if(log.jrbFemenino.isSelected()) dSexo='F';
        else dSexo='X';
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
            Administrador a=new Administrador(dTip,dNac, dNom, dSexo,dCorreo, dPswd, dDNI);
            dao.addAdmi(a);
         }
        
      public void regMed(){
            String codes=dao.busCodEsp(dEsp);
           // Medico md=new Medico(codes, dTip, dNac,dNom,dSexo, dCorreo, dPswd, dDNI);
           // dao.addMed(md);
        }

    public String getdTip() {
        return dTip;
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

    public char getdSexo() {
        return dSexo;
    }
}
