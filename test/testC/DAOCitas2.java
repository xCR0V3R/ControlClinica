
package testC;
import entidades.*;
import controlador.*;
import entidades.Cita;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import vistaa.*; 

public class DAOCitas2 {
   
    public List<Cita> lisCita() {
        List<Cita> lis = new ArrayList<>();
        Connection conn = null; 
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id, dnip, feccit, estado, hora from citas where codmed=?";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getString(1));
                c.setDiacit(rs.getString(2));
                c.setHoracit(rs.getString(3));
                c.setNompac(rs.getString(4));
                c.setEstadopac(rs.getString(5));
                
                lis.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;
    }
        
    
    
}
