

package metodos;

import com.toedter.calendar.JDateChooser;
import entidades.*;
import daos.*;
import entidades.Medico;
import java.awt.Desktop;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import vistaa.VMedico;



public class MethodsMain {
    private static final String URLIcono="/imagenes/iconoSistema.png";
    private static final String URLDocF="/imagenes/docF.png";
    private static final String URLDocM="/imagenes/docM.png";
    private static final String URLAdmiM="/imagenes/admiM.png";
    private static final String URLAdmiF="/imagenes/admiFe.png";
    DAOLog daoL = new DAOLog();
    DAORegistro daoR=new DAORegistro();
    DAOCitas daoC=new DAOCitas();
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
    
    public void welcome(Usuario user,JButton btn,JLabel label,String nom,int ind){
        String inicio = "";
        if(user.getSexo()== 'F') inicio = "Bienvenida, ";
        if(user.getSexo()== 'M') inicio = "Bienvenido, ";
        
        if(user instanceof Medico ){
            if(ind==1){
                nom=daoL.busMed(((Medico) user).getCodmed()).getNombre();
            }
            if (user.getSexo() == 'F') addIMG(btn, URLDocF);
            if (user.getSexo() == 'M') addIMG(btn, URLDocM);
        }
        if(user instanceof Administrador ){
            if(ind==1){
                nom=daoL.busAdmi(((Administrador) user).getCodad()).getNombre();
            }
            if (user.getSexo() == 'F') addIMG(btn, URLAdmiF);
            if (user.getSexo() == 'M') addIMG(btn, URLAdmiM);
        }
        label.setText(inicio + nom.split(" ")[0].trim());
    }
    
    public void addIMG(JButton btn, String url){
        btn.setIcon(new ImageIcon(getClass().getResource(url)));
    }
    
    public void configUser(Usuario user,JTextField jtfNom ,JDateChooser jdcNac, JTextField jtfCorreo, JTextField jtfPswd){
       String nom="",correo="",fecha="",pswd="";
        if(user instanceof Medico){
           Medico med=daoL.busMed(((Medico) user).getCodmed());
           nom=med.getNombre(); correo=med.getCorreo(); fecha=med.getFecha(); pswd=med.getPswd();
       }
        if(user instanceof Administrador){
          Administrador admi=daoL.busAdmi(((Administrador) user).getCodad());
          nom=admi.getNombre(); correo=admi.getCorreo(); fecha=admi.getFecha(); pswd=admi.getPswd();
       }
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaconv = null;
        jtfNom.setText(nom);
        jtfCorreo.setText(correo);
        try {
                fechaconv = formato.parse(fecha);
                jdcNac.setDate(fechaconv);
            } catch (Exception ex) {
                System.out.println("F");
            }
        jtfPswd.setText(pswd);
        
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
    
   public void actDatosUser(Usuario user, String cod, JDateChooser fac, String nom, String correo, String pswd){
       SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
       String nac=formato.format(fac.getDate());
        daoL.modUser(user,cod,nom, nac,correo,pswd);
    }
   
   public void ajustarColumns(JTable jt, int ind, int siz){
       TableColumn col;
       col=jt.getColumnModel().getColumn(ind);
       col.setPreferredWidth(siz);
   }
   
   public void editarEstado(JTable jt, int ind){
       String[] datos={"Pendiente","Cancelado","Postergado"};
       JComboBox jcb=new JComboBox(datos);
       TableColumn tcol=jt.getColumnModel().getColumn(ind);
       TableCellEditor tce= new DefaultCellEditor(jcb);
       tcol.setCellEditor(tce);
   }
   
   public void f5EstadoCita(JTable jt, int indEs) {
        int col = jt.getRowCount();
        List<Cita> arr = new ArrayList();
        Cita cita;
        Object obEstado, obID;
        String estado = "", id = "";
        for (int j = 0; j < col; j++) {
            obEstado = jt.getValueAt(j, indEs);
            obID = jt.getValueAt(j, 0);
            estado = obEstado.toString();
            id = obID.toString();
            cita = new Cita();
            cita.setIdCita(id);
            cita.setEstadopac(estado);
            arr.add(cita);
         }
    
        daoC.actEstadoCita(arr);
    }
   
}
