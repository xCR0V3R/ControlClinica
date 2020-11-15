
package controlador;
import entidades.Horario;
import daos.DAOCitas;
import javax.swing.JOptionPane;
import vistaa.pAdmi;
public class pruebas {

    public static void main(String[] args) {
        Horario hor= new Horario();
        DAOCitas dao2=new DAOCitas();
        pAdmi ad; 
            String nomd="Miguel Lopez Ruca";
            JOptionPane.showMessageDialog(null, dao2.codMedNom("Miguel Lopez Ruca"));
        dao2.codMedNom("Miguel Lopez Ruca");
    }
    
}
