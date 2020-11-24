
package controlador;
import entidades.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import entidades.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vistaa.*; import metodos.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CtrlAdmin implements ActionListener {

    VAdmi vAdmi; 
    MethodsAdmi metAdmi;
    DAOCitas dao2=new DAOCitas();
    Administrador objAdmi;
    
    SimpleDateFormat fordia=new SimpleDateFormat("yyyy-MM-dd");
    
    //constructor con LOGUEO
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
    
    //constructor para prueba sin LOGUEO
    public CtrlAdmin(VAdmi vAdmi){
        this.vAdmi = vAdmi;metAdmi=new MethodsAdmi(this.vAdmi);
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
            metAdmi.configUser(objAdmi, vAdmi.configNombre, vAdmi.configNac, vAdmi.jtxtCorreoConfig, vAdmi.jtxtPswdCP);
            vAdmi.setVisible(false);
            metAdmi.openJFrame(vAdmi.jfConfigP, "Configurar Usuario");
        }
        
        if(e.getSource()==vAdmi.btnReportes){
            vAdmi.setVisible(false);
            metAdmi.openJFrame(vAdmi.jfReporteCitas, "Citas"); 
          }
        
        if(e.getSource()==vAdmi.btnNuevoP){
            vAdmi.setVisible(false);
            //Ocultar datos de más en caso el paciente ya esté registrado
            vAdmi.lbNombre.setVisible(false); vAdmi.lbNumero.setVisible(false);
            vAdmi.txtNombre.setVisible(false);vAdmi.txtNumero.setVisible(false);
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
       /* if(e.getSource()==ad.jcbxDoctorNC){
            if(ad.jcbxDoctorNC.getSelectedIndex()!=0){
            String nomd=ad.jcbxDoctorNC.getSelectedItem().toString();
            hor.setHinicio(dao2.busHoraIni(nomd));
            hor.setHfin(dao2.busHoraFin(nomd));
            ad.taHorario.setText(hor.getHinicio()+"-"+hor.getHfin());}
        }*/
        
        if(e.getSource()==vAdmi.btnHorario){
            metAdmi.mostrarHor();
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
    
}
