

package metodos;
import entidades.Administrador;
import vistaa.*;import controlador.*;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import daos.*;
import entidades.Medico;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class mAdmi {
    
    private String cNom; private String cFec; private int cDNI;
    private String cEsp; private String cDoc; private String cHor;
    pAdmi admi;
    String[] cab1={"Codigo","Medic@","CodEsp","Asistio"};
    String[][] data1={};
    DefaultTableModel tablaFE; 
    SimpleDateFormat fordia=new SimpleDateFormat("yyyy-MM-dd");
    DAORegistro dao=new DAORegistro(); DAOLog dao2=new DAOLog();
    //SimpleDateFormat forhora=new SimpleDateFormat("hh:mm:ss");
    
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

    
    public void inVentanasExtra(JFrame ad,String cad){
         ad.setTitle(cad);
         ad.setVisible(true);
         ad.setLocationRelativeTo(null);
        log.esIcono(ad);
    }
    
    public void inTabla(pAdmi vadmi){
        tablaFE=new DefaultTableModel(data1,cab1);
        vadmi.jTAsistencia.setModel(tablaFE);
        TableColumn columna;
        columna=vadmi.jTAsistencia.getColumnModel().getColumn(1);
        columna.setPreferredWidth(150);
        acTabla();
    }
    
    public void acTabla(){
        List<Medico> med=dao.lisMed(); int max=med.size();
        for(int i=0;i<max;i++){
            String[] fila={med.get(i).getCodmed(),med.get(i).getNombre(),med.get(i).getCodes(),med.get(i).getAsistencia()};
            tablaFE.addRow(fila);
        }
    }
    public void borrarTabla(){
        List<Medico> med=dao.lisMed(); int max=med.size();
        for(int i=0;i<max;i++){
             tablaFE.removeRow(i);
        }
    }
    
    public void resetAsis(){
        String asist="NO";
       List<Medico> med=dao.lisMed();int max=med.size();
       for(int i=0;i<max;i++){
           dao2.actAsis(med.get(i).getCodmed(), asist);
       }
       JOptionPane.showMessageDialog(null, "Asistencia Reiniciada");
       acTabla();
       borrarTabla();
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
        cHor=this.admi.txtHora.getText();
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