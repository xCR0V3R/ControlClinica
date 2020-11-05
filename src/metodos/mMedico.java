
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
        
        //med.setSize(393, 386);
        med.setVisible(true);
        med.setLocationRelativeTo(null);
    }
    
    public void inicializarCitas(JFrame med){
         med.setTitle("Citas");
         
        // med.setSize(373, 242);
         med.setVisible(true);
         med.setLocationRelativeTo(null);
        
    }
}
