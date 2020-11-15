
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
            String sql = "select id, hora, feccit, nomp, c.dnip, estado\n" +
                         "from citas c inner join paciente p\n" +
                         "on c.dnip=p.dnip";
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
        String cod="CT0001";
        if(lisCita().size()==0){
            return cod;
        }else{
            int fin=lisCita().size()-1;//Definir en números cual es el último número del código
            cod=lisCita().get(fin).getIdCita();//Una vez definido el número, lo ubicas en el sistema de "A000?"
            int nro=Integer.parseInt(cod.substring(2))+1;//Aquí le aumentas el valor de 1 a la parte numérica
            DecimalFormat sd=new DecimalFormat("0000");//Aquí se define el formato del número "A000?"
            cod="CT"+sd.format(nro);//Se usa el formato "A000?" aumentándole el número que obtuvimos consecuente al último valor
            return cod;
        }
    }
    
    public void addCita(Cita c) {
        int resp = 0;           
        Connection conn = null; 
        try {
            String sql = "Insert into citas values(?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,c.getCodmed());
            st.setInt(2, c.getDnipac());
            st.setString(3, "Pendiente");
            st.setString(4, c.getDiacit());
            st.setString(5, c.getHoracit());
            st.setString(6, generaCod());
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
    public void addPaci(Paciente p) {
        int resp = 0;           
        Connection conn = null; 
        try {
            String sql = "Insert into paciente values(?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,p.getDni());
            st.setString(2, p.getIdtip());
            st.setString(3, p.getNomp());
            st.setInt(4, p.getNumero());
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
    
    
    //public List<Med>
    
    public List<Medico> lisMedEs(String id) {
        List<Medico> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select nombre from medico where codes=?";
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
    
    //lista para hora inicial
    
    public List<Horario> busHorario(String nom) {
        List<Horario> lis= new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select h.codes, dias, hfin, hinicio, h.idhor\n" +
                         "from horario h inner join medico m\n" +
                         "on h.idhor=m.idhor where nombre=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nom);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Horario h= new Horario();
                h.setCodes(rs.getString(1));
                h.setDias(rs.getString(2));
                h.setHfin(rs.getString(3));
                h.setHinicio(rs.getString(4));
                h.setIdhor(rs.getString(5));
                lis.add(h);
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
    
    public String busPac(String id){
        String est="";
        Cita c=null;
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "select dnip from paciente where dnip=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                est="Encontrado";
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
        return est;
    } 
    public List<Cita> lisReportCita(String cod) {
        List<Cita> lis = new ArrayList<>();
        Connection conn = null; 
        try { 
            conn = MySQLConexion.getConexion();
            String sql = "select id, paciente.nomp, feccit, estado, hora from citas INNER JOIN paciente ON citas.dnip=paciente.dnip where codmed=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod); 
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getString(1));
                c.setNompac(rs.getString(2));
                c.setDiacit(rs.getString(3));
                c.setEstadopac(rs.getString(4));
                c.setHoracit(rs.getString(5)); 
                
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
    
    
    public String codMedNom(String nom) {
        String cod="";
        Connection conn = null; 
        try { 
            conn = MySQLConexion.getConexion();
            String sql = "select codmed\n" +
                         "from medico where nombre=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nom); 
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cod=rs.getString(1);
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
        return cod;
    }

  public List<Cita> lisListarCita(String cod) {
        List<Cita> lis = new ArrayList<>();
        Connection conn = null; 
        try { 
            conn = MySQLConexion.getConexion();
            String sql = "select id, paciente.dnip, paciente.nomp, feccit, estado, hora from citas INNER JOIN paciente ON citas.dnip=paciente.dnip INNER JOIN medico ON citas.codmed=medico.codmed where nombre=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cod); 
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdCita(rs.getString(1));
                c.setHoracit(rs.getString(2));
                c.setDiacit(rs.getString(3));
                c.setNompac(rs.getString(4));
                c.setDnipac(rs.getInt(5));
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
