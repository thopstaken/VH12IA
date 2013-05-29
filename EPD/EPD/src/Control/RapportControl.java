/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Rapport;

import Entity.Rapport;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
   
        public void addRapport(String beschrijving){
           
      Rapport rapport =  new Rapport();      
      rapport.setBeschrijving(beschrijving);
      rapport.setDatum(new Date());
      
      InformationControl IC = InformationControl.getInstance();
      IC.newRapport(rapport);
      //TODO
      //rapport.setPatientID
      //rapport.setBehandelaar
              
     }
     
     public ArrayList<Rapport> getAllreports(int patientID){
         InformationControl IC = InformationControl.getInstance();
         return IC.getRapportByPatientID(patientID);     
     }
	 
   public Rapport newAnamese(){
       Rapport newAnamese = new Anamnese();          
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
