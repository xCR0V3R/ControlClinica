package util;
import java.sql.*;//n
public class MySQLConexion {
	public static Connection getConexion(){ 
		Connection con = null;
		try { Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://sql10.freemysqlhosting.net/sql10373934"; 
		String usr = "sql10373934";
		String psw = "RfWB6Hvmv3"; 
		con = DriverManager.getConnection(url,usr,psw); 
		//System.out.println("conexion ok");
		} catch (ClassNotFoundException ex)
		{ System.out.println("No hay Driver!!"); } 
		catch (SQLException ex) { System.out.println("Error con la BD "); }
		return con; 
		}
}

