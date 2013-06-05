/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jan
 */
public class BloedDruk{
    
    ArrayList onderdruk = new ArrayList<BloodPressureMeasurement>();
    ArrayList bovendruk = new ArrayList<BloodPressureMeasurement>();
    ArrayList Saturatie = new ArrayList<SaturationMeasurement>();    
    int PatientID;
    Date date;
    String behandelaar;
    
    
    public BloedDruk(){       
        
    }
    
    public void addOnderDrukValue(int value,Calendar valueb){
        System.out.println("Onderdruk" + value);
        onderdruk.add(new BloodPressureMeasurement(value,valueb) );       
    }
    
    public void addBovenDrukValue(int value,Calendar valueb){
        System.out.println("Bovendruk"+ value);
        bovendruk.add(new BloodPressureMeasurement(value,valueb) );       
    }
    
    public void addSaturationValue(int value,Calendar valueb){
        System.out.println("Saturation"+ value);
        Saturatie.add(new SaturationMeasurement(value,valueb) );       
    }

    
    public void addValue(actionOnRapport type, Object valueA, Object valueB) {
       
       if(type == actionOnRapport.AddOnderDruk_BloedDruk ||type == actionOnRapport.AddBovenDruk_BloedDruk  ){
            int value = (Integer)valueA;
            Calendar valueb = (Calendar)valueB;
            if(type == actionOnRapport.AddOnderDruk_BloedDruk ){
                   addOnderDrukValue(value,valueb);
            }           
            else if(type == actionOnRapport.AddBovenDruk_BloedDruk ){           
                    addBovenDrukValue(value,valueb);
            }
            else if(type == actionOnRapport.AddSaturation ){           
                    addBovenDrukValue(value,valueb);
            }
       }       
    }

   
    public void open() {
         BloodpressureChart chart =  new BloodpressureChart();
         chart.setDiastolicList(onderdruk);
         chart.setSystolicList(bovendruk);         
         chart.saveToPNG("C:\\Temp");
    }
    
  
    public void openExcel() {
         BloodpressureChart chart =  new BloodpressureChart();
         chart.setDiastolicList(onderdruk);
         chart.setSystolicList(bovendruk);         
         chart.saveToXsls("C:\\Temp");
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setBehandelaar(String behandelaar) {
        this.behandelaar = behandelaar;
    }

    public String getBehandelaar() {
        return behandelaar;
    }

    public enum actionOnRapport{
        AddOnderDruk_BloedDruk,
        AddBovenDruk_BloedDruk,
        AddSaturation
    }
    
}
