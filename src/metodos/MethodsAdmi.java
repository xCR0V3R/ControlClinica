

package metodos;

import entidades.Administrador;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import daos.*;
import entidades.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MethodsAdmi extends MethodsMain{
    
    VAdmi vAdmi;
    DefaultTableModel tablaFE; 
    DAORegistro daoR=new DAORegistro(); 
    DAOLog daoL=new DAOLog();
    DAOCitas daoC=new DAOCitas();
    DefaultTableModel tabl; 
    
    
    public MethodsAdmi(VAdmi vAdmi){
        this.vAdmi=vAdmi;
    }
    
    public void inJcbxEspecialidad(){
        mostrarEsp(vAdmi.jcbArea);
        mostrarEsp(vAdmi.jcbxEspecialidadNC);
        mostrarEsp(vAdmi.jcbxEspCosto);
        mostrarEsp(vAdmi.jcbxEspHorarios);
    } 
    
    public void jcbxLisMedicos(JComboBox jcbMed, JComboBox jcbEsp){
        String cod2=mostrarCodEsp(jcbEsp);
        jcbMed.removeAllItems();
        jcbMed.addItem("-Seleccionar-");
        List<Medico> lista = daoC.lisMedEs(cod2);
        int max = lista.size();
        for (int i = 0; i < max; i++) {
            jcbMed.addItem(lista.get(i).getNombre());
        }
    } 
   
   public void mostrarCosto(){ 
        String name = vAdmi.jcbxEspCosto.getSelectedItem().toString();
        String cod=daoR.busCodEsp(name);
        int cost=daoC.busCosto(cod); 
        vAdmi.jTextCosto.setText(String.valueOf(cost));
   } 
      public void mostrarCostoNC(){ 
        String name = vAdmi.jcbxEspecialidadNC.getSelectedItem().toString();
        String cod=daoR.busCodEsp(name);
        int cost=daoC.busCosto(cod); 
        vAdmi.jtxtPrecioNC.setText(String.valueOf(cost));
   }
    
    public void mostrarHor(){
        String nomd = vAdmi.jcbxDoctorNC.getSelectedItem().toString();
        Horario hor=daoC.busHorario(nomd);
        vAdmi.taHorario.setText("Dias: " + hor.getDias() + "\n" + hor.getHinicio() + "-" + hor.getHfin());
    }
    
    public void busPaciente(){
        String dnit = vAdmi.txtDNI.getText();
        String val = daoC.busPac(dnit);
        if (val.equals("Encontrado")) {
            JOptionPane.showMessageDialog(null, "El paciente ya se encuentra Registrado");
        } else {
            vAdmi.txtNombre.setVisible(true);
            vAdmi.txtNumero.setVisible(true);
            vAdmi.lbNumero.setVisible(true);
            vAdmi.lbNombre.setVisible(true);
            JOptionPane.showMessageDialog(null, "El paciente no está registrado, inserte datos de nuevo paciente");
        }
    }
    
    public void inTabla(){
        String[] cab1={"Codigo","Medic@","CodEsp","Asistio"};
        String[][] data1={};
        tablaFE=new DefaultTableModel(data1,cab1);
        vAdmi.jTAsistencia.setModel(tablaFE);
        TableColumn columna;
        columna=vAdmi.jTAsistencia.getColumnModel().getColumn(1);
        columna.setPreferredWidth(150);
        acTabla();
    }
    
    public void acTabla(){
        List<Medico> med=daoR.lisMed(); int max=med.size();
        for(int i=0;i<max;i++){
            String[] fila={med.get(i).getCodmed(),med.get(i).getNombre(),med.get(i).getCodes(),med.get(i).getAsistencia()};
            tablaFE.addRow(fila);
        }
    }
    public void borrarTabla(){
        List<Medico> med=daoR.lisMed(); int max=med.size();
        for(int i=0;i<max;i++){
             tablaFE.removeRow(i);
        }
    }
    
    public void regCita(VAdmi vAdmi){
        SimpleDateFormat fordia=new SimpleDateFormat("yyyy-MM-dd");
        Cita c = new Cita();
        c.setCodmed(daoC.codMedNom(vAdmi.jcbxDoctorNC.getSelectedItem().toString()));
        c.setDnipac(Integer.parseInt(vAdmi.txtDNI.getText()));
        c.setDiacit(fordia.format(vAdmi.dtCita.getDate()));
        c.setHoracit(vAdmi.txtHora.getText());
        daoC.addCita(c);
        try {
            Paciente p = new Paciente();
            p.setDni(Integer.parseInt(vAdmi.txtDNI.getText()));
            p.setIdtip("U003");
            p.setNomp(vAdmi.txtNombre.getText());
            p.setNumero(Integer.parseInt(vAdmi.txtNumero.getText()));
            daoC.addPaci(p);
            JOptionPane.showMessageDialog(null, "Paciente registrado");
        } catch (Exception ex) {

        }
        JOptionPane.showMessageDialog(null, "Cita generada");
    }
    
    public void resetAsis(){
        String asist="NO";
       List<Medico> med=daoR.lisMed();int max=med.size();
       for(int i=0;i<max;i++){
           daoL.actAsis(med.get(i).getCodmed(), asist);
       }
       JOptionPane.showMessageDialog(null, "Asistencia Reiniciada");
       acTabla();
       borrarTabla();
    }
    
   public void visualizarListaCita(JTable tabla,String nombre){
        String[] cab1 = {"Nro Cita", "Hora", "Fecha Cita", "Nombre Paciente", "DNI", "Estado"};
        String[][] data1 = {};
        tabl = new DefaultTableModel(data1, cab1);
        tabla.setModel(tabl); 
        List<Cita> calc=new ArrayList(); 
        calc = daoC.lisListarCita(nombre);
        for (Cita x : calc) {
            String[] fila = {x.getIdCita(), x.getHoracit(), x.getDiacit(), x.getNompac(), String.valueOf(x.getDnipac()), x.getEstadopac()};
            tabl.addRow(fila);

        } 
    }  
   public void costoEsp(){
       
   }
    
}

