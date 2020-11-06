
package daos;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import modelo.*;
import vistaa.*;

public class DAOLog { 
    Connection con = null;
    
    public void validarUsuario(Medico m){ 
        
        Logueo buscar=new Logueo();
        String pws=String.valueOf(buscar.jpssContra.getPassword());
        int busqueda=0;
        String cr=buscar.jtxtCorreo.getText(); 
        String SQL="select from* Medico where correo='"+cr+"' and pswd='"+pws+"'";
        
        try {
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery(SQL);
            
            if(rs.next()){
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
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Acceso: Usted no está registrado");
        }
    }
    
    
}
