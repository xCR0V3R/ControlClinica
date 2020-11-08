
package daos;
import controlador.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import modelo.*;
import vistaa.*;

public class DAOCitas {
    /*
    //LISTAR UNA CITA
    
    public List<Cita> lisCita() {
        List<Medico> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from Medico";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Medico a = new Medico();
                a.setCodmed(rs.getString(1));
                a.setCodes(rs.getString(2));
                a.setIptip(rs.getString(3));
                a.setFecha(rs.getString(4));
                a.setCorreo(rs.getString(5));
                a.setPswd(rs.getString(6));
                a.setNombre(rs.getString(7));
                a.setDni(rs.getInt(8));
                lis.add(a);
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
    
    //GENERAR CÓDIGO DE ALUMNO SIN STORE PROCEDURE
    public String generaCod(){
        String cod="A0001";
        if(listotAlu().size()==0){
            return cod;
        }else{
            int fin=listotAlu().size()-1;//Definir en números cual es el último número del código
            cod=listotAlu().get(fin).getCoda();//Una vez definido el número, lo ubicas en el sistema de "A000?"
            int nro=Integer.parseInt(cod.substring(1))+1;//Aquí le aumentas el valor de 1 a la parte numérica
            DecimalFormat sd=new DecimalFormat("0000");//Aquí se define el formato del número "A000?"
            cod="A"+sd.format(nro);//Se usa el formato "A000?" aumentándole el número que obtuvimos consecuente al último valor
        }
        return c
    
    public void addCita(Usuario u) {
        int resp = 0;           
        Connection conn = null; 
        try {
            String sql = "Insert into Cita values(?,?,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,genCodMed());
            st.setString(2,a.getCodes());
            st.setString(3, a.getIptip());
            st.setString(4, a.getFecha());
            st.setString(5, a.getCorreo());
            st.setString(6, a.getPswd());
            st.setString(7, a.getNombre());
            st.setInt(8, a.getDni());
            resp = st.executeUpdate();
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

    }*/
}