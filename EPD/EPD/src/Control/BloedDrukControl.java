/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Entity.BloedDruk;

import java.util.Calendar;

/**
 *
 * @author Jan
 */
public class BloedDrukControl {
    
 private static BloedDrukControl instance = null;
 
 
   // To Do Save
  public void addBloedDrukMeting(int bovenDruk, int OnderDruk,int Saturatie, String Opmerking){
     //To Do get Bloedrukrapport from patient
     BloedDruk bloeddruk = new BloedDruk();
     bloeddruk.addValue(Entity.BloedDruk.actionOnRapport.AddBovenDruk_BloedDruk, bovenDruk, Calendar.getInstance());
     bloeddruk.addValue(Entity.BloedDruk.actionOnRapport.AddOnderDruk_BloedDruk, OnderDruk, Calendar.getInstance());
     bloeddruk.addValue(Entity.BloedDruk.actionOnRapport.AddSaturation, Saturatie, Calendar.getInstance());
     
     // save
     InformationControl IF = InformationControl.getInstance();
     // new if not present
     IF.newBloedDruk(bloeddruk);   
     //update if not present
    // IF.updateBloedDruk(bloeddruk);    
     
   }   
  
  public void openBloedDrukRaport(BloedDruk bloeddruk){
      bloeddruk.openExcel();  
  }
 
 
 public static BloedDrukControl getInstance()
    {
        if (instance == null)
                instance = new BloedDrukControl();
        return instance;
    }
 
}
