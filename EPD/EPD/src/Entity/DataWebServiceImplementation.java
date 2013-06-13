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
public class DataWebServiceImplementation implements DataInterface {

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
    public ArrayList<Task> getTasksByPatientID(int ID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean newTask(Task task) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public ArrayList<Task> getTasks(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public ArrayList<Employee> getEmployees() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setTaskApproved(int taskID) {
	throw new UnsupportedOperationException("Not supported yet.");
	}
    
    @Override
    public ArrayList<Anamnese> getAnamneses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean insertUser(User user) {
        return false;
    }
}
