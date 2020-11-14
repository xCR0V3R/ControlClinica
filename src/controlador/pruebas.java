
package controlador;
import entidades.Horario;
import daos.DAOCitas;
import javax.swing.JOptionPane;
public class pruebas {

    public static void main(String[] args) {
        Horario hor= new Horario();
        DAOCitas dao2=new DAOCitas();
            String nomd="Miguel Lopez Ruca";
            hor.setHinicio(dao2.busHoraIni(nomd));
            hor.setHfin(dao2.busHoraFin(nomd));
            JOptionPane.showMessageDialog(null, hor.getHinicio()+"-"+hor.getHfin());
        
    }
    
}
