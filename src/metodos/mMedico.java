
package metodos;
import vistaa.*;import daos.*;
import controlador.*;
import entidades.Cita;
import entidades.Medico;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class mMedico {
     DAOCitas dao2=new DAOCitas();
     List<Cita> calc=new ArrayList(); 
     DefaultTableModel tabl; 
    mLog log=new mLog();
    DAOLog dao=new DAOLog();
    public void inicializarMed(pMedico med){ 
        med.setTitle("MEDICO");
        med.setLocationRelativeTo(null);
        med.setVisible(true);
        log.esIcono(med);
    }

    public void inicializarConfUser(JFrame med){
        med.setTitle("Configurar Usuario");
        med.setVisible(true);
        med.setLocationRelativeTo(null);
        log.esIcono(med);
    }
    
    public void inicializarCitas(JFrame med){
         med.setTitle("Citas");
         med.setVisible(true);
         med.setLocationRelativeTo(null);
        log.esIcono(med);
    }
    
      public void welcome(pMedico vmed,Medico med){
        dao.actAsis(med.getCodmed(), "SI");
       String inicio="";
        if(med.getSexo()=='F'){
            inicio="Bienvenida, ";
            vmed.btnImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/docF.png")));
        }
        if(med.getSexo()=='M'){
            inicio="Bienvenido, ";
            vmed.btnImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/docM.png")));
        }   
        vmed.jLBienvenidoD.setText(inicio+med.getNombre().split(" ")[0].trim());
    }
      
    public void visualizarReportCita(JTable tabla,String cod){
        String[] cab1={"ID","Fecha","Hora","Nombre Paciente","Estado"};
    String[][] data1={}; 
    tabl=new DefaultTableModel(data1,cab1);
    tabla.setModel(tabl);
        calc=dao2.lisReportCita(cod);  
      for(Cita x:calc){
          String[] fila={x.getIdCita(),x.getDiacit(),x.getHoracit(),x.getNompac(),x.getEstadopac()}; 
          tabl.addRow(fila);
          
      } 
    }  
}
