/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.util.ArrayList;

/**
 *
 * @author Jan
 */
public interface DataInterface {
    
    //getters
    ArrayList<TimeLineItem> getAllTimeLineItems(int patientID);
    ArrayList<BloedDruk> getBloedDrukByPatientID(int ID);
    ArrayList<Rapport> getRapportByPatientID(int ID);
    ArrayList<Anamnese> getAnamneses();
    
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
