/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Control.WebServiceController;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

/**
 *
 * @author Jan
 */
public class DataWebServiceImplementation implements DataInterface {
    WebServiceController wsc;
    
    public DataWebServiceImplementation () {
        wsc = new WebServiceController();
    }

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
        if (wsc.insertTask(task))//(DBcon.runQuery(query)) 
        {
            return true;
        } 
        return false;
    }
    
    public boolean completeTask(Task task)
    {
        try 
        {
            addLabTaskToTask(task);
            addEmployeeToTask(task);
            return true;
            
        } catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }
    }
    
    private void addLabTaskToTask(Task task) throws SQLException
    {
       
        ArrayList<LabTask> labTaskList = task.getLabTasks();
        for(LabTask labTask : labTaskList)
        {
            wsc.insertLabTask(labTask);
        }
    }
    
    private void addEmployeeToTask(Task task) throws SQLException
    {
        System.out.println("Werknemers toevoegen...");
        ArrayList<Employee> employeeList = task.getWorkingEmployeeList();
        System.out.println(employeeList.size() + " werknemers aan deze task");
        for(Employee employee : employeeList)
        {
            int taskId = task.getTaskId();
            int employeeId = employee.getEmployeeNr();
           wsc.combineTaskEmployee(taskId, employeeId);
        } 
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
        wsc.approveTask(taskID);
    }
    
    @Override
    public ArrayList<Anamnese> getAnamneses() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean insertUser(User user) {
        return false;
    }

    public ArrayList<Patient> getPatienten() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getLastTaskId() {
        throw new UnsupportedOperationException("Not yet.");
    }
}
