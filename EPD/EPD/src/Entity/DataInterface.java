/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.util.ArrayList;

/**
 *
 * @author Mike Hoogesteger
 * @Copyright 2013
 * 
 */
public interface DataInterface {
    
    //getters
    ArrayList<TimeLineItem> getAllTimeLineItems(int patientID);
    //Worden aangeroepen door getAllTimeLineItems
    ArrayList<BloedDruk> getBloedDrukByPatientID(int ID);
    ArrayList<Rapport> getRapportByPatientID(int ID);
    ArrayList<Anamnese> getAnamneseByPatientID(int ID);
    ArrayList<Task> getTaskByPatientID(int ID);
    
    //inserters   
    boolean newBloedDruk(BloedDruk bloedDruk);
    boolean newRapport(Rapport rapport);
    
    //updaters
    boolean updateBloedDruk(BloedDruk bloedDruk);
    boolean updateRapport(Rapport rapport);
    
    //deleters
    boolean deleteBloedDruk(BloedDruk bloedDruk);
    boolean deleteRapport(Rapport rapport);
   
}
