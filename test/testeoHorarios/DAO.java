
package testeoHorarios;
import entidades.*;
import controlador.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import vistaa.*;

public class DAO {
    
    public List<Medico> lisMedEs(String id) {
        List<Medico> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select idhor, nombre from medico where codes=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setIdhorario(rs.getString(1));
                m.setNombre(rs.getString(2));
                lis.add(m);
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
