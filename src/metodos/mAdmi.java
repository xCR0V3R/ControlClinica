

package metodos;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import modelo.*;import daos.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class mAdmi {
    /*
    String cNom; String cFec; private String dTip;int cDNI;private String dCorreo;private String dPswd;
    private String dEsp;
    
    SimpleDateFormat fordia=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat forhora=new SimpleDateFormat("yyyy-MM-dd");*/
    
    mLog log=new mLog();
    
    
    public void inicializarAdmi(pAdmi ad){ 
         ad.setTitle("ADMINISTRADOR");
        ad.setLocationRelativeTo(null);
        ad.setVisible(true);
        log.esIcono(ad);
    }

    public void confUser(JFrame ad){
        ad.setTitle("Configurar Usuario");
        ad.setVisible(true);
        ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    
    public void reporteCitas(JFrame ad){
         ad.setTitle("Citas");
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    public void nuevaCitas(JFrame ad){
         ad.setTitle("Citas");
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    /*
    public void obtenerData(){
        cNom=log.txtNombr.getText();
        cFec=formato.format(this.log.dateNacimiento.getDate());
        cDNI=Integer.parseInt(this.log.txtDNI.getText());
        dCorreo=log.txCorreo.getText();
        dPswd=log.txContra.getText();
        String tipo="";
        tipo=log.jcbTipoUser.getSelectedItem().toString();
        if(tipo.equals("Medico")) dTip="U002";
        if(tipo.equals("Administrador")) dTip="U001";
        if(tipo.equals("-Seleccionar-")) dTip="U000";
        if(dTip.equals("U002")){
            dEsp=log.jcbxEspecialidad1.getSelectedItem().toString();
        }
        }*/
    
}
