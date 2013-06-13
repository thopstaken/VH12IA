/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author Mike Hoogesteger
 * @Copyright 2013
 * 
 */
public interface DataInterface {
    
    //getters
    ArrayList<TimeLineItem> getAllTimeLineItems(int patientID) throws SQLException;
    //Worden aangeroepen door getAllTimeLineItems
    ArrayList<BloedDruk> getBloedDrukByPatientID(int ID);
    ArrayList<Rapport> getRapportByPatientID(int ID);
    ArrayList<Task> getTasksByPatientID(int ID) throws SQLException;
    ArrayList<Task> getTasks(Patient patient) throws SQLException;
    ArrayList<Employee> getEmployees() throws SQLException;
    ArrayList<Anamnese> getAnamneses();
    ArrayList<Patient> getPatienten();
    
    //inserters   
    boolean newBloedDruk(BloedDruk bloedDruk);
    boolean newRapport(Rapport rapport);
    boolean newTask(Task task) throws SQLException;
    boolean insertUser(User user);
    
    //updaters
    boolean updateBloedDruk(BloedDruk bloedDruk);
    boolean updateRapport(Rapport rapport);
    void setTaskApproved(int taskID) throws SQLException;
    
    //deleters
    boolean deleteBloedDruk(BloedDruk bloedDruk);
    boolean deleteRapport(Rapport rapport);
   
}
