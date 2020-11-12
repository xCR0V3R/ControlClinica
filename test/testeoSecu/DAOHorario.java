

package testeoSecu;
import entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import util.MySQLConexion;

public class DAOHorario {
    
    
    
    
     public void actualizarHorarios(String a,String hinicio, String hfin){
         
         Connection conn = null;
	 try{
             String sql = "Update horario set hinicio=?, hfin=? where idhor=?";
             conn = MySQLConexion.getConexion();
             System.out.println("PASO 1");
             PreparedStatement st = conn.prepareStatement(sql);
             System.out.println("PASO2");
             st.setString(1, hinicio);
             st.setString(2, hfin);
             st.setString(3, a);
             st.executeUpdate();
	
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

		
	}
     
      public List<String> busHorarios(String id){
          List<String> h = null;
          Connection conn = null;
          
          try {
     conn = MySQLConexion.getConexion();
     String sql = "select hinicio, hfin from horario where idhor=?";
     PreparedStatement st = conn.prepareStatement(sql);
     //relacionar el ? con su variable
     st.setString(1, id);
     ResultSet rs = st.executeQuery();
     //llenar el arraylist con la clase entidad
     if (rs.next()) {
         h = new ArrayList<String>();
         h.add(rs.getString(1));
         h.add(rs.getString(2));
         
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

          return h;
    }
      
     public void addHorario(String cod,String hor,String in, String fin) {
        //int resp = 0;
        Connection conn = null;
        try {
            String sql = "Insert into horario values (?,?,?,?)";
            conn = MySQLConexion.getConexion();

            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, cod);
            st.setString(2, hor);
            st.setString(3, in);
            st.setString(4, fin);
            st.executeUpdate();

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

       // return resp;
    }

     
     
     
}
