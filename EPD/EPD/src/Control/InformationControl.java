/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Anamnese;
import Entity.BloedDruk;
import Entity.DataBaseimplementation;
import Entity.DataInterface;
import Entity.DataTestDataImplementation;
import Entity.DataWebServiceImplementation;
import Entity.Rapport;
import Entity.TimeLineItem;

import java.util.ArrayList;

/**
 *
 * @author Jan
 */
public class InformationControl implements DataInterface {
     
    private static InformationControl instance = null;
   
    DataInterface  testData,database,webService;
    
    public InformationControl(){
        testData = new DataTestDataImplementation();
        database = new DataBaseimplementation();
        webService =  new DataWebServiceImplementation();        
    }
    
    @Override
    public ArrayList<TimeLineItem> getAllTimeLineItems(int patientID) {
       return database.getAllTimeLineItems(patientID);
      //  return webService.getAllTimeLineItems(patientID);
    }  

    @Override
    public boolean newBloedDruk(BloedDruk bloedDruk) {
       return database.newBloedDruk(bloedDruk);
    }

    @Override
    public boolean updateBloedDruk(BloedDruk bloedDruk) {
       return database.updateBloedDruk(bloedDruk);
    }

    @Override
    public boolean deleteBloedDruk(BloedDruk bloedDruk) {
       return database.deleteBloedDruk(bloedDruk);
    }
  
      public static InformationControl getInstance()
    {
        if (instance == null)
                instance = new InformationControl();
        return instance;
    }

    @Override
    public ArrayList<BloedDruk> getBloedDrukByPatientID(int ID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Rapport> getRapportByPatientID(int ID) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public ArrayList<Anamnese> getAnamneses() {
        return database.getAnamneses();
    }
}
