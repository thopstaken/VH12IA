/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.sql.SQLException;

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
    ArrayList<Task> getTasksByPatientID(int ID) throws SQLException;
    ArrayList<Task> getTasks() throws SQLException;
    ArrayList<Employee> getEmployees() throws SQLException;
   
    
    //inserters   
    boolean newBloedDruk(BloedDruk bloedDruk);
    boolean newRapport(Rapport rapport);
    boolean newTask(Task task) throws SQLException;
    
    //updaters
    boolean updateBloedDruk(BloedDruk bloedDruk);
    boolean updateRapport(Rapport rapport);
    void setTaskApproved(int taskID) throws SQLException;
    
    //deleters
    boolean deleteBloedDruk(BloedDruk bloedDruk);
    boolean deleteRapport(Rapport rapport);
   
}
