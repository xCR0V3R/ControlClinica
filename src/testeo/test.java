
package testeo;
import vistaa.*;
import controlador.*;
import daos.*;

public class test {
    
    public static void main(String[] args) {
       VLogueo log=new VLogueo();
       CtrlLogueo cLog=new CtrlLogueo(log); 
        
      /* VMedico med=new VMedico(); 
       CtrlMedico cMed=new CtrlMedico(med);
       
      /* VAdmi ad=new VAdmi();
       CtrlAdmin cAd=new CtrlAdmin(ad);*/
       
    }
}
//La ayuda debe sacar una ventana dentro de la misma aplicación, un JOptionPane