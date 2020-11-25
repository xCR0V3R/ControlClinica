
package controlador;
import entidades.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import entidades.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vistaa.*; import metodos.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class CtrlAdmin implements ActionListener, MouseListener{

    VAdmi vAdmi; 
    MethodsAdmi metAdmi;
    DAOHorario daoH=new DAOHorario();
    Administrador objAdmi;
    SimpleDateFormat fordia=new SimpleDateFormat("yyyy-MM-dd");
    
    
       public CtrlAdmin(VAdmi vAdmi, Administrador objAdmi){
        this.vAdmi = vAdmi; this.objAdmi=objAdmi; 
        metAdmi=new MethodsAdmi(this.vAdmi);
        JOptionPane.showMessageDialog(null, "Espere 10 segundos, por favor");
        metAdmi.welcome(this.objAdmi, this.vAdmi.btnImagen, this.vAdmi.jLBienvenidoA, this.objAdmi.getNombre());
        metAdmi.inJcbxEspecialidad();
        metAdmi.openJFrame(this.vAdmi,"ADMINISTRADOR");
        this.vAdmi.btnConfigUser.addActionListener(this);
        this.vAdmi.btnLogout.addActionListener(this);
        this.vAdmi.btnSalir2.addActionListener(this);
        this.vAdmi.btnSalir3.addActionListener(this);
        this.vAdmi.btnReportes.addActionListener(this);
        this.vAdmi.btnNuevoP.addActionListener(this);
         this.vAdmi.btnRetornar1.addActionListener(this);
        this.vAdmi.btnRetornar2.addActionListener(this);
        this.vAdmi.btnRetornar3.addActionListener(this);
        this.vAdmi.btnRetornar5.addActionListener(this);
        this.vAdmi.btnRetornar6.addActionListener(this);
        this.vAdmi.btnBusPaciente.addActionListener(this);
        this.vAdmi.btnRegistrar.addActionListener(this);
        this.vAdmi.btnAsistenciaM.addActionListener(this);
        this.vAdmi.btnReiniciar.addActionListener(this);
        this.vAdmi.btnMostrarCita.addActionListener(this);
        this.vAdmi.jcbxEspecialidadNC.addActionListener(this);
        this.vAdmi.jcbxDoctorNC.addActionListener(this);
        this.vAdmi.btnHorario.addActionListener(this);
        this.vAdmi.btnHorarioCostos.addActionListener(this);
        this.vAdmi.jcbArea.addActionListener(this); 
        this.vAdmi.jcbMedicos.addActionListener(this);
        this.vAdmi.jcbxEspCosto.addActionListener(this);
        this.vAdmi.btnActPerfil.addActionListener(this);
        this.vAdmi.btnActReportes.addActionListener(this);
        this.vAdmi.jcbxEspHorarios.addActionListener(this);
        this.vAdmi.btnActHorarios.addActionListener(this);
        this.vAdmi.btnClean.addActionListener(this);
        this.vAdmi.btnGenCod.addActionListener(this);
        this.vAdmi.btnAddHorario.addActionListener(this);
        this.vAdmi.btnActCosto.addActionListener(this);
        this.vAdmi.jTHorarios.addMouseListener(this);
        this.vAdmi.btnCleanNC.addActionListener(this);
        
        //VALOR EXTRA - AYUDA
        this.vAdmi.jmiAyuda1.addActionListener(this);
        this.vAdmi.jmiAyuda2.addActionListener(this);
        this.vAdmi.jmiForo.addActionListener(this);
        this.vAdmi.jmiForo1.addActionListener(this);
        this.vAdmi.jmiForo2.addActionListener(this);
        this.vAdmi.jmiSitioWeb.addActionListener(this);
        this.vAdmi.jmiSitioWeb1.addActionListener(this);
        this.vAdmi.jmiSitioWeb2.addActionListener(this);
    } 
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vAdmi.btnLogout){
           System.exit(0);
        }
        if(e.getSource()==vAdmi.btnSalir2){
           System.exit(0);
        }
        if(e.getSource()==vAdmi.btnSalir3){
           System.exit(0);
        }
        if(e.getSource()==vAdmi.btnConfigUser){
            metAdmi.configUser(objAdmi, vAdmi.configNombre, vAdmi.configNac, vAdmi.configCorreo, vAdmi.configPswd);
            vAdmi.setVisible(false);
            metAdmi.openJFrame(vAdmi.jfConfigP, "Configurar Usuario");
        }
        
        if(e.getSource()==vAdmi.btnReportes){
            vAdmi.setVisible(false);
            metAdmi.openJFrame(vAdmi.jfReporteCitas, "Citas"); 
          }
        
        if(e.getSource()==vAdmi.btnClean){
            vAdmi.jtxtIdHorario.setText("");
            vAdmi.jtxtDiasH.setText("");
            vAdmi.jtxtHoraEntrada.setText("");
            vAdmi.jtxtHoraSalida.setText("");
          }
        
              
         if(e.getSource()== vAdmi.btnAddHorario){
           metAdmi.addHorarioN();
           metAdmi.tablaHorarios(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString());
          }       
        
        if(e.getSource()==vAdmi.btnNuevoP){
            vAdmi.setVisible(false);
            //Ocultar datos de más en caso el paciente ya esté registrado
            vAdmi.lbNombre.setVisible(false); vAdmi.lbNumero.setVisible(false);
            vAdmi.txtNombre.setVisible(false);vAdmi.txtNumero.setVisible(false);
            vAdmi.jtxtPrecioNC.setEditable(false);
            vAdmi.taHorario.setEditable(false);
            metAdmi.openJFrame(vAdmi.jfNuevaCita, "Citas");
        } 
        
        if(e.getSource()==vAdmi.btnMostrarCita){
            metAdmi.visualizarListaCita(vAdmi.jTReportCitaA, vAdmi.jcbMedicos.getSelectedItem().toString());
            
        } 
        if (e.getSource() == vAdmi.jcbArea) {
            metAdmi.jcbxLisMedicos(vAdmi.jcbMedicos,vAdmi.jcbArea);
         }

        if(e.getSource()==vAdmi.jcbxEspecialidadNC){
            metAdmi.jcbxLisMedicos(vAdmi.jcbxDoctorNC,vAdmi.jcbxEspecialidadNC);
            metAdmi.mostrarCostoNC();
         }
        if(e.getSource()==vAdmi.jcbxEspCosto){
           metAdmi.mostrarCosto();
        }
       
        if(e.getSource()==vAdmi.btnGenCod){
           vAdmi.jtxtIdHorario.setText(daoH.genCodHor());
            //metAdmi.mostrarCosto();
        }
        
        if(e.getSource()==vAdmi.btnHorario){
            metAdmi.mostrarHor();
        }
        
        if(e.getSource()==vAdmi.btnActHorarios){
            metAdmi.actualizarH();
             metAdmi.tablaHorarios(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString());
        }
        
        if(e.getSource()==vAdmi.jcbxEspHorarios){
            metAdmi.tablaHorarios(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString());
            //IMPLEMENTAR LA LISTA 
        }
        
        if (e.getSource() == vAdmi.btnBusPaciente) {
           metAdmi.busPaciente();
        }
        
       if(e.getSource()==vAdmi.btnRegistrar){
            metAdmi.regCita(this.vAdmi);
        }

        
        if(e.getSource()==vAdmi.btnAsistenciaM){
        vAdmi.setVisible(false);
        metAdmi.openJFrame(vAdmi.jfAsisMedica,"Asistencia");
        metAdmi.inTabla();
        }
        
        if(e.getSource()==vAdmi.btnReiniciar){
            metAdmi.resetAsis();
        }
        
        if(e.getSource()==vAdmi.btnHorarioCostos){
            metAdmi.openJFrame(vAdmi.jfModHoraCoste, "Horarios & Costos");
            vAdmi.jtxtIdHorario.setEditable(false);
        }
        
        if(e.getSource()==vAdmi.btnActCosto){
            double c=metAdmi.actualizarCosto();
            vAdmi.jTextCosto.setText(String.valueOf(c));
        }
       
        if(e.getSource()== vAdmi.btnActReportes){
            metAdmi.f5EstadoCita(vAdmi.jTReportCitaA,5);
            metAdmi.visualizarListaCita(vAdmi.jTReportCitaA, vAdmi.jcbMedicos.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        } 
        if (e.getSource()== vAdmi.btnCleanNC){
            metAdmi.limpiarNC(vAdmi);
        }
        
         //BotonesRetornar
        if(e.getSource()==vAdmi.btnRetornar1){
            vAdmi.setVisible(true);
            vAdmi.jfConfigP.setVisible(false);
        }        
        if(e.getSource()==vAdmi.btnRetornar2){
            vAdmi.setVisible(true);
            vAdmi.jfReporteCitas.setVisible(false);
        }
        
        if(e.getSource()==vAdmi.btnRetornar5){
            vAdmi.setVisible(true);
            vAdmi.jfAsisMedica.setVisible(false);
        }        
        if(e.getSource()==vAdmi.btnRetornar3){
            vAdmi.setVisible(true);
            vAdmi.jfNuevaCita.setVisible(false);
        }
        if(e.getSource()==vAdmi.btnRetornar6){
            vAdmi.setVisible(true);
            vAdmi.jfModHoraCoste.setVisible(false);
        }
        
        //Actualizar Perfil
        if(e.getSource()==vAdmi.btnActPerfil){
           metAdmi.actDatosUser(objAdmi,objAdmi.getCodad(),vAdmi.configNac,
                                vAdmi.configNombre.getText(),vAdmi.configCorreo.getText(),
                                vAdmi.configPswd.getText());
            JOptionPane.showMessageDialog(null, "Datos actualizados");
            vAdmi.jfConfigP.setVisible(false);
            vAdmi.setVisible(true);
        }
        
        /*VALOR EXTRA-SUPPORT
        
        if(e.getSource()==ad.jmiAyuda1){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiAyuda2){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiForo){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiForo1){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiForo2){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiSitioWeb){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiSitioWeb1){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==ad.jmiSitioWeb2){
             url.support("https://www.clinicainternacional.com.pe/");
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable jt=vAdmi.jTHorarios;
       if(e.getSource()==jt){
           int column=jt.getColumnModel().getColumnIndexAtX(e.getX());
           int row=e.getY()/jt.getRowHeight();
           if(column<=jt.getColumnCount() && column>=0 && row<=jt.getRowCount() && row >=0){
               Object ob=jt.getValueAt(row, column); 
               if(ob instanceof JButton){
                   ((JButton)ob).doClick();
                   JButton botones=(JButton)ob;
                   if(botones.getName().equals("btnMod")){
                       String cod=String.valueOf(jt.getValueAt(row, 0));
                       metAdmi.modHorario(cod);
                       //JOptionPane.showMessageDialog(null, "MODIFICAR\nCODIGO:"+cod);
                   }
                   if(botones.getName().equals("btnDel")){
                       String cod=String.valueOf(jt.getValueAt(row, 0));
                       int op=0;
                       try{
                            op=Integer.parseInt(JOptionPane.showInputDialog("¿Está seguro que eliminará el horario de código: "+cod
                               +"?\n1.SÍ\n2.NO"));
                            if(op==1) {
                                metAdmi.deleteHorario(cod);
                                metAdmi.tablaHorarios(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString());
                                
                            }
                            if(op==2) JOptionPane.showMessageDialog(null, "ASAAA CASI WE :V");
                       }catch (Exception ex) {
                           JOptionPane.showMessageDialog(null, "¡ERROR! \nDetalle: "+ex);
                       }
                      
                      
                       
                       //JOptionPane.showMessageDialog(null, "ELIMINADO");
                   }
               }
           }
           
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }
    
}
