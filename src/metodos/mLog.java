

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
    
     public void inRegistro(JFrame log){
        log.setTitle("Registro");
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        log.setIconImage(new ImageIcon(getClass().getResource(URLIcono)).getImage());
     }
}
