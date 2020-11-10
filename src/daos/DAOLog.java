
package daos;
import entidades.Administrador;
import entidades.Medico;
import controlador.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import vistaa.*;

public class DAOLog { 
    
    
    public String validarUsuario(String cr, String pws,Logueo log){ 
        //Logueo buscar=new Logueo();
        Connection con = null;
        String cod="f"; int busqueda=0;
        try {
            String SQL="select codmed from Medico where correo=? and pswd=?";
            con = MySQLConexion.getConexion();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, cr.trim());
            st.setString(2, pws.trim());
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                busqueda=1;
                System.out.println("Entro a Medico");
                cod=rs.getString(1);
                if (busqueda==1){
                    Medico med=busMed(cod);
                    log.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Acceso Exitoso doc");
                    pMedico form=new pMedico(); 
                    ctrlMedico ctrmed=new ctrlMedico(form,med);
                   
                }
                return cod;
            } else if (busqueda==0){
                
                 String SQL2="select codad from Administrador where correo=? and pswd=?";
                 //int busqueda2=1;
                 PreparedStatement st2 = con.prepareStatement(SQL2);
            st2.setString(1, cr.trim());
            st2.setString(2, pws.trim());
            ResultSet rs2 = st2.executeQuery();
                if (rs2.next()) {
                    //String nombre=rs.getString(1);
                    cod=rs2.getString(1);
                    System.out.println("Entro a Administrador");
                    busqueda = 2;
                    if (busqueda == 2) {
                        Administrador admi=busAdmi(cod);
                        log.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Acceso Exitoso ad"); 
                        pAdmi form2 = new pAdmi();
                        ctrlAdmin ctradm=new ctrlAdmin(form2,admi);
                        
                    }
                    return cod;
                }
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        } 
        return cod;
    }
    
        public Administrador busAdmi(String id) {
        Administrador a=null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from Administrador where codad=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a=new Administrador();
                a.setCodad(rs.getString(1));
                a.setIptip(rs.getString(2));
                a.setNombre(rs.getString(3));
                a.setSexo(rs.getString(4).charAt(0));
                a.setFecha(rs.getString(5));
                a.setCorreo(rs.getString(6));
                a.setPswd(rs.getString(6));
                a.setDni(rs.getInt(8));
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

        return a;

    }
        
        public Medico busMed(String id) {
        Medico m=null;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            
            String sql = "select * from Medico where codmed=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                m=new Medico();
                m.setCodmed(rs.getString(1));
                m.setCodes(rs.getString(2));
                m.setIptip(rs.getString(3));
                m.setNombre(rs.getString(4));
                m.setSexo(rs.getString(5).charAt(0));
                m.setFecha(rs.getString(6));
                m.setCorreo(rs.getString(7));
                m.setPswd(rs.getString(8));
                m.setDni(rs.getInt(9));
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

        return m;

    }
    
    
    
    
}
