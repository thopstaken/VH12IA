/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Rapport;


import Entity.charts.BloodPressureMeasurement;
import Entity.charts.BloodpressureChart;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jan
 */
public class BloedDruk extends Rapport {
    
    ArrayList onderdruk = new ArrayList<BloodPressureMeasurement>();
    ArrayList bovendruk = new ArrayList<BloodPressureMeasurement>();
    
    
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

    @Override
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
       }       
    }

    @Override
    public void open() {
         BloodpressureChart chart =  new BloodpressureChart();
         chart.setDiastolicList(onderdruk);
         chart.setSystolicList(bovendruk);         
         chart.saveToPNG("C:\\Temp");
    }
    
    @Override
    public void openExcel() {
         BloodpressureChart chart =  new BloodpressureChart();
         chart.setDiastolicList(onderdruk);
         chart.setSystolicList(bovendruk);         
         chart.saveToXsls("C:\\Temp");
    }
    
    
}
