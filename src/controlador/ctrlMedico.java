
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;import vistaa.*; import metodos.*;

public class ctrlMedico implements ActionListener {
    pMedico med; 
    mMedico ingresar=new mMedico();
    mLog url=new mLog();
    
    public ctrlMedico(pMedico med){
        this.med = med;
        ingresar.inicializarMed(this.med);
        this.med.btnConfigUser.addActionListener(this);
        this.med.btnLogout.addActionListener(this);
        this.med.btnReportes.addActionListener(this);
        this.med.btnVolver.addActionListener(this);
        this.med.btnActualizar.addActionListener(this);
        this.med.jmiAyuda.addActionListener(this);
        this.med.jmiForo.addActionListener(this);
        this.med.jmiSitioWeb.addActionListener(this);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==med.btnLogout){
           System.exit(0);
        } 
        if(e.getSource()==med.btnConfigUser){
        med.setVisible(false); 
        ingresar.inicializarConfUser(med.jfConfigP); 
    } 
        if(e.getSource()==med.btnReportes){
            med.setVisible(false);
            ingresar.inicializarCitas(med.jfCitasMed);
        } 
        if(e.getSource()==med.btnVolver){
           med.jfConfigP.setVisible(false);
           ingresar.inicializarMed(med);
        if(e.getSource()==med.btnActualizar){
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        }
    }
        if(e.getSource()==med.jmiAyuda){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==med.jmiForo){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==med.jmiSitioWeb){
             url.support("https://www.clinicainternacional.com.pe/");
        }
        
}
}
