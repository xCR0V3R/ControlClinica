

package metodos;
import vistaa.*;import controlador.*;
import javax.swing.*;

public class mLog {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    
    public void inicializarLog(Logueo log){
        log.setTitle("Sistema CliniMAX");
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        log.setIconImage(new ImageIcon(getClass().getResource(URLIcono)).getImage());
    }
    
     public void inRegistro(JFrame loge){
        loge.setTitle("Registro");
        loge.setVisible(true);
        loge.setLocationRelativeTo(null);
        loge.setSize(600, 800);
        loge.setIconImage(new ImageIcon(getClass().getResource(URLIcono)).getImage());
     }
}
