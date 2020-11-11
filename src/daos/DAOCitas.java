
package daos;
import entidades.*;
import controlador.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import util.MySQLConexion;
import vistaa.*;

public class DAOCitas {
    
    //LISTAR UNA CITA
    
    public List<Cita> lisCita() {
        List<Cita> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select id, feccit, hora, nomp, estado from citas";
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
    
    //GENERAR CÓDIGO DE ALUMNO SIN STORE PROCEDURE
    public String generaCod(){
        String cod="A0001";
        if(lisCita().size()==0){
            return cod;
        }else{
            int fin=lisCita().size()-1;//Definir en números cual es el último número del código
            cod=lisCita().get(fin).getIdCita();//Una vez definido el número, lo ubicas en el sistema de "A000?"
            int nro=Integer.parseInt(cod.substring(1))+1;//Aquí le aumentas el valor de 1 a la parte numérica
            DecimalFormat sd=new DecimalFormat("0000");//Aquí se define el formato del número "A000?"
            cod="A"+sd.format(nro);//Se usa el formato "A000?" aumentándole el número que obtuvimos consecuente al último valor
            return cod;
        }
    }
    
    public void addCita(Cita c) {
        int resp = 0;           
        Connection conn = null; 
        try {
            String sql = "Insert into citas values(?,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,c.getCodmed());
            st.setString(2, c.getDnipac());
            st.setString(3, c.getEstadopac());
            st.setString(4, c.getDiacit());
            st.setString(5, c.getHoracit());
            st.setString(6, generaCod());
            st.setString(7, c.getNompac());
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

    }
    
    public List<Medico> lisMedEs(String id) {
        List<Medico> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select nombre from medico when id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setNombre(rs.getString(1));
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