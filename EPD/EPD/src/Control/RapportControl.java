/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Rapport.*;
import Entity.Rapport.Rapport.actionOnRapport;
import java.util.Date;

/**
 *
 * @author Jan
 */
public class RapportControl {
    
   private static RapportControl instance = null;
   
    
   public RapportControl(){    
   }
   
   public Rapport newBloedDruk(String Title,String Omschrijving){
       Rapport newBloedDruk = new BloedDruk(); 
       
       newBloedDruk.setDatum(new Date());
       newBloedDruk.setTitel(Title);
       newBloedDruk.setOmschrijving(Omschrijving); 
       
    return newBloedDruk;
   }
   public Rapport newAnamese(){
       Rapport newAnamese = new Anamese();          
    return newAnamese;
   }
   
   public void addWaarde(actionOnRapport type, Rapport rapport,Object valueA,Object valueB ){       
       rapport.addValue(type, valueA, valueB);           
   }
   public void openRapport(Rapport report){
       report.open();   
   }
   
   
   public static RapportControl getInstance()
    {
        if (instance == null)
                instance = new RapportControl();
        return instance;
    }    
}
