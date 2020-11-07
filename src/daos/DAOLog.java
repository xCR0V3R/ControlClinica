
package daos;
import controlador.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import modelo.*;
import vistaa.*;

public class DAOLog { 
    
    
    public int validarUsuario(String cr, String pws){ 
        //Logueo buscar=new Logueo();
        Connection con = null;
        String SQL="select correo from Medico where correo=? and pswd=?";
        int busqueda=0;
        try {
            con = MySQLConexion.getConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, cr.trim());
            st.setString(2, pws.trim());
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                //String nombre=rs.getString(1);
                System.out.println("entro");
                busqueda=1; 
                if (busqueda==1){
                    JOptionPane.showMessageDialog(null, "Acceso Exitoso doc");
                    pMedico form=new pMedico(); 
                    ctrlMedico ctrmed=new ctrlMedico(form);
                     
                }  
            } else if (busqueda==0){
                
                 String SQL2="select correo from Administrador where correo=? and pswd=?";
                 //int busqueda2=1;
                 PreparedStatement st2 = con.prepareStatement(SQL2);
            st2.setString(1, cr.trim());
            st2.setString(2, pws.trim());
            ResultSet rs2 = st2.executeQuery();
                if (rs2.next()) {
                    //String nombre=rs.getString(1);
                    System.out.println("entro2");
                    busqueda = 2;
                    if (busqueda == 2) {
                        JOptionPane.showMessageDialog(null, "Acceso Exitoso ad"); 
                        pAdmi form2 = new pAdmi();
                        ctrlAdmin ctradm=new ctrlAdmin(form2);
                        
                    }
                }
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        } 
        return busqueda;
    }
    
    
}
