

package daos;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import util.MySQLConexion;
import modelo.*;


public class DAORegistro {
    
     public List<Administrador> lisAdmi() {
        List<Administrador> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from Administrador";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Administrador a = new Administrador();
                a.setCodad(rs.getString(1));
                a.setIptip(rs.getString(2));
                a.setFecha(rs.getString(3));
                a.setCorreo(rs.getString(4));
                a.setPswd(rs.getString(5));
                a.setNombre(rs.getString(6));
                a.setDni(rs.getInt(7));
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
    
    
     public String genCodAdmi() {
        String cod;
        if (lisAdmi().size() == 0) {
            cod = "A001";
        } else {
            int fin = lisAdmi().size() - 1;
            cod = lisAdmi().get(fin).getCodad();
            int nro = Integer.parseInt(cod.substring(1)) + 1;
            DecimalFormat sd = new DecimalFormat("000");
            cod = "A" + sd.format(nro);
        }
        return cod;
    }
    
    public void addAdmi(Administrador a) {
        int resp = 0;           
        Connection conn = null; 
        try {
            String sql = "Insert into Administrador values(?,?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1,genCodAdmi());
            st.setString(2, a.getIptip());
            st.setString(3, a.getFecha());
            st.setString(4, a.getCorreo());
            st.setString(5, a.getPswd());
            st.setString(6, a.getNombre());
            st.setInt(7, a.getDni());
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
    
    public String busCodEsp(String nomes) {
        String cod= "";           
        Connection conn = null; 
        try {
            String sql = "Select codes from Especialidad where nombre=?";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nomes);
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
    
    public List<Medico> lisMed() {
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
    
    public String genCodMed() {
        String cod;
        if (lisMed().size() == 0) {
            cod = "M001";
        } else {
            int fin = lisMed().size() - 1;
            cod = lisMed().get(fin).getCodmed();
            int nro = Integer.parseInt(cod.substring(1)) + 1;
            DecimalFormat sd = new DecimalFormat("000");
            cod = "M" + sd.format(nro);
        }
        return cod;
    }
    
    public void addMed(Medico a) {
        int resp = 0;           
        Connection conn = null; 
        try {
            String sql = "Insert into Medico values(?,?,?,?,?,?,?,?)";
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

    }
    
}
