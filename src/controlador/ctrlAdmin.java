
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;import vistaa.*; import metodos.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ctrlAdmin implements ActionListener{

    pAdmi ad; 
    mAdmi ingresar=new mAdmi();
    mLog url=new mLog();
    DAOLog dao1=new DAOLog();
    Administrador admi;
    //constructor con LOGUEO
       public ctrlAdmin(pAdmi ad, Administrador admi){
        this.ad = ad; this.admi=admi; 
        this.ad.jLBienvenidoA.setText("Bienvenido, "+admi.getNombre().split(" ")[0].trim());
        ingresar.inicializarAdmi(this.ad);
        this.ad.btnConfigUser.addActionListener(this);
        this.ad.btnLogout.addActionListener(this);
        this.ad.btnSalir2.addActionListener(this);
        this.ad.btnSalir3.addActionListener(this);
        this.ad.btnReportes.addActionListener(this);
        this.ad.btnNuevoP.addActionListener(this);
        this.ad.jmiAyuda.addActionListener(this);
        this.ad.btnRetornar1.addActionListener(this);
        this.ad.btnRetornar2.addActionListener(this);
        this.ad.btnRetornar3.addActionListener(this);
        this.ad.jmiAyuda.addActionListener(this);
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
        this.ad.jmiAyuda.addActionListener(this);
        this.ad.btnRetornar1.addActionListener(this);
        this.ad.btnRetornar2.addActionListener(this);
        this.ad.btnRetornar3.addActionListener(this);
        this.ad.jmiAyuda.addActionListener(this);
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
        ingresar.confUser(ad.jfConfigP); 
    }
        if(e.getSource()==ad.btnReportes){
            ad.setVisible(false);
            ingresar.reporteCitas(ad.jfReporteCitas);
        }
        if(e.getSource()==ad.btnNuevoP){
            ad.setVisible(false);
            ingresar.nuevaCitas(ad.jfNuevaCita);
        }
        if(e.getSource()==ad.btnRetornar1){
            ad.setVisible(true);
            ad.jfConfigP.setVisible(false);
        }
        
        if(e.getSource()==ad.btnRetornar2){
            ad.setVisible(true);
            ad.jfReporteCitas.setVisible(false);
        }
        
        if(e.getSource()==ad.btnRetornar3){
            ad.setVisible(true);
            ad.jfNuevaCita.setVisible(false);
        }
        if(e.getSource()==ad.jmiAyuda){
             url.support("https://www.clinicainternacional.com.pe/");
        }
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
