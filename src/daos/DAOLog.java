
package daos;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import modelo.*;
import vistaa.*;

public class DAOLog { 
    
    
    public void validarUsuario(String cr){ 
        //Logueo buscar=new Logueo();
        Connection con = null;
        String SQL="select correo from Medico where correo=? ";
        int busqueda=0;
        try {
            con = MySQLConexion.getConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, cr);
            //st.setString(2, pws);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                //String nombre=rs.getString(1);
                System.out.println("entro");
                busqueda=1; 
                if (busqueda==1){
                    JOptionPane.showMessageDialog(null, "Acceso Exitoso");
                    pMedico form=new pMedico(); 
                    form.setVisible(true); 
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso Exitoso");
                    pAdmi form2=new pAdmi(); 
                    form2.setVisible(true);
                }
            }
            System.out.println("check3");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Acceso: Usted no está registrado");
        }
    }
    
    
}
