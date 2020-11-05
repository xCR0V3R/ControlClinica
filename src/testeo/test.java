

package testeo;
import vistaa.*;
import controlador.*;
import modelo.*;import daos.*;

public class test {
    
    public static void main(String[] args) {
        //Logueo log=new Logueo();
        //ctrlLogueo cLog=new ctrlLogueo(log); 
        
        //pMedico med=new pMedico(); 
        //ctrlMedico cMed=new ctrlMedico(med);
        
        pAdmi ad=new pAdmi();
        ctrlAdmin cAd=new ctrlAdmin(ad);
    }
}
