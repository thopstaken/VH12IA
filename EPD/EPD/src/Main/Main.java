/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Control.RapportControl;
import Entity.Rapport.Rapport;
import java.util.Calendar;

/**
 *
 * @author Jan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       RapportControl RC = RapportControl.getInstance();
       Rapport TRapport = RC.newBloedDruk("Test", "TEst");
       
       Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DAY_OF_MONTH, 2);
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(Calendar.DAY_OF_MONTH, 3);

		Calendar cal4 = Calendar.getInstance();
		cal4.set(Calendar.DAY_OF_MONTH, 4);
		
		Calendar cal5 = Calendar.getInstance();
		cal5.set(Calendar.DAY_OF_MONTH, 5);
                
             TRapport.addValue(Rapport.actionOnRapport.AddOnderDruk_BloedDruk, 80,cal1); 
             TRapport.addValue(Rapport.actionOnRapport.AddOnderDruk_BloedDruk, 60,cal2); 
             TRapport.addValue(Rapport.actionOnRapport.AddOnderDruk_BloedDruk, 90,cal3); 
             TRapport.addValue(Rapport.actionOnRapport.AddOnderDruk_BloedDruk, 100,cal4); 
             
             TRapport.addValue(Rapport.actionOnRapport.AddBovenDruk_BloedDruk, 100,cal1 ); 
             TRapport.addValue(Rapport.actionOnRapport.AddBovenDruk_BloedDruk, 120,cal2 ); 
             TRapport.addValue(Rapport.actionOnRapport.AddBovenDruk_BloedDruk, 120,cal3 ); 
             TRapport.addValue(Rapport.actionOnRapport.AddBovenDruk_BloedDruk, 120,cal4 ); 
             TRapport.open();
             TRapport.openExcel();
           
    }
}
