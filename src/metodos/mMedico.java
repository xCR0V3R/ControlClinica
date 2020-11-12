
package metodos;
import vistaa.*;import daos.*;
import controlador.*;
import entidades.Medico;
import java.awt.Image;
import javax.swing.*;

public class mMedico {
    mLog log=new mLog();
    DAOLog dao=new DAOLog();
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
    
      public void welcome(pMedico vmed,Medico med){
        dao.actAsis(med.getCodmed(), "SI");
       String inicio="";
        if(med.getSexo()=='F'){
            inicio="Bienvenida, ";
            vmed.btnImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/docF.png")));
        }
        if(med.getSexo()=='M'){
            inicio="Bienvenido, ";
            vmed.btnImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/docM.png")));
        }   
        vmed.jLBienvenidoD.setText(inicio+med.getNombre().split(" ")[0].trim());
    }
      
      
}
