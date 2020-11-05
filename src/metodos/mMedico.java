
package metodos;
import vistaa.*;
import controlador.*;
import javax.swing.*;

public class mMedico {
    mLog log=new mLog();
    
    public void inicializarMed(pMedico med){ 
        med.setTitle("MEDICO");
        med.setLocationRelativeTo(null);
        med.setVisible(true);
        log.esIcono(med);
    }

    public void inicializarConfUser(JFrame med){
        med.setTitle("Configurar Usuario");
        med.setVisible(true);
        med.setLocationRelativeTo(null);
        log.esIcono(med);
    }
    
    public void inicializarCitas(JFrame med){
         med.setTitle("Citas");
         med.setVisible(true);
         med.setLocationRelativeTo(null);
        log.esIcono(med);
    }
}
