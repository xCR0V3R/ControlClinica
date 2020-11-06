

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;import vistaa.*; import metodos.*;


public class ctrlLogueo implements ActionListener{
    Logueo log;
    mLog mlog=new mLog();
    
    public ctrlLogueo(Logueo log){
        this.log=log; mlog.inicializarLog(this.log);
        this.log.btnAcceder.addActionListener(this);
        this.log.btnLogout.addActionListener(this);
        this.log.btnRegistrar.addActionListener(this);
        this.log.btnRetornar.addActionListener(this);
        this.log.btnSalir.addActionListener(this);
        this.log.btnRegistro.addActionListener(this);
        this.log.jmiAyuda.addActionListener(this);
        this.log.jmiForo.addActionListener(this);
        this.log.jmiSitioWeb.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==log.btnLogout){
           System.exit(0);
        }
         if(e.getSource()==log.btnAcceder){
             JOptionPane.showMessageDialog(null, "Registrese 1ero");
        }
        
         if(e.getSource()==log.btnRegistrar){
             log.setVisible(false);
             mlog.inRegistro(log.nuevRegistro,log);
        }
          if(e.getSource()==log.btnLogout){
           System.exit(0);
        }
         if(e.getSource()==log.btnSalir){
           System.exit(0);
        }  
          if(e.getSource()==log.btnRetornar){
           log.nuevRegistro.setVisible(false);
           mlog.inicializarLog(log);
        }
          //evento de Aceptar registro. Llamar a DAO
         if(e.getSource()==log.btnRegistro){
             
             if(log.jcbTipoUser.getSelectedItem().toString().equals("Administrador")){
                 mlog.regAdmi(log);
                JOptionPane.showMessageDialog(null, "Registrado con exito, Admi"); 
             }else{
                 if(log.jcbxEspecialidad1.getSelectedItem().toString().equals("-Seleccionar-")){
                     JOptionPane.showMessageDialog(null, "Ingrese su especialidad");
                     log.jlEspecialidad.setVisible(true);
                     log.jcbxEspecialidad1.setVisible(true);
                  } else{
                     JOptionPane.showMessageDialog(null, "Registrado con exito, Doc");
                     
                 }
             }
             
               
              
        }
         
         if(e.getSource()==log.jmiAyuda){
             mlog.support("https://www.clinicainternacional.com.pe/");
         }
         if(e.getSource()==log.jmiForo){
             mlog.support("https://www.clinicainternacional.com.pe/");
         }
         if(e.getSource()==log.jmiSitioWeb){
             mlog.support("https://www.clinicainternacional.com.pe/");
         }
    }
}
