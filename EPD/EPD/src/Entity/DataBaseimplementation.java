/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jan
 */
public class DataBaseimplementation implements DataInterface {

    DatabaseConnection DBcon;
    public DataBaseimplementation(){
      DBcon = new DatabaseConnection();
    }
    
    @Override
    public ArrayList<TimeLineItem> getAllTimeLineItems(int patientID) {
        ArrayList<TimeLineItem> list = new ArrayList<TimeLineItem>();
        try{
        ResultSet dataSet =  DBcon.runGetDataQuery("SELECT * FROM TIMELINEITEM WHERE PATIENT_ID ="+patientID+")");
        
        while(dataSet.next()){
             
                            String ID = dataSet.getString("TIMELINE_ID");                            
                            String datum = dataSet.getString("DATUM");
                            String type = dataSet.getString("TYPE");
                            String titel = dataSet.getString("TITEL");
                            String omschrijving = dataSet.getString("OMSCHRIJVING");
                            String IDBehandelaar = dataSet.getString("BEHANDELAAR_ID");
                            String rapportID = dataSet.getString("RAPPORT_ID");
                            
                        TimeLineItem item = new TimeLineItem();
                            item.setTitel(titel);
                            item.setType(EnumCollection.fromStringTimeLineType(type));
                            item.setOmschrijving(omschrijving);   
                        list.add(item);
                   }
        }
        catch(Exception ex){
            
        }
        /*TimeLineControl TLC  =  TimeLineControl.getInstance();
     //0 replace with Patient en behandelaat
     TimeLineItem item = TLC.addTimeLineItem(0, EnumCollection.timeLineType.bloedDrukMeting, "BloedDruk meting", Opmerking, 0);
     item.addActionToTimeLineItem(bloeddruk, EnumCollection.timeLineType.bloedDrukMeting);
     */
        return list;
     }
    
    @Override
    public boolean newBloedDruk(BloedDruk bloedDruk) {
       try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

    @Override
    public boolean updateBloedDruk(BloedDruk bloedDruk) {
        try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

    @Override
    public boolean deleteBloedDruk(BloedDruk bloedDruk) {
       try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

   

    @Override
    public ArrayList<Rapport> getRapportByPatientID(int ID) {
        ArrayList<Rapport> rapport_Arraylist = new ArrayList<Rapport>();
        try{
            ResultSet dataSet =  DBcon.runGetDataQuery(

            "SELECT RAPPORT.RAPPORT_ID, RAPPORT.BESCHRIJVING, RAPPORT.DATUM_DT, RAPPORT.USER FROM PATIENT INNER JOIN PATIENT_RAPPORT ON PATIENT.PATIENT_ID = PATIENT_RAPPORT.PATIENT_ID INNER JOIN RAPPORT ON PATIENT_RAPPORT.RAPPORT_VITAL_ID = RAPPORT.RAPPORT_ID WHERE PATIENT_RAPPORT.ACTIVE_IND = 1 AND PATIENT.PATIENT_ID = "+ID+" ORDER BY PATIENT.PATIENT_ID)");

            while(dataSet.next()){
                int rapportID = Integer.parseInt(dataSet.getString("RAPPORT_ID"));
                String beschrijving = dataSet.getString("BESCHRIJVING");
                String user = dataSet.getString("USER");
                Date create_date = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH).parse(dataSet.getString("DATUM_DT"));
                Rapport rapport = new Rapport();
                rapport.setID(rapportID);
                rapport.setBeschrijving(beschrijving);
                rapport.setDatum(create_date);
                rapport.setUser(user);
                rapport_Arraylist.add(rapport);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return rapport_Arraylist;
    }

    @Override
    public boolean newRapport(Rapport rapport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateRapport(Rapport rapport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteRapport(Rapport rapport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BloedDruk> getBloedDrukByPatientID(int ID) {
        
        ArrayList<BloedDruk> bloeddruk_Arraylist = new ArrayList<BloedDruk>();
        
        try{
            ResultSet dataSet =  DBcon.runGetDataQuery(

            "SELECT RAPPORT_VITAL.ONDERDRUK, RAPPORT_VITAL.BOVENDRUK, RAPPORT_VITAL.CREATE_DT, RAPPORT_VITAL.SATURATIE FROM PATIENT INNER JOIN PATIENT_RAPPORT_VITAL ON PATIENT.PATIENT_ID = PATIENT_RAPPORT_VITAL.PATIENT_ID INNER JOIN RAPPORT_VITAL ON PATIENT_RAPPORT_VITAL.RAPPORT_VITAL_ID = RAPPORT_VITAL.RAPPORT_VITAL_ID WHERE PATIENT_RAPPORT_VITAL.ACTIVE_IND = 1 AND PATIENT.PATIENT_ID = "+ID+" ORDER BY PATIENT.PATIENT_ID)");

            while(dataSet.next()){
                int onderdruk = Integer.parseInt(dataSet.getString("ONDERDRUK"));
                int bovendruk = Integer.parseInt(dataSet.getString("BOVENDRUK"));
                int saturatie = Integer.parseInt(dataSet.getString("SATURATIE"));
                Calendar create_date = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
                create_date.setTime(sdf.parse(dataSet.getString("CREATE_DT")));
                BloedDruk bloeddruk = new BloedDruk();
                bloeddruk.addBovenDrukValue(bovendruk, create_date);
                bloeddruk.addOnderDrukValue(onderdruk, create_date);
                bloeddruk.addSaturationValue(saturatie, create_date);
                bloeddruk_Arraylist.add(bloeddruk);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return bloeddruk_Arraylist;
    }

}
