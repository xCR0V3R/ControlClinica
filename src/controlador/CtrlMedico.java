
package controlador;
import entidades.Medico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import daos.*;import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vistaa.*; import metodos.*;

public class CtrlMedico implements ActionListener {
    VMedico vMed; 
    MethodsMed metMed=new MethodsMed();
    Medico objMed;
    DAOLog daoL = new DAOLog();
    
    //Constructor con LOGUEO
     public CtrlMedico(VMedico vMed, Medico objMed){
        this.vMed = vMed; this.objMed=objMed;
        //marcar ASIS
        daoL.actAsis(this.objMed.getCodmed(), "SI");
        metMed.welcome(this.objMed, this.vMed.btnImagen, this.vMed.jLBienvenidoD, this.objMed.getNombre());
        metMed.inHorario(this.objMed.getNombre(), this.vMed.jLDiasAtencion, this.vMed.jLHorariosAtencion);
        metMed.openJFrame(this.vMed, "MEDICO");
        this.vMed.btnConfigUser.addActionListener(this);
        this.vMed.btnLogout.addActionListener(this);
        this.vMed.btnReportes.addActionListener(this);
        this.vMed.btnVolver.addActionListener(this);
        this.vMed.btnActPerfil.addActionListener(this);
        this.vMed.btnLogout1.addActionListener(this);
        this.vMed.btnVolver1.addActionListener(this);
        this.vMed.btnActCitas.addActionListener(this);
        
         //SUPPORT, falta implementar
        this.vMed.jmiAyuda.addActionListener(this);
        this.vMed.jmiForo.addActionListener(this);
        this.vMed.jmiSitioWeb.addActionListener(this);
        this.vMed.jmiAyuda1.addActionListener(this);
        this.vMed.jmiForo1.addActionListener(this);
        this.vMed.jmiSitioWeb1.addActionListener(this);
    } 
                         
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vMed.btnLogout) {
            System.exit(0);
        }

        if (e.getSource() == vMed.btnConfigUser) {
            metMed.configUser(objMed,vMed.configNom, vMed.configNac, vMed.configCorreo, vMed.configPswd);
            vMed.setVisible(false);
            metMed.openJFrame(vMed.jfConfigP, "Configurar Usuario");
            
        }
        if (e.getSource() == vMed.btnReportes) {
            metMed.visualizarReportCita(vMed.tablaReporte, objMed.getCodmed());
            vMed.setVisible(false);
            metMed.openJFrame(vMed.jfCitasMed, "Citas");
        }
        
        if (e.getSource() == vMed.btnVolver) {
            vMed.jfConfigP.setVisible(false);
            metMed.openJFrame(this.vMed, "MEDICO");
        }
        if (e.getSource() == vMed.btnActPerfil) {
            metMed.actDatosUser(objMed, objMed.getCodmed(), 
                    vMed.configNac, vMed.configNom.getText(), 
                    vMed.configCorreo.getText(), vMed.configPswd.getText());
            JOptionPane.showMessageDialog(null, "Datos actualizados");
            vMed.jfConfigP.setVisible(false);
            vMed.setVisible(true);
        }

        if (e.getSource() == vMed.btnLogout1) {
            System.exit(0);
        }

        if (e.getSource() == vMed.btnVolver1) {
            vMed.jfCitasMed.setVisible(false);
            metMed.openJFrame(this.vMed, "MEDICO");
        }
        if (e.getSource() == vMed.btnActCitas) {
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        }

        /*
        if(e.getSource()==vmed.jmiAyuda){
             metLog.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiForo){
             metLog.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiSitioWeb){
             metLog.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiAyuda1){
             metLog.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiForo1){
             metLog.support("https://www.clinicainternacional.com.pe/");
        }
        if(e.getSource()==vmed.jmiSitioWeb1){
             metLog.support("https://www.clinicainternacional.com.pe/");
        }*/
    
}
}
