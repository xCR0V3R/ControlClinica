
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
        metAdmi.welcome(this.objAdmi, this.vAdmi.btnImagen, this.vAdmi.jLBienvenidoA, this.objAdmi.getNombre(),0);
        metAdmi.inJcbxEspecialidad();
        metAdmi.nuevosMedicos();
        metAdmi.openJFrame(this.vAdmi,"ADMINISTRADOR");
        //BOTONES
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
        this.vAdmi.btnVolverNH.addActionListener(this);
        this.vAdmi.btnBusPaciente.addActionListener(this);
        this.vAdmi.btnRegistrar.addActionListener(this);
        this.vAdmi.btnAsistenciaM.addActionListener(this);
        this.vAdmi.btnReiniciar.addActionListener(this);
        this.vAdmi.btnMostrarCita.addActionListener(this);
        this.vAdmi.btnHorario.addActionListener(this);
        this.vAdmi.btnActPerfil.addActionListener(this);
        this.vAdmi.btnActReportes.addActionListener(this);
        this.vAdmi.btnActHorarios.addActionListener(this);
        this.vAdmi.btnClean.addActionListener(this);
        this.vAdmi.btnGenCod.addActionListener(this);
        this.vAdmi.btnAddHorario.addActionListener(this);
        this.vAdmi.btnActCosto.addActionListener(this);
        this.vAdmi.btnCleanNC.addActionListener(this);
        this.vAdmi.btnHorarioCostos.addActionListener(this);
        this.vAdmi.btnAsigHor.addActionListener(this);
        this.vAdmi.btnSalir7.addActionListener(this);
        //COMBO BOX
        this.vAdmi.jcbxEspecialidadNC.addActionListener(this);
        this.vAdmi.jcbxDoctorNC.addActionListener(this);
        this.vAdmi.jcbArea.addActionListener(this); 
        this.vAdmi.jcbMedicos.addActionListener(this);
        this.vAdmi.jcbxEspCosto.addActionListener(this);
        this.vAdmi.jcbxEspHorarios.addActionListener(this);
        this.vAdmi.jcbxEspAsignarH.addActionListener(this);
        //TABLAS
        this.vAdmi.jTHorarios.addMouseListener(this);
        this.vAdmi.jTNuevosMedicos.addMouseListener(this);
        //VALOR EXTRA - AYUDA
        this.vAdmi.jmAyudaRC.addMouseListener(this);
        this.vAdmi.jmAyudaNC.addMouseListener(this);
        this.vAdmi.jmAyuda.addMouseListener(this);
        this.vAdmi.jmAyuda2.addMouseListener(this);
        this.vAdmi.jmAyuda3.addMouseListener(this);
        this.vAdmi.jmAyuda4.addMouseListener(this);
        this.vAdmi.jmAyuda5.addMouseListener(this);
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
        if(e.getSource()==vAdmi.btnSalir7){
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
        
         
         if(e.getSource()==vAdmi.btnAsigHor){
             metAdmi.tablaBotonesExtra(vAdmi.jTNuevosMedicos, "", 2);
            metAdmi.openJFrame(vAdmi.jfAsignarHorarios, "Asignar nuevos horarios");
          }        
              
         if(e.getSource()== vAdmi.btnAddHorario){
           metAdmi.addHorarioN();
           metAdmi.tablaBotonesExtra(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString(),1);
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
            metAdmi.costo(vAdmi.jcbxEspecialidadNC.getSelectedItem().toString(), vAdmi.jtxtPrecioNC);
         }
        if(e.getSource()==vAdmi.jcbxEspCosto){
           metAdmi.costo(vAdmi.jcbxEspCosto.getSelectedItem().toString(),vAdmi.jTextCosto);
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
             metAdmi.tablaBotonesExtra(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString(),1);
        }
        
        if(e.getSource()==vAdmi.jcbxEspHorarios){
            metAdmi.tablaBotonesExtra(vAdmi.jTHorarios, vAdmi.jcbxEspHorarios.getSelectedItem().toString(),1);
            //IMPLEMENTAR LA LISTA 
        }
        
         if(e.getSource()==vAdmi.jcbxEspAsignarH){
            metAdmi.tablaShowSchedule();
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
        metAdmi.inTablaAsisMed();
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
        
         if(e.getSource()==vAdmi.btnVolverNH){
            metAdmi.nuevosMedicos();
            vAdmi.setVisible(true);
            vAdmi.jfAsignarHorarios.setVisible(false);
        }
        
        //Actualizar Perfil
        if(e.getSource()==vAdmi.btnActPerfil){
           metAdmi.actDatosUser(objAdmi,objAdmi.getCodad(),vAdmi.configNac,
                                vAdmi.configNombre.getText(),vAdmi.configCorreo.getText(),
                                vAdmi.configPswd.getText());
           metAdmi.welcome(objAdmi, vAdmi.btnImagen,vAdmi.jLBienvenidoA, "",1);
            JOptionPane.showMessageDialog(null, "Datos actualizados");
            
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       if(e.getSource()==vAdmi.jTHorarios){
          metAdmi.metodosinTable(vAdmi.jTHorarios, e, 1);
        }
       if(e.getSource()==vAdmi.jTNuevosMedicos){
          metAdmi.metodosinTable(vAdmi.jTNuevosMedicos, e, 2);
        }
       
        if(e.getSource()==vAdmi.jmAyudaRC){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\nCombo box: Seleccionador que tiene una pestaña desplegable en la que se "
                    + "\npueden elegir entre distintas opciones"
                    + "\nPasos para el uso de esta ventana:"
                    + "\n1-. Seleccione el combo box de la especialidad a la que desea hacer la consulta de citas"
                    + "\n2-. Al seleccionar la especialidad, se muestran los respectivos médicos en el combo box "
                    + "\nde médicos según la especialidad que usted eligió, seleccione el médico al cual desearía"
                    + "\nhacer la consulta de citas"
                    + "\n3-.Al terminar de seleccionar sus opciones de preferencia en el combo box, debe hacerle "
                    + "\n clic al botón 'Mostrar' para que se visualicen los datos en la tabla, en el caso de que"
                    + "\n se haya modificado un dato de la tabla en ese instante, se debería dar clic en el botón"
                    + "\n 'Actualizar' para mostrar los datos nuevos"
                    + "\n4-. Para activar el mecanismo de actualizar, primero se tiene que modificar la tabla, en la columna "
                    + "\n    'Estado' y la fila que pertenezca a la cita a la que le quiere editar el estado, existen 3 tipos"
                    + "\n    de estado, que son el Pendiente, que viene por defecto al agregar una cita, el postergado, cuando"
                    + "\n    el médico o el paciente postergan la cita, y el cancelado, cuando la cita queda cancelada, para que"
                    + "\n    esta última tenga efecto y elimine la cita, se debe presionar el botón 'Actualizar' inmediatamente"
                    + "\n    después de que se modifique el dato en la tabla, para realizar la eliminación de la cita."
                    + "\n5-. Si desea volver a la ventana anterior, de clic en el botón 'Retornar'"
                    + "\n6-. En caso desee salir del programa, de clic en el botón 'Salir'";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(e.getSource()==vAdmi.jmAyudaNC){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\nCombo box: Seleccionador que tiene una pestaña desplegable en la que se "
                    + "\npueden elegir entre distintas opciones"
                    + "\nPasos para el uso de esta ventana:"
                    + "\n1-. Seleccione el combo box de la especialidad a la que desea hacer la agregación de citas"
                    + "\n2-. Al seleccionar la especialidad, se muestran los respectivos médicos en el combo box "
                    + "\nde médicos según la especialidad que usted eligió, seleccione el médico al cual desearía"
                    + "\nhacer la agregación de una cita"
                    + "\n3-.Al terminar de seleccionar sus opciones de preferencia en el combo box, debe hacerle "
                    + "\nclic al botón con ícono de calendario para que se visualicen los horarios de cada médico"
                    + "\n4-. Ingrese el DNI del paciente, y presione en el botón con forma de Lupa, este indicará "
                    + "\nsi es que el paciente ya existe en la base de datos, en caso de que no exista entonces a"
                    + "\nusted se le solicitará ingresar los demás datos del paciente nuevo, que son Nombre y Teléfono"
                    + "\n5-. Luego de rellenar todos los campos, de clic en registrar"
                    + "\n6-. El botón de brocha borra manualmente todos los datos dentro de los recuadros de texto cuando"
                    + "\nusted lo requiera"
                    + "\n7-. Si desea volver a la ventana anterior, de clic en el botón 'Retornar'"
                    + "\n8-. En caso desee salir del programa, de clic en el botón 'Salir'";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(e.getSource()==vAdmi.jmAyuda){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\nSeleccione el botón requerido para acceder a la ventana a la que usted desea ingresar"
                    + "\nSi no desea continuar, accione el botón Salir";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(e.getSource()==vAdmi.jmAyuda2){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\nEn esta ventana se pueden modificar los datos del administrador, tales como Nombre, Fecha de Nacimiento,"
                    + "\ncorreo y contraseña, y luego de eso presionar el botón actualizar para procesar la modificación";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(e.getSource()==vAdmi.jmAyuda3){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\n Este apartado puede se listan la asistencia en el día de los médicos"
                    + "\n En caso de que acabe el día, debe dar click en el botón 'Reiniciar'."
                    + "\n De esta manera al siguiente día todos los médicos deben de marcar de nuevo una asistencia ";
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(e.getSource()==vAdmi.jmAyuda4){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\n //HORARIOS//"
                    + "\n Elija la especialidad para ver todos los horarios disponibles"
                    + "\n MODIFICAR: Seleccione el botón con un lapiz para modificar el horario. Luego dé click en el botón actualizar en caso se haya efectuado un cambio"
                    + "\n ELIMINAR: Seleccione el botón con un tacho para eliminar el horario de dicha fila. Confirme la eliminación 1 o 2 para no eliminarlo"
                    + "\n AÑADIR:   1.Seleccione la especialidad que añadirá el horario en el combobox superior"
                    + "\n           2.Click en el botón de generar ID"
                    + "\n           3.Ingrese los demás datos "
                    + "\n           4.Finalmente dar click en el botón de 'Añadir'"
                    + "\n Nota: En caso que desee limpiar todos los datos en los campos de horario, dar click en el botón con la brocha"
                    + "\n\n  //COSTO//"
                    + "\n En caso quiera modificar algún costo de una especialidad"
                    + "\n 1.Seleccionar la especialidad en el combobox inferior"
                    + "\n 2.Ingresar el nuevo valor de coste para la especialidad"
                    + "\n 3.Dar click en el botón 'Actualizar' y listo." ;
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(e.getSource()==vAdmi.jmAyuda5){
            String mensaje= "-----------------------------Ayuda-----------------------------"
                    + "\n La presente vista es para asignar un horario a un médico nuevo ingresado al sistema"
                    + "\n 1.Revisar los ID de horarios disponibles según la especialidad"
                    + "\n 2.Dar click en la celda de IDHorario y escribir el ID que se asignará al médico"
                    + "\n 3.Dé click en el botón con un lápiz en la fila modificar"
                    + "\n 4.Finalmente elige entre 1 o 2 para aceptar o rechazar lo asignado. Luego de esto, se actualizará en la base de datos con los nuevos datos  ";
            JOptionPane.showMessageDialog(null, mensaje);
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
