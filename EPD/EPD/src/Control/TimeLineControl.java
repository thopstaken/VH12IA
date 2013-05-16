/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Rapport.Rapport;
import Entity.TimeLineItem;
import Entity.TimeLineItem.timeLineType;
import java.util.ArrayList;

/**
 *
 * @author Jan
 */
public class TimeLineControl {
     
    private static TimeLineControl instance = null;
   
    
   public TimeLineControl(){       
   
   }
   
   //To Do
   public void addTimeLineItem(int PatientID,timeLineType type,String titel, String omschrijving, int  IDBehandelaar){
       TimeLineItem item = new TimeLineItem();
       item.setTitel(titel);
       item.setType(type);
       item.setOmschrijving(omschrijving);       
   }
   //To Do
   public boolean addRapportToTimeLineItem(TimeLineItem item, Rapport report){
       if(item.getReport() != null){
            item.setReport(report);      
            return true;
       }
       else{           
           return false;
       }
   }   
   //ToDo
   public ArrayList<TimeLineItem> getAllTimeLineItems(int PatientID){       
    return null;
   }
   public Rapport getReportByTimeLineItem(TimeLineItem item){
       return item.getReport();
   }
      
   // TO DO
   public void OrderTimeLineBy(){       
   
   }
      
   public static TimeLineControl getInstance()
    {
        if (instance == null)
                instance = new TimeLineControl();
        return instance;
    }    
   
}
