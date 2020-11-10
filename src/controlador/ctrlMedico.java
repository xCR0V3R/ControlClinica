
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;import vistaa.*; import metodos.*;

public class ctrlMedico implements ActionListener {
    pMedico vmed; 
    mMedico ingresar=new mMedico();
    mLog url=new mLog();
    Medico med;
    
    //Constructor para LOGUEO
     public ctrlMedico(pMedico vmed,Medico med){
        this.vmed = vmed; this.med=med;
        this.vmed.jLBienvenidoD.setText("Bienvenido, "+med.getNombre().split(" ")[0].trim()); 
        ingresar.inicializarMed(this.vmed);
        this.vmed.btnConfigUser.addActionListener(this);
        this.vmed.btnLogout.addActionListener(this);
        this.vmed.btnReportes.addActionListener(this);
        this.vmed.btnVolver.addActionListener(this);
        this.vmed.btnActualizar.addActionListener(this);
        this.vmed.jmiAyuda.addActionListener(this);
        this.vmed.jmiForo.addActionListener(this);
        this.vmed.jmiSitioWeb.addActionListener(this);
        this.vmed.jmiAyuda1.addActionListener(this);
        this.vmed.jmiForo1.addActionListener(this);
        this.vmed.jmiSitioWeb1.addActionListener(this);
        this.vmed.btnLogout1.addActionListener(this);
        this.vmed.btnVolver1.addActionListener(this);
        this.vmed.btnActualizar1.addActionListener(this);
    } 
                         
    //Constructor para pruebas SIN LOGUEO
    public ctrlMedico(pMedico vmed){
        this.vmed = vmed;
        ingresar.inicializarMed(this.vmed);
        this.vmed.btnConfigUser.addActionListener(this);
        this.vmed.btnLogout.addActionListener(this);
        this.vmed.btnReportes.addActionListener(this);
        this.vmed.btnVolver.addActionListener(this);
        this.vmed.btnActualizar.addActionListener(this);
        this.vmed.jmiAyuda.addActionListener(this);
        this.vmed.jmiForo.addActionListener(this);
        this.vmed.jmiSitioWeb.addActionListener(this);
        this.vmed.jmiAyuda1.addActionListener(this);
        this.vmed.jmiForo1.addActionListener(this);
        this.vmed.jmiSitioWeb1.addActionListener(this);
        this.vmed.btnLogout1.addActionListener(this);
        this.vmed.btnVolver1.addActionListener(this);
        this.vmed.btnActualizar1.addActionListener(this);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vmed.btnLogout){
           System.exit(0);
        } 
        if(e.getSource()==vmed.btnConfigUser){
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");   
        SimpleDateFormat formato2=new SimpleDateFormat("dd/MM/yyyy"); 
        Date fechaconv=null;
        vmed.configNom.setText(med.getNombre());
        vmed.configCorreo.setText(med.getCorreo());
        
            try {
                fechaconv=formato.parse(med.getFecha());
                vmed.configNac.setDate(fechaconv);
            } catch (Exception ex) {
                System.out.println("F");
            }
       
        vmed.configPswd.setText(med.getPswd());    
        vmed.setVisible(false); 
        ingresar.inicializarConfUser(vmed.jfConfigP); 
    }
        if(e.getSource()==vmed.btnReportes){
            vmed.setVisible(false);
            ingresar.inicializarCitas(vmed.jfCitasMed);
        }
        if(e.getSource()==vmed.btnVolver){
           vmed.jfConfigP.setVisible(false);
           ingresar.inicializarMed(vmed);
        }
        if(e.getSource()==vmed.btnActualizar){
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        }
        if(e.getSource()==vmed.jmiAyuda){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiForo){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiSitioWeb){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiAyuda1){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiForo1){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiSitioWeb1){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.btnLogout1){
           System.exit(0);
        } 
        
        if(e.getSource()==vmed.btnVolver1){
           vmed.jfCitasMed.setVisible(false);
           ingresar.inicializarMed(vmed);
        }
        if(e.getSource()==vmed.btnActualizar1){
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        }
    
}
}
