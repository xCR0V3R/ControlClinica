/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JFrame;
import vistaa.pAdmi;


public class mAdmi {
    
    public void inicializarMed(pAdmi ad){ 
        ad.setLocationRelativeTo(null);
        ad.setVisible(true);
    }

    public void confUser(JFrame ad){
        ad.setTitle("Configurar Usuario");
        
        //med.setSize(393, 386);
        ad.setVisible(true);
        ad.setLocationRelativeTo(null);
    }
    
    public void reporteCitas(JFrame ad){
         ad.setTitle("Citas");
         
        // med.setSize(373, 242);
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        
    }
    public void nuevaCitas(JFrame ad){
         ad.setTitle("Citas");
         
        // med.setSize(373, 242);
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        
    }
    
}
