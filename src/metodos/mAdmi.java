

package metodos;
import entidades.Administrador;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import daos.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class mAdmi {
    
    private String cNom; private String cFec; private int cDNI;
    private String cEsp; private String cDoc; private String cHor;
    
    pAdmi admi;
    
    SimpleDateFormat fordia=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat forhora=new SimpleDateFormat("hh:mm:ss");
    
    private mLog log=new mLog();
    
    public mAdmi(){}
    
    public mAdmi(pAdmi admi){
        this.admi=admi;
        
    }
    
    
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
    
    public void welcome(pAdmi ad, Administrador admi){
       String inicio="";
        if(admi.getSexo()=='F') {
            inicio="Bienvenida, ";
            ad.btnImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/admiF.png")));
        }
        if(admi.getSexo()=='M') {
            inicio="Bienvenido, ";
            ad.btnImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/admiM.png")));
        }   
        ad.jLBienvenidoA.setText(inicio+admi.getNombre().split(" ")[0].trim());
    }
    
    public void obtenerData(){
        cNom=admi.txtNombre.getText();
        cFec=fordia.format(this.admi.dtCita.getDate());
        cHor=forhora.format(this.admi.txtHora.getText());
        cDNI=Integer.parseInt(this.admi.txtDNI.getText());
        cEsp=admi.jcbArea1.getSelectedItem().toString();
        cDoc=admi.cbDoctor1.getSelectedItem().toString();
        }

    public String getcNom() {
        return cNom;
    }

    public void setcNom(String cNom) {
        this.cNom = cNom;
    }

    public String getcFec() {
        return cFec;
    }

    public void setcFec(String cFec) {
        this.cFec = cFec;
    }

    public int getcDNI() {
        return cDNI;
    }

    public void setcDNI(int cDNI) {
        this.cDNI = cDNI;
    }

    public String getcEsp() {
        return cEsp;
    }

    public void setcEsp(String cEsp) {
        this.cEsp = cEsp;
    }

    public String getcDoc() {
        return cDoc;
    }

    public void setcDoc(String cDoc) {
        this.cDoc = cDoc;
    }

    public String getcHor() {
        return cHor;
    }

    public void setcHor(String cHor) {
        this.cHor = cHor;
    }
    
}

/*Nuevas credenciales al entrar a http://www.phpmyadmin.co/ 
Username: a6a425_sistema
Password: sistema123
Server:mysql5031.site4now.net
NombreDataBase: db_a6a425_sistema*/