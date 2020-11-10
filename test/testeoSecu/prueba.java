

package testeoSecu;

import entidades.Medico;
import daos.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class prueba {
    public static void main(String[] args) {
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");   
        SimpleDateFormat formato2=new SimpleDateFormat("dd/MM/yyyy"); 
        DAOLog dao=new DAOLog();
        Medico med=dao.busMed("M001");
        String fecha=med.getFecha();
        System.out.println("FECHA SIN CONVERTIR: "+fecha);
        Date fechaconv=null;
        try{
            fechaconv=formato.parse(fecha);
        System.out.println("FECHA NACIMIENTO: "+formato2.format(fechaconv));
        }catch (Exception ex) {
            System.out.println("NO SE PUDO T-T");
        }
        
    }
    
    
}
