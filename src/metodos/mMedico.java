
package metodos;
import vistaa.*;
import controlador.*;
import javax.swing.*;

public class mMedico {
    
    public void inicializarMed(pMedico med){ 
        med.setLocationRelativeTo(null);
        med.setVisible(true);
    }

    public void inicializarConfUser(JFrame med){
        med.setTitle("Configurar Usuario");
        med.setVisible(true);
        med.setLocationRelativeTo(null);
        //med.setSize(393, 400);
    }
    
    public void inicializarCitas(JFrame med){
         med.setTitle("Citas");
        med.setVisible(true);
        med.setLocationRelativeTo(null);
        //med.setSize(373, 242);
    }
}
