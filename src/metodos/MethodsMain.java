

package metodos;

import com.toedter.calendar.JDateChooser;
import entidades.*;
import daos.*;
import entidades.Medico;
import java.awt.Desktop;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import vistaa.VMedico;



public class MethodsMain {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    private static final String URLDocF="/imagenes/docF.png";
    private static final String URLDocM="/imagenes/docM.png";
    private static final String URLAdmiM="/imagenes/admiM.png";
    private static final String URLAdmiF="/imagenes/admiFe.png";
    DAOLog daoL = new DAOLog();
    DAORegistro daoR=new DAORegistro();

    public MethodsMain() {
    }
    
    public void esIcono(JFrame loge){
         loge.setIconImage(new ImageIcon(getClass().getResource(URLIcono)).getImage());
     }
    
    
    public void openJFrame(JFrame fr, String titulo){
        fr.setTitle(titulo);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        esIcono(fr);
    }
    
    public void welcome(Usuario user,JButton btn,JLabel label,String nom){
        String inicio = "";
        if(user.getSexo()== 'F') inicio = "Bienvenida, ";
        if(user.getSexo()== 'M') inicio = "Bienvenido, ";
        
        if(user instanceof Medico ){
            if (user.getSexo() == 'F') addIMG(btn, URLDocF);
            if (user.getSexo() == 'M') addIMG(btn, URLDocM);
        }
        if(user instanceof Administrador ){
            if (user.getSexo() == 'F') addIMG(btn, URLAdmiF);
            if (user.getSexo() == 'M') addIMG(btn, URLAdmiM);
        }
        label.setText(inicio + nom.split(" ")[0].trim());
    }
    
    public void addIMG(JButton btn, String url){
        btn.setIcon(new ImageIcon(getClass().getResource(url)));
    }
    
    public void configUser(Usuario user,JTextField jtfNom ,JDateChooser jdcNac, JTextField jtfCorreo, JTextField jtfPswd){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaconv = null;
        jtfNom.setText(user.getNombre());
        jtfCorreo.setText(user.getCorreo());
        try {
                fechaconv = formato.parse(user.getFecha());
                jdcNac.setDate(fechaconv);
            } catch (Exception ex) {
                System.out.println("F");
            }
        jtfPswd.setText(user.getPswd());
        
    }
    
     public void mostrarEsp(JComboBox jcb){
            jcb.removeAllItems();
            jcb.addItem("-Seleccionar-");
            List<String> lisEsp = daoR.lisNomEsp();
            int max = lisEsp.size();
            for (int i = 0; i < max; i++) {
                jcb.addItem(lisEsp.get(i));
            }
        }
     
     public String mostrarCodEsp(JComboBox jcb){
         String esp=jcb.getSelectedItem().toString();
         return daoR.busCodEsp(esp);
     }
    
     public void support(String direc){
        if(Desktop.isDesktopSupported()){
               Desktop desk=Desktop.getDesktop();
               if(desk.isSupported(Desktop.Action.BROWSE)){
                   try{
                   URI uri=new URI(direc);
                   desk.browse(uri);
                   }catch (Exception ex) {
                       
                   }
               }
           }
    }
    
     public Medico modObjUser(String cod, JTextField jtfNom ,JDateChooser jdcNac, JTextField jtfCorreo, JTextField jtfPswd){
         Medico m= new Medico();
         m.setCodmed(cod);
         m.setNombre(jtfNom.getText());
         m.setFecha(jtfNom.getText());
         m.setCorreo(jtfNom.getText());
         m.setPswd(jtfNom.getText());
        return m;
    }
     
     public Administrador modObjAd(String cod, JTextField jtfNom ,JDateChooser jdcNac, JTextField jtfCorreo, JTextField jtfPswd){
         Administrador a= new Administrador();
         a.setCodad(cod);
         a.setNombre(jtfNom.getText());
         a.setFecha(jtfNom.getText());
         a.setCorreo(jtfNom.getText());
         a.setPswd(jtfNom.getText());
        return a;
    }
}
