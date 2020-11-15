
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

public class ctrlAdmin implements ActionListener {

    pAdmi ad; 
    mAdmi ingresar=new mAdmi();
    mLog url=new mLog();
    DAOLog dao1=new DAOLog();
    DAOCitas dao2=new DAOCitas();
    Administrador admi;
    Horario hor=new Horario();
    //constructor con LOGUEO
       public ctrlAdmin(pAdmi ad, Administrador admi){
        this.ad = ad; this.admi=admi; 
        ingresar.welcome(this.ad, this.admi);
        ingresar.inicializarAdmi(this.ad);
        this.ad.btnConfigUser.addActionListener(this);
        this.ad.btnLogout.addActionListener(this);
        this.ad.btnSalir2.addActionListener(this);
        this.ad.btnSalir3.addActionListener(this);
        this.ad.btnReportes.addActionListener(this);
        this.ad.btnNuevoP.addActionListener(this);
        this.ad.btnRetornar1.addActionListener(this);
        this.ad.btnRetornar2.addActionListener(this);
        this.ad.btnRetornar5.addActionListener(this);
        this.ad.btnRetornar6.addActionListener(this);
        this.ad.btnRetornar3.addActionListener(this);
        this.ad.btnAsistenciaM.addActionListener(this);
        this.ad.btnReiniciar.addActionListener(this);
        this.ad.btnHorarioCostos.addActionListener(this);
        
        //VALOR EXTRA - AYUDA
        this.ad.jmiAyuda1.addActionListener(this);
        this.ad.jmiAyuda2.addActionListener(this);
        this.ad.jmiForo.addActionListener(this);
        this.ad.jmiForo1.addActionListener(this);
        this.ad.jmiForo2.addActionListener(this);
        this.ad.jmiSitioWeb.addActionListener(this);
        this.ad.jmiSitioWeb1.addActionListener(this);
        this.ad.jmiSitioWeb2.addActionListener(this);
    } 
    
        
    //constructor para prueba sin LOGUEO
    public ctrlAdmin(pAdmi ad){
        this.ad = ad;
        ingresar.inicializarAdmi(this.ad);
        this.ad.btnConfigUser.addActionListener(this);
        this.ad.btnLogout.addActionListener(this);
        this.ad.btnSalir2.addActionListener(this);
        this.ad.btnSalir3.addActionListener(this);
        this.ad.btnReportes.addActionListener(this);
        this.ad.btnNuevoP.addActionListener(this);
         this.ad.btnRetornar1.addActionListener(this);
        this.ad.btnRetornar2.addActionListener(this);
        this.ad.btnRetornar3.addActionListener(this);
        this.ad.btnRetornar5.addActionListener(this);
        this.ad.btnRetornar6.addActionListener(this);
        this.ad.btnBuscar1.addActionListener(this);
        this.ad.btnRegistrar.addActionListener(this);
        this.ad.btnAsistenciaM.addActionListener(this);
        this.ad.btnReiniciar.addActionListener(this);
        this.ad.btnMostrarCita.addActionListener(this);
        this.ad.jcbxEspecialidadNC.addActionListener(this);
        this.ad.jcbxDoctorNC.addActionListener(this);
        this.ad.btnHorario.addActionListener(this);
        this.ad.btnHorarioCostos.addActionListener(this);
        this.ad.jcbArea.addActionListener(this); 
        this.ad.jcbMedicos.addActionListener(this);
        
         //VALOR EXTRA - AYUDA
         this.ad.jmiAyuda1.addActionListener(this);
        this.ad.jmiAyuda2.addActionListener(this);
        this.ad.jmiForo.addActionListener(this);
        this.ad.jmiForo1.addActionListener(this);
        this.ad.jmiForo2.addActionListener(this);
        this.ad.jmiSitioWeb.addActionListener(this);
        this.ad.jmiSitioWeb1.addActionListener(this);
        this.ad.jmiSitioWeb2.addActionListener(this); 
        
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ad.btnLogout){
           System.exit(0);
        }
        if(e.getSource()==ad.btnSalir2){
           System.exit(0);
        }
        if(e.getSource()==ad.btnSalir3){
           System.exit(0);
        }
        if(e.getSource()==ad.btnConfigUser){
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");   
        SimpleDateFormat formato2=new SimpleDateFormat("dd/MM/yyyy"); 
        Date fechaconv=null;            
        ad.configNombre.setText(admi.getNombre());
        ad.configCorreo.setText(admi.getCorreo());
         try {
                fechaconv=formato.parse(admi.getFecha());
                ad.configNac.setDate(fechaconv);
            } catch (Exception ex) {
                System.out.println("F");
            }
       
        ad.configPswd.setText(admi.getPswd());
        ad.setVisible(false); 
        ingresar.inVentanasExtra(ad.jfConfigP, "Configurar Usuario");
        
    }
        if(e.getSource()==ad.btnReportes){
            ad.setVisible(false);
            ingresar.inVentanasExtra(ad.jfReporteCitas, "Citas"); 
          }
        if(e.getSource()==ad.btnNuevoP){
            ad.setVisible(false);
            ingresar.inVentanasExtra(ad.jfNuevaCita, "Citas");
        } 
        
        if(e.getSource()==ad.btnMostrarCita){
            ingresar.visualizarListaCita(ad.jTReportCitaA, admi.getNombre());
            ad.setVisible(false);
            //ingresar.inVentanasExtra(ad.jfReporteCitas,admi.getNombre());
        } 
        if(e.getSource()==ad.jcbArea){
            String es=" ", codEsp=" "; 
            es=ad.jcbArea.getSelectedItem().toString(); 
            if(es.equals("Medicina General")) codEsp="E01";
            if(es.equals("Obstetricia")) codEsp="E02";
            if(es.equals("Odontologia")) codEsp="E03";
            if(es.equals("Oftalmologia")) codEsp="E04";
            ad.jcbMedicos.removeAllItems();
            ad.jcbMedicos.addItem("-Seleccionar-");
            List<Medico> lista=dao2.lisMedEs(codEsp);
            int max=lista.size();
            for (int i = 0; i < max ; i++) {
                ad.jcbMedicos.addItem(dao2.lisMedEs(codEsp).get(i).getNombre());
            }
        }
        
        //BotonesRetornar
        if(e.getSource()==ad.btnRetornar1){
            ad.setVisible(true);
            ad.jfConfigP.setVisible(false);
        }        
        if(e.getSource()==ad.btnRetornar2){
            ad.setVisible(true);
            ad.jfReporteCitas.setVisible(false);
        }
        
        if(e.getSource()==ad.btnRetornar5){
            ad.setVisible(true);
            ad.jfAsisMedica.setVisible(false);
        }        
        if(e.getSource()==ad.btnRetornar3){
            ad.setVisible(true);
            ad.jfNuevaCita.setVisible(false);
        }
        if(e.getSource()==ad.btnRetornar6){
            ad.setVisible(true);
            ad.jfModHoraCoste.setVisible(false);
        }
        
        if(e.getSource()==ad.jcbxEspecialidadNC){
            String tipo="";
            String cEsp="";
            tipo=ad.jcbxEspecialidadNC.getSelectedItem().toString();
            if(tipo.equals("Medicina General")) cEsp="E01";
            if(tipo.equals("Obstetricia")) cEsp="E02";
            if(tipo.equals("Odontologia")) cEsp="E03";
            if(tipo.equals("Oftalmologia")) cEsp="E04";
            ad.jcbxDoctorNC.removeAllItems();
            ad.jcbxDoctorNC.addItem("-Seleccionar-");
            List<Medico> listaM=dao2.lisMedEs(cEsp);
            int max=listaM.size();
            for (int i = 0; i < max ; i++) {
                ad.jcbxDoctorNC.addItem(dao2.lisMedEs(cEsp).get(i).getNombre());
            }
        }
        
       /* if(e.getSource()==ad.jcbxDoctorNC){
            if(ad.jcbxDoctorNC.getSelectedIndex()!=0){
            String nomd=ad.jcbxDoctorNC.getSelectedItem().toString();
            hor.setHinicio(dao2.busHoraIni(nomd));
            hor.setHfin(dao2.busHoraFin(nomd));
            ad.taHorario.setText(hor.getHinicio()+"-"+hor.getHfin());}
        }*/
        
        
        if(e.getSource()==ad.btnHorario){
            String nomd=ad.jcbxDoctorNC.getSelectedItem().toString();
            hor.setHinicio(dao2.busHoraIni(nomd));
            hor.setHfin(dao2.busHoraFin(nomd));
            ad.taHorario.setText(hor.getHinicio()+"-"+hor.getHfin());
        }
        
        if(e.getSource()==ad.btnBuscar1){
            String dnit;
            dnit=ad.txtDNI.getText();
            String val= dao2.busPac(dnit);
            if(val.equals("Encontrado")){
                ad.txtNombre.setVisible(false);
                ad.txtNumero.setVisible(false);
                ad.lbNumero.setVisible(false);
                ad.lbNombre.setVisible(false);
                JOptionPane.showMessageDialog(null, "El paciente ya se encuentra Registrado");
            }else{
                ad.txtNombre.setVisible(true);
                ad.txtNumero.setVisible(true);
                ad.lbNumero.setVisible(true);
                ad.lbNombre.setVisible(true);
                JOptionPane.showMessageDialog(null, "El paciente no está registrado, inserte datos de nuevo paciente");
            }
            
        }
        
        if(e.getSource()==ad.btnRegistrar){
            //try{
            ingresar.obtenerData();
            //Cita c= new Cita(ingresar.getcNom(), ingresar.getcFec(), ingresar.getcHor(), ingresar.getcEsp(), ingresar.getcDNI(), ingresar.getcDoc());
            //dao2.addCita(c);
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
            /*}catch (NullPointerException ex) {
              JOptionPane.showMessageDialog(null, "¡Faltan datos por ingresar!\nError: "+ex); 
             }catch(NumberFormatException exx){
                     JOptionPane.showMessageDialog(null, "¡Inserte correctamente su DNI!\nError: "+exx.getMessage()); 
                 }*/
        }
        
        if(e.getSource()==ad.btnAsistenciaM){
        ad.setVisible(false);
        ingresar.inVentanasExtra(ad.jfAsisMedica,"Asistencia");
        ingresar.inTabla(ad);
        }
        
        if(e.getSource()==ad.btnReiniciar){
            ingresar.resetAsis();
        }
        
        if(e.getSource()==ad.btnHorarioCostos){
            ingresar.inVentanasExtra(ad.jfModHoraCoste, "Horarios & Costos");
        }
        
        //VALOR EXTRA-SUPPORT
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
        }
    }
    
}
