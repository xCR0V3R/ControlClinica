
package daos;

import entidades.*;
import java.sql.*;
import java.text.DecimalFormat;
import util.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DAOHorario {
    
     public List<Horario> allHorarios() {
        List<Horario> lis = new ArrayList<>();
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            String sql = "select * from horario";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Horario h = new Horario();
                h.setIdhor(rs.getString(1));
                h.setCodes(rs.getString(2));
                h.setDias(rs.getString(3));
                h.setHinicio(rs.getString(4));
                h.setHfin(rs.getString(5));
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
    
    
    public Horario busHorario(String nom, int id) {
        Horario h=null;
        Connection conn = null;
        ResultSet rs=null;PreparedStatement st=null;
        try {
            String sql="";
            conn = MySQLConexion.getConexion();
            
            if(id==1){
                sql = "select h.codes, dias, hfin, hinicio, h.idhor\n"
                        + "from horario h inner join medico m\n"
                        + "on h.idhor=m.idhor where nombre=?";
                System.out.println("ENTRO A SQL 1");
            }
            else{
                sql = "select codes, dias, hfin, hinicio, idhor from horario where idhor=?";
            }
            
                st = conn.prepareStatement(sql);
                System.out.println("PASO PreparedStatement");
                st.setString(1, nom);
                rs = st.executeQuery();
                 System.out.println("HIZO EL QUERY");
            if (rs.next()) {
                System.out.println("Entro al WHILE");
                h= new Horario();
                h.setCodes(rs.getString(1));
                h.setDias(rs.getString(2));
                h.setHfin(rs.getString(3));
                h.setHinicio(rs.getString(4));
                h.setIdhor(rs.getString(5));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("entro a esta exception");
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
    
    public List<Horario> lisHorarios(String codes){
         Horario h=null;
         List<Horario> lisH=new ArrayList();
         Connection conn = null;
	 try{
             conn = MySQLConexion.getConexion();
            String sql = "select * from horario where codes=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, codes); 
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                h=new Horario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lisH.add(h);
            }
	
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

	return lisH;	
	}
    
    public String genCodHor(){
        String cod="";
        if(allHorarios().size()==0){
            cod="H001";
        }else{
            int fin=allHorarios().size()-1;//Definir en números cual es el último número del código
            cod=allHorarios().get(fin).getIdhor();//Una vez definido el número, lo ubicas en el sistema de "A000?"
            int nro=Integer.parseInt(cod.substring(2))+1;//Aquí le aumentas el valor de 1 a la parte numérica
            DecimalFormat sd=new DecimalFormat("000");//Aquí se define el formato del número "A000?"
            cod="H"+sd.format(nro);//Se usa el formato "A000?" aumentándole el número que obtuvimos consecuente al último valor
            
        }
        return cod;
    }
    
     public void addHorario(Horario h) {
        Connection conn = null; 
        try {
            String sql = "Insert into horario values(?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, h.getIdhor());
            st.setString(2, h.getCodes());
            st.setString(3,h.getDias());
            st.setString(4, h.getHinicio());
            st.setString(5, h.getHfin());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Horario añadido");
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
     
      public void delHorario(String id) {
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            String sql = "delete from horario where idhor=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Horario eliminado\n...Cargando tabla actualizada");
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
      
         public void actHorarios(Horario h){
         
         Connection conn = null;
	 try{
             String sql = "Update horario set dias=?,hinicio=?,hfin=? where idhor=?";
             conn = MySQLConexion.getConexion();
             
             PreparedStatement st = conn.prepareStatement(sql);
             
             st.setString(1, h.getDias());
             st.setString(2, h.getHinicio());
             st.setString(3, h.getHfin());
             st.setString(4, h.getIdhor());
             st.executeUpdate();
             JOptionPane.showMessageDialog(null, "¡Horario Actualizado!");
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }finally{
			try {
			
				if(conn!= null) conn.close();
			} catch (Exception e2) {}
		}

		
	}
         
         public void addHorNewMed(String id, String nom) {
        Connection conn = null; 
        try {
            String sql = "Update medico set idhor=? where nombre=?";
             conn = MySQLConexion.getConexion();
             
             PreparedStatement st = conn.prepareStatement(sql);
             
             st.setString(1, id);
             st.setString(2, nom);
             st.executeUpdate();
             JOptionPane.showMessageDialog(null, "¡Horario Actualizado!");
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
