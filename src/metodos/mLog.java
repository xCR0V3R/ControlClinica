

package metodos;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;

public class mLog {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    
    public void inicializarLog(Logueo log){
        log.setTitle("Sistema CliniMAX");
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        esIcono(log);
    }
    
     public void inRegistro(JFrame loge){
        loge.setTitle("Registro");
        loge.setLocationRelativeTo(null);
        loge.setVisible(true);        
        esIcono(loge);
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
}
