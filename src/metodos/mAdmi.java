

package metodos;

import javax.swing.JFrame;
import vistaa.pAdmi; import metodos.mLog;


public class mAdmi {
    mLog log=new mLog();
    
    public void inicializarAdmi(pAdmi ad){ 
         ad.setTitle("ADMINISTRADOR");
        ad.setLocationRelativeTo(null);
        ad.setVisible(true);
        log.esIcono(ad);
    }

    public void confUser(JFrame ad){
        ad.setTitle("Configurar Usuario");
        ad.setVisible(true);
        ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    
    public void reporteCitas(JFrame ad){
         ad.setTitle("Citas");
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    public void nuevaCitas(JFrame ad){
         ad.setTitle("Citas");
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    
 
    
}
