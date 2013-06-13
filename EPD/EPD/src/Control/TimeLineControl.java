/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Entity.BloedDruk;
import Entity.EnumCollection;
import Entity.Rapport;
import Entity.TimeLineItem;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Jan
 */
public class TimeLineControl {
     
    private static TimeLineControl instance = null;   
    
   public TimeLineControl(){       
   
   }
   
   //To Do
   public TimeLineItem addTimeLineItem(int PatientID,Object object,EnumCollection.timeLineType type, String titel, String omschrijving, int IDBehandelaar, Date datum){
       TimeLineItem item = new TimeLineItem();
       
       item.setTitel(titel);
       item.setType(type);
       item.setDatum(datum);
       item.setOmschrijving(omschrijving);   
       item.addActionToTimeLineItem(object, type);
       
       return item;
   }  
  
   //ToDo
   public ArrayList<TimeLineItem> getAllTimeLineItems(int PatientID) throws SQLException{     
    InformationControl IC =   InformationControl.getInstance();    
    return IC.getAllTimeLineItems(PatientID);
    
   }
   
   //Type on item should return the correct type
   public BloedDruk getBloedDrukByTimeLineItem(TimeLineItem item){
       InformationControl IC =   InformationControl.getInstance(); 
       return (BloedDruk)item.getActionFromTimeLineItem();      
   }
    //Type on item should return the correct type
    public Rapport getRapportByTimeLineItem(TimeLineItem item){
       InformationControl IC =   InformationControl.getInstance(); 
       return (Rapport)item.getActionFromTimeLineItem();      
   }
   
   
   public ArrayList<TimeLineItem> OrderTimeLineByDate(ArrayList<TimeLineItem> list){           
       Collections.sort(list);
       return list;
   }
      
   public static TimeLineControl getInstance()
    {
        if (instance == null)
                instance = new TimeLineControl();
        return instance;
    }    
   
}
