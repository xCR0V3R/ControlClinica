

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;import vistaa.*; import metodos.*;


public class ctrlLogueo implements ActionListener{
    Logueo log;
    mLog mlog;
    DAOLog a=new DAOLog();
    Logueo log2=new Logueo();    
    public ctrlLogueo(Logueo log){
        this.log=log;  mlog=new mLog(this.log);
        mlog.inicializarLog();
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
             //JOptionPane.showMessageDialog(null, "Registrese 1ero");
        String pws=log.jpssContra.getText();
        String cr=log.jtxtCorreo.getText(); 
            if(a.validarUsuario(cr,pws,log).equals("f")){
                JOptionPane.showMessageDialog(null, "No está registrado \n Usuario-Contraseña incorrecta");
            }
         }
        
         if(e.getSource()==log.btnRegistrar){
             log.setVisible(false);
             mlog.inRegistro();
        }
          if(e.getSource()==log.btnLogout){
           System.exit(0);
        }
         if(e.getSource()==log.btnSalir){
           System.exit(0);
        }  
          if(e.getSource()==log.btnRetornar){
           log.nuevRegistro.setVisible(false);
           mlog.inicializarLog();
        }
          //evento de Aceptar registro. Llamar a DAO
         if(e.getSource()==log.btnRegistro){
             //int c=0;
             try{
                    mlog.obtenerData();  
                    if(mlog.getdCorreo().equals("") || mlog.getdPswd().equals("") || mlog.getdTip().equals("U000")){
                       JOptionPane.showMessageDialog(null, "¡Faltan datos por ingresar!");
                   }else{
                       if(mlog.getdTip()=="U001"){
                       mlog.regAdmi();
                       JOptionPane.showMessageDialog(null, "Registrado con exito, Admi"); 
                       log.setVisible(false);log.nuevRegistro.setVisible(false);
                       ctrlLogueo ctLog=new ctrlLogueo(log2);
                       }
                       if(mlog.getdTip()=="U002"&& mlog.getdEsp().equals("-Seleccionar-")){
                           JOptionPane.showMessageDialog(null, "Ingrese especialidad");
                           log.jlEspecialidad.setVisible(true);
                           log.jcbxEspecialidad1.setVisible(true);
                          
                       }
                       //if(mlog.getdEsp().equals("-Seleccionar-"))c++;
                       if(mlog.getdTip()=="U002"&& !mlog.getdEsp().equals("-Seleccionar-")){
                           mlog.regMed();
                           log.setVisible(false);log.nuevRegistro.setVisible(false);
                       ctrlLogueo ctLog=new ctrlLogueo(log2);
                           JOptionPane.showMessageDialog(null, "Registrado con exito, Doc"); 
                       }
                   }
                     
                 
              }catch (NullPointerException ex) {
              JOptionPane.showMessageDialog(null, "¡Faltan datos por ingresar!\nError: "+ex); 
             }catch(NumberFormatException exx){
                     JOptionPane.showMessageDialog(null, "¡Inserte correctamente su DNI!\nError: "+exx.getMessage()); 
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
