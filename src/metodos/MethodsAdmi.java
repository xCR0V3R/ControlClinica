

package metodos;

import entidades.Administrador;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import daos.*;
import entidades.*;
import java.awt.event.MouseEvent;
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
        mostrarEsp(vAdmi.jcbxEspAsignarH);
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
   
   public void costo(String nom,JTextField prec){
       String cod=daoR.busCodEsp(nom);
        double cost=daoC.busCosto(cod); 
        prec.setText(String.valueOf(cost));
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
    
    public void inTablaAsisMed(){
        String[] cab1={"Codigo","Medic@","Especialidad","Asistio"};
        String[][] data1={};
        tablaFE=new DefaultTableModel(data1,cab1); JTable jt=vAdmi.jTAsistencia;
        jt.setModel(tablaFE);
        ajustarColumns(jt, 0, 55);
        ajustarColumns(jt, 1, 150);
        ajustarColumns(jt, 2, 120);
        ajustarColumns(jt, 3, 50);
        acTabla();
    }
    
     public void tablaShowSchedule(){
         String[] cabecera={"IDHorario","Días","Horario"};String[][] data={};
         DefaultTableModel tabSS=new DefaultTableModel(data, cabecera);JTable jt=vAdmi.jTHorariosDisp;
        jt.setModel(tabSS);
        String name=vAdmi.jcbxEspAsignarH.getSelectedItem().toString();
        String codes=daoR.busCodEsp(name);
        List<Horario> lisH=daoH.lisHorarios(codes); int max=lisH.size();
        for(Horario h:lisH){
            String[] fila={h.getIdhor(),h.getDias(),h.getHinicio()+"-"+h.getHfin()};
            tabSS.addRow(fila);
        }
        ajustarColumns(jt, 2, 95);
        //ajustarColumns(jt, 0, 95);
    }
    
    public void acTabla(){
        List<Medico> med=daoR.asistencia(); int max=med.size();
        for(Medico m:med){
            String[] fila={m.getCodmed(),m.getNombre(),m.getCodes(),m.getAsistencia()}; 
            tablaFE.addRow(fila);
        }
     }
    public void borrarTabla(){
        List<Medico> med=daoR.asistencia(); int max=med.size();
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
   
   public void tablaBotonesExtra(JTable tabla,String nombre,int id){
       JButton btnDel = new JButton("");
       JButton btnMod=new JButton("");
       tabla.setDefaultRenderer(Object.class, new Render());
       btnMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarH.png")));
       String[][] data1 = {};
       
       if(id==1){
           btnMod.setName("btnMod");
           btnDel.setName("btnDel");
           btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
           String[] cab2={"ID","Dias","Horario","Modificar","Eliminar"};
           tabl = new DefaultTableModel(data1, cab2);
           String codes = daoR.busCodEsp(nombre);
           List<Horario> lisH=daoH.lisHorarios(codes);
           for (Horario x : lisH) {
               Object[] fila = {x.getIdhor(), x.getDias(), x.getHinicio() + "-" + x.getHfin(), btnMod, btnDel};
               tabl.addRow(fila);
            }
         
       }
       if(id==2){
           btnMod.setName("btnAdd");
           String[] cab={"Médico","Especialidad","IdHorario","Modificar"};
           tabl = new DefaultTableModel(data1, cab);
           List<Medico> lisM=daoR.lisMedNuevos();
           for(Medico m:lisM){
               Object[] fil={m.getNombre(),m.getCodes(),m.getIdhorario(),btnMod};
               tabl.addRow(fil);
           }
           
       }
        tabla.setModel(tabl);
           ajustarColumns(tabla, 2, 80);
           tabla.setRowHeight(30);
      
        
    }
   
   public void metodosinTable(JTable jt, MouseEvent e,int id){
           int column=jt.getColumnModel().getColumnIndexAtX(e.getX());
           int row=e.getY()/jt.getRowHeight();
           if(column<=jt.getColumnCount() && column>=0 && row<=jt.getRowCount() && row >=0){
               Object ob=jt.getValueAt(row, column); 
               if(ob instanceof JButton){
                   ((JButton)ob).doClick();
                   JButton botones=(JButton)ob;
                
                if(id==1){   
                   if(botones.getName().equals("btnMod")){
                       String cod=String.valueOf(jt.getValueAt(row, 0));
                       modHorario(cod);
                     }
                   if(botones.getName().equals("btnDel")){
                       String cod=String.valueOf(jt.getValueAt(row, 0));
                       int op=0;
                       try{
                            op=Integer.parseInt(JOptionPane.showInputDialog("¿Está seguro que eliminará el horario de código: "+cod
                               +"?\n1.SÍ\n2.NO"));
                            if(op==1) {
                                deleteHorario(cod);
                                tablaBotonesExtra(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString(),1);
                                
                            }
                            if(op==2) JOptionPane.showMessageDialog(null, "ASAAA CASI WE :V");
                       }catch (Exception ex) {
                           JOptionPane.showMessageDialog(null, "¡ERROR! \nDetalle: "+ex);
                       }
                    }
                        }
                if(id==2){
                   if(botones.getName().equals("btnAdd")){
                       String nom=String.valueOf(jt.getValueAt(row, 0));
                       String idhor=String.valueOf(jt.getValueAt(row, 2));
                       //
                        int op=0;
                       try{
                            op=Integer.parseInt(JOptionPane.showInputDialog("¿Está seguro que le asignará el IDHorario:"
                                    +idhor+ " a: "+nom+"?\n1.SÍ\n2.NO"));
                            if(op==1) {
                               
                                daoH.addHorNewMed(idhor, nom);
                                tablaBotonesExtra(vAdmi.jTNuevosMedicos,"",2);
                            }
                            
                       }catch (Exception ex) {
                           JOptionPane.showMessageDialog(null, "¡ERROR! \nDetalle: "+ex);
                       }
                     } 
                }
               }
           }
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
   
   public void nuevosMedicos(){
       String estado="";
       estado=daoL.busNuevosMed();
      vAdmi.btnAsigHor.setText(estado);
      if(estado.equals("Asignar horarios (0)")){
           vAdmi.btnAsigHor.setEnabled(false);
      }
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

