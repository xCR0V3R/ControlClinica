

package metodos;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import modelo.*;import daos.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class mLog {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    DAOLog dao=new DAOLog();
    
    public void inicializarLog(Logueo log){
        log.setTitle("Sistema CliniMAX");
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        esIcono(log);
    }
    
     public void inRegistro(JFrame loge, Logueo lo){
        loge.setTitle("Registro");
        loge.setLocationRelativeTo(null);
        loge.setVisible(true);        
        esIcono(loge);
        lo.jlEspecialidad.setVisible(false);
        lo.jcbxEspecialidad1.setVisible(false);
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
        
        public void regAdmi(Logueo log){
            String nom=log.txtNombre.getText();
         /*   SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            String nac=formato.format(log.dtNacimiento.getDate().toString());
            System.out.println("ESTO ES NACIMIENTO: "+nac);*/
            String naci=log.dtNacimiento.getDateFormatString();
            String tip="U001";
            int DNI=Integer.parseInt(log.txtDNI.getText());
            String correo=log.txtCorreo.getText();
            String contra=log.txtContraseña.getText();
            Administrador a=new Administrador(tip, naci, nom, correo, contra, DNI);
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
}
