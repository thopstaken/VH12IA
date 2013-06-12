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
public class DataWebServiceImplementation  implements DataInterface {

    @Override
    public ArrayList<TimeLineItem> getAllTimeLineItems(int PatienID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean newBloedDruk(BloedDruk bloedDruk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateBloedDruk(BloedDruk bloedDruk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteBloedDruk(BloedDruk bloedDruk) {
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
    public ArrayList<BloedDruk> getBloedDrukByPatientID(int ID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public ArrayList<Anamnese> getAnamneses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
