
package daos;

import entidades.*;
import java.util.List;
import javax.swing.JOptionPane;

public class prueba {

    public static void main(String[] args) {
        
        DAOCitas d= new DAOCitas();
        /*String ok="E02";
        JOptionPane.showMessageDialog(null, d.lisMedEs(ok));*/
        
        /*DAORegistro d= new DAORegistro();
        String ok="E02";
        JOptionPane.showMessageDialog(null, d.lisAdmi());*/
        
        JOptionPane.showMessageDialog(null, d.busPac("42554789"));
    }
    
}
