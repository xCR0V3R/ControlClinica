
package metodos;
import vistaa.*;import daos.*;
import controlador.*;
import entidades.*;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MethodsMed extends MethodsMain{
    
    DAOCitas daoC = new DAOCitas();
    List<Cita> calc = new ArrayList();
    DefaultTableModel tabl;

    public MethodsMed() {
    }
    
    public void visualizarReportCita(JTable tabla, String cod) {
        String[] cab1 = {"ID", "Fecha", "Hora", "Nombre Paciente", "Estado"};
        String[][] data1 = {};
        tabl = new DefaultTableModel(data1, cab1);
        tabla.setModel(tabl);
        calc = daoC.lisReportCita(cod);
        for (Cita x : calc) {
            String[] fila = {x.getIdCita(), x.getDiacit(), x.getHoracit(), x.getNompac(), x.getEstadopac()};
            tabl.addRow(fila);

        }
    }
    
    public void inHorario(String nom, JLabel dias, JLabel horas){
        Horario hor=daoC.busHorario(nom);
        dias.setText(hor.getDias().toUpperCase());
        horas.setText(hor.getHinicio() + "-" + hor.getHfin());
    }

    
}
