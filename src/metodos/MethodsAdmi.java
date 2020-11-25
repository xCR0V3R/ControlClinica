

package metodos;

import entidades.Administrador;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import daos.*;
import entidades.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;




public class MethodsAdmi extends MethodsMain{
    
    VAdmi vAdmi;
    DefaultTableModel tablaFE; 
    DAORegistro daoR=new DAORegistro(); 
    DAOLog daoL=new DAOLog();
    DAOCitas daoC=new DAOCitas();
    DAOHorario daoH=new DAOHorario();
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
        double cost=daoC.busCosto(cod); 
        vAdmi.jTextCosto.setText(String.valueOf(cost));
   } 
      public void mostrarCostoNC(){ 
        String name = vAdmi.jcbxEspecialidadNC.getSelectedItem().toString();
        String cod=daoR.busCodEsp(name);
        double cost=daoC.busCosto(cod); 
        vAdmi.jtxtPrecioNC.setText(String.valueOf(cost));
   }
    
    public void mostrarHor(){
        String nomd = vAdmi.jcbxDoctorNC.getSelectedItem().toString();
        Horario hor=daoH.busHorario(nomd,1);
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
        tablaFE=new DefaultTableModel(data1,cab1); JTable jt=vAdmi.jTAsistencia;
        jt.setModel(tablaFE);
        ajustarColumns(jt, 1, 150);
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
        ajustarColumns(tabla, 3, 135);
        ajustarColumns(tabla, 5, 80);
        editarEstado(tabla, 5);
    }
   
   public double actualizarCosto(){
       String nombre=vAdmi.jcbxEspCosto.getSelectedItem().toString();
       String codes=daoR.busCodEsp(nombre);
       return daoC.actCosto(codes, Double.parseDouble(vAdmi.jTextCosto.getText()));
   }
   
   public void tablaHorarios(JTable tabla,String nombre){
       JButton btnMod=new JButton("");
       btnMod.setName("btnMod");
       JButton btnDel=new JButton("");
       btnDel.setName("btnDel");
       tabla.setDefaultRenderer(Object.class, new Render());
       btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarH.png")));
       btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
        String[] cab1 = {"ID", "Dias", "Horario","Modificar","Eliminar"};
        String[][] data1 = {};
        tabl = new DefaultTableModel(data1, cab1);
        tabla.setModel(tabl); String codes=daoR.busCodEsp(nombre);
        List<Horario> lisH=daoH.lisHorarios(codes);
        
        for (Horario x : lisH) {
            Object[] fila = {x.getIdhor(), x.getDias(), x.getHinicio()+"-"+x.getHfin(),btnMod,btnDel};
           
            tabl.addRow(fila);
        } 
        ajustarColumns(tabla, 2, 80);
       tabla.setRowHeight(30);
    }
   
   public void modHorario(String id){
       Horario h=daoH.busHorario(id, 2);
       vAdmi.jtxtIdHorario.setText(h.getIdhor());
       vAdmi.jtxtDiasH.setText(h.getDias());
       vAdmi.jtxtHoraEntrada.setText(h.getHinicio());
       vAdmi.jtxtHoraSalida.setText(h.getHfin());
   }
   
    public Horario dataH() {
        String codes = daoR.busCodEsp(vAdmi.jcbxEspHorarios.getSelectedItem().toString());
        String id = vAdmi.jtxtIdHorario.getText();
        String days = vAdmi.jtxtDiasH.getText();
        String hi = vAdmi.jtxtHoraEntrada.getText();
        String hf = vAdmi.jtxtHoraSalida.getText();
        Horario h = new Horario(id, codes, days, hi, hf);
        return h;
    }
   
   public void addHorarioN(){
            Horario h=dataH(); String id=h.getIdhor();String days=h.getDias();String hi=h.getHinicio();
            String hf=h.getHfin();String codes=h.getCodes();
            
            if(id.equals("")){
                JOptionPane.showMessageDialog(null, "¡Debe generar un código de cita!");
            }
            if(days.equals("") || hi.equals("  :  ") || hf.equals("  :  ") || codes.equals("")){
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
            }
            if(!id.equals("") && !days.equals("") && !hi.equals("  :  ") && !hf.equals("  :  ") && !codes.equals("")){
               daoH.addHorario(h); 
            }
   }
   
   public void deleteHorario(String id){
       daoH.delHorario(id);
   }
   
   public void actualizarH(){
       Horario h=dataH();
       daoH.actHorarios(h);
   }  
  
   public void limpiarNC(VAdmi f){ 
       f.txtDNI.setText("");
       f.txtNombre.setText("");
       f.txtNumero.setText("");
       f.jtxtPrecioNC.setText("");
       f.taHorario.setText("");
       f.txtHora.setText("");
       f.dtCita.setCalendar(null); 
      f.jcbxEspecialidadNC.setSelectedIndex(0);
      f.jcbxDoctorNC.setSelectedIndex(0);
       f.txtDNI.requestFocus();
       
   }
   
}

