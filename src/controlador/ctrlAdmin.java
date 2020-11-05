
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;import vistaa.*; import metodos.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ctrlAdmin implements ActionListener{

    pAdmi ad; 
    mAdmi ingresar=new mAdmi();
    public ctrlAdmin(pAdmi ad){
        this.ad = ad;
        ingresar.inicializarMed(this.ad);
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
            
        }
    }
    
}
