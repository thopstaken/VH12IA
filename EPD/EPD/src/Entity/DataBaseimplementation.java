/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import Control.TimeLineControl;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jan
 */
public class DataBaseimplementation implements DataInterface {

    DatabaseConnection DBcon;
    public DataBaseimplementation(){
      DBcon = new DatabaseConnection();
    }
    
    @Override
    public ArrayList<TimeLineItem> getAllTimeLineItems(int patientID) {
        
        TimeLineControl timelinecontrol = TimeLineControl.getInstance();
        
        //Alle mogelijke lijsten ophalen
        ArrayList<BloedDruk> lijstBloeddruk = getBloedDrukByPatientID(patientID);
        ArrayList<Rapport> lijstRapport = getRapportByPatientID(patientID);
        ArrayList<Task> lijstTask = getTasksByPatientID(patientID);
        
        ArrayList<TimeLineItem> list = new ArrayList<TimeLineItem>();
        for(BloedDruk bloeddruk: lijstBloeddruk){
            list.add(timelinecontrol.addTimeLineItem(patientID, bloeddruk, EnumCollection.timeLineType.bloedDrukMeting, "", "", Integer.parseInt(bloeddruk.getBehandelaar()), bloeddruk.getDate()));   
        }
        
        for(Rapport rapport: lijstRapport){
            list.add(timelinecontrol.addTimeLineItem(patientID, rapport, EnumCollection.timeLineType.rapport, "", rapport.getBeschrijving(), Integer.parseInt(rapport.getUser()), rapport.getDatum()));
        }
        
        for(Task task: lijstTask){
            Calendar calendar_startdate = task.getStartDateTime();
            Date date_startdate = calendar_startdate.getTime();
            list.add(timelinecontrol.addTimeLineItem(patientID, task, EnumCollection.timeLineType.afspraak, "", task.getNotes(), Integer.parseInt(task.getPatient().getPatientId()), date_startdate));    
        }
        
        timelinecontrol.OrderTimeLineBy(list);
        
        return list;
     }
    
    @Override
    public boolean newBloedDruk(BloedDruk bloedDruk) {
       try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

    @Override
    public boolean updateBloedDruk(BloedDruk bloedDruk) {
        try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

    @Override
    public boolean deleteBloedDruk(BloedDruk bloedDruk) {
       try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

   

    @Override
    public ArrayList<Rapport> getRapportByPatientID(int ID) {
        ArrayList<Rapport> rapport_Arraylist = new ArrayList<Rapport>();
        try{
            ResultSet dataSet =  DBcon.runGetDataQuery(

            "SELECT RAPPORT.RAPPORT_ID, RAPPORT.BESCHRIJVING, RAPPORT.DATUM_DT, RAPPORT.USER FROM PATIENT INNER JOIN PATIENT_RAPPORT ON PATIENT.PATIENT_ID = PATIENT_RAPPORT.PATIENT_ID INNER JOIN RAPPORT ON PATIENT_RAPPORT.RAPPORT_ID = RAPPORT.RAPPORT_ID WHERE PATIENT_RAPPORT.ACTIVE_IND = 1 AND PATIENT.PATIENT_ID = "+ID+" ORDER BY PATIENT.PATIENT_ID)");

            while(dataSet.next()){
                int rapportID = Integer.parseInt(dataSet.getString("RAPPORT_ID"));
                String beschrijving = dataSet.getString("BESCHRIJVING");
                String user = dataSet.getString("USER");
                Date create_date = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH).parse(dataSet.getString("DATUM_DT"));
                Rapport rapport = new Rapport();
                Date date = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH).parse(dataSet.getString("CREATE_DT"));
                rapport.setDatum(date);
                rapport.setID(rapportID);
                rapport.setBeschrijving(beschrijving);
                rapport.setDatum(create_date);
                rapport.setUser(user);
                rapport_Arraylist.add(rapport);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return rapport_Arraylist;
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
        
        ArrayList<BloedDruk> bloeddruk_Arraylist = new ArrayList<BloedDruk>();
        
        try{
            ResultSet dataSet =  DBcon.runGetDataQuery(

            "SELECT RAPPORT_VITAL.ONDERDRUK, RAPPORT_VITAL.BOVENDRUK, RAPPORT_VITAL.CREATE_DT, RAPPORT_VITAL.SATURATIE FROM PATIENT INNER JOIN PATIENT_RAPPORT_VITAL ON PATIENT.PATIENT_ID = PATIENT_RAPPORT_VITAL.PATIENT_ID INNER JOIN RAPPORT_VITAL ON PATIENT_RAPPORT_VITAL.RAPPORT_VITAL_ID = RAPPORT_VITAL.RAPPORT_VITAL_ID WHERE PATIENT_RAPPORT_VITAL.ACTIVE_IND = 1 AND PATIENT.PATIENT_ID = "+ID+" ORDER BY PATIENT.PATIENT_ID)");

            while(dataSet.next()){
                int onderdruk = Integer.parseInt(dataSet.getString("ONDERDRUK"));
                int bovendruk = Integer.parseInt(dataSet.getString("BOVENDRUK"));
                int saturatie = Integer.parseInt(dataSet.getString("SATURATIE"));
                String create_user = dataSet.getString("CREATE_USER");
                Calendar create_date = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");                
                create_date.setTime(sdf.parse(dataSet.getString("CREATE_DT")));
                BloedDruk bloeddruk = new BloedDruk();               
                Date date = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH).parse(dataSet.getString("CREATE_DT"));
                bloeddruk.setDate(date);
                bloeddruk.setBehandelaar(create_user);
                bloeddruk.addBovenDrukValue(bovendruk, create_date);
                bloeddruk.addOnderDrukValue(onderdruk, create_date);
                bloeddruk.addSaturationValue(saturatie, create_date);
                bloeddruk_Arraylist.add(bloeddruk);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return bloeddruk_Arraylist;
    }
    
    @Override
    public ArrayList<Task> getTasksByPatientID(int ID) throws SQLException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        String query = "SELECT * FROM AFSPRAAK WHERE PATIENT_ID ='" + ID + "'";
        ResultSet dataSet = DBcon.runGetDataQuery(query);
        
        while(dataSet.next()){
            int afspraak_id = dataSet.getInt("AFSPRAAK_ID");
            boolean approved = dataSet.getBoolean("APPROVED_IND");
            String notes = dataSet.getString("OPMERKINGEN");
            boolean signed = dataSet.getBoolean("SIGNED");
            int patient_id = dataSet.getInt("PATIENT_ID");
            Calendar start_date = Calendar.getInstance();
            Calendar end_date = Calendar.getInstance();
            start_date.setTime(dataSet.getDate("START_TIJD_DT"));
            end_date.setTime(dataSet.getDate("EIND_TIJD_DT"));
            Patient patient = null; //getPatientById(int patient_id);
            ArrayList<Employee> employeeList = getEmployeesByTaskID(afspraak_id);
            
            Task task = new Task(afspraak_id, notes, approved, signed, start_date ,end_date , Task.Category.valueOf("MRI_SCAN"), employeeList ,new ArrayList<LabTask>(), patient);
            
            ArrayList<LabTask> labTaskList = getLabTasksByTaskID(task);
            task.setLabTasks(labTaskList);
            
            taskList.add(task);
        }
        return taskList;
    }
    
    @Override
    public ArrayList<Task> getTasks(Patient patient) throws SQLException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        String query = "SELECT * FROM AFSPRAAK WHERE ACTIVE_IND = 1";
        ResultSet dataSet = DBcon.runGetDataQuery(query);
        
        while(dataSet.next()){
            
            int afspraak_id = dataSet.getInt("AFSPRAAK_ID");
            int approved_ind = dataSet.getInt("APPROVED_IND");
            String notes = dataSet.getString("OPMERKINGEN");
            int signed_ind = dataSet.getInt("SIGNED");
            int patient_id = dataSet.getInt("PATIENT_ID");
            String categorie = dataSet.getString("CATEGORIE").trim();
            Calendar start_date = Calendar.getInstance();
            Calendar end_date = Calendar.getInstance();
            start_date.setTime(dataSet.getDate("START_TIJD_DT"));
            end_date.setTime(dataSet.getDate("EIND_TIJD_DT"));
            
            ArrayList<Employee> employeeList = new ArrayList<Employee>();
            boolean approved = booleanConverter(approved_ind);
            boolean signed = booleanConverter(signed_ind);
            
            Task.Category category = Task.Category.valueOf(categorie);

            Task task = new Task(afspraak_id, notes, approved, signed, start_date ,end_date , category , employeeList ,new ArrayList<LabTask>(), patient);

            taskList.add(task);
        }
        
        //omdat de database niet meer dan 1 resultset tegelijk kan hebben wordt deze data later aan de tasks toegevoegd
        for (Task task : taskList) {
            ArrayList<Employee> employeeList = getEmployeesByTaskID(task.getTaskId());
            task.setWorkingEmployeeList(employeeList);
            
            ArrayList<LabTask> labTaskList = getLabTasksByTaskID(task);
            task.setLabTasks(labTaskList);
        }
        
        return taskList;
    }
    
    
    @Override
    public boolean newTask(Task task) throws SQLException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        String startDate = sdf.format(task.getStartDateTime().getTime());
        String endDate = sdf.format(task.getEndDateTime().getTime());
        int approved = booleanConverter(task.isApproved());
        int signed = booleanConverter(task.isSigned());
        
        //Booleans moeten nog 1 of 0 worden gemaakt
        String query = "INSERT INTO AFSPRAAK (APPROVED_IND, OPMERKINGEN, SIGNED, PATIENT_ID, CATEGORIE, START_TIJD_DT, EIND_TIJD_DT)" +
            "VALUES ('"+ approved +"', '"+ task.getNotes()+"','" + signed +"', " + task.getPatient().getPatientId() + " ,'" + task.getCategory().toString() +
            " ' , to_date('"+ startDate +"', 'DD-MM-YYYY HH24:MI') , to_date('"+ endDate +"', 'DD-MM-YYYY HH24:MI'))";
        
        if (DBcon.runQuery(query)) 
        {
            //zet nieuwe afspraak id in de afspraak entiteit
            task.setTaskId(getLastTaskId());
            
            addLabTaskToTask(task);
            addEmployeeToTask(task);
            return true;
        } 
        
       return false; 
    }
    
    private void addLabTaskToTask(Task task) throws SQLException
    {
        ArrayList<LabTask> labTaskList = task.getLabTasks();
        for(LabTask labTask : labTaskList)
        {
            String query = "INSERT INTO LAB (NAAM, SOORT, AFSPRAAK_ID) VALUES ('"+labTask.getDescription()+"', '"+labTask.getType()+"' ,'"+task.getTaskId()+"') ";
            DBcon.runQuery(query);
        }
    }
    
    private void addEmployeeToTask(Task task) throws SQLException
    {
        ArrayList<Employee> employeeList = task.getWorkingEmployeeList();
        for(Employee employee : employeeList)
        {
            String query = "INSERT INTO AFSPRAAK_WERKNEMER (AFSPRAAK_ID, WERKNEMER_ID) VALUES ('"+task.getTaskId()+"', '"+ employee.getEmployeeNr()+"')";
            DBcon.runQuery(query);
        } 
    }
    
    private ArrayList<LabTask> getLabTasksByTaskID(Task task) throws SQLException
    {
        ArrayList<LabTask> labTaskList = new ArrayList<LabTask>();
        String query = "SELECT * FROM LAB WHERE AFSPRAAK_ID ='" + task.getTaskId() + "'";
        ResultSet dataSet = DBcon.runGetDataQuery(query);
        
        while(dataSet.next()){
            String task_name = dataSet.getString("NAAM");
            String task_type = dataSet.getString("SOORT");
            
            LabTask labTask = new LabTask(task, task_type, task_name);
            labTaskList.add(labTask);
        }
        return labTaskList;
    }
    
    private ArrayList<Employee> getEmployeesByTaskID(int task_id) throws SQLException
    {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        String query = "SELECT WERKNEMER_ID FROM AFSPRAAK_WERKNEMER WHERE AFSPRAAK_ID ='" + task_id + "'";
        ResultSet dataSet = DBcon.runGetDataQuery(query);
        
        while(dataSet.next()){
            int werknemer_id = dataSet.getInt("WERKNEMER_ID");
            
            String query2 = "SELECT * FROM WERKNEMER WHERE WERKNEMER_ID = '"+werknemer_id+"'";
            
            ResultSet employeeSet = DBcon.runGetDataQuery(query2);
            
            while(employeeSet.next())
            {
                int employee_id = employeeSet.getInt("WERKNEMER_ID");
                String employee_name = employeeSet.getString("NAAM");
                String employee_functie = employeeSet.getString("FUNCTIE");
                String eMpLoYeE_GeSlAcHt = (employeeSet.getString("GESLACHT").equals('m')) ? "MAN" : "WOMAN";
                Employee employee = new Employee(employee_id, employee_name, employee_functie, Employee.Sex.valueOf(eMpLoYeE_GeSlAcHt));
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
    
    public ArrayList<Employee> getEmployees() throws SQLException
    {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        String query = "SELECT * FROM WERKNEMER";
        ResultSet employeeSet = DBcon.runGetDataQuery(query);
        
        while(employeeSet.next()){
            int employee_id = employeeSet.getInt("WERKNEMER_ID");
            String employee_name = employeeSet.getString("NAAM");
            String employee_functie = employeeSet.getString("FUNCTIE");
            String employee_geslacht = (employeeSet.getString("GESLACHT").equals('m')) ? "MAN" : "WOMAN";;
            Employee employee = new Employee(employee_id, employee_name, employee_functie, Employee.Sex.valueOf(employee_geslacht));
            employeeList.add(employee);
        }
        return employeeList;
    }
    
    private int getLastTaskId () throws SQLException {
        String query = "SELECT MAX(AFSPRAAK_ID) AS ID FROM AFSPRAAK";
        ResultSet afspraakSet = DBcon.runGetDataQuery(query);
        
        int result = -1;
        while(afspraakSet.next())
        {
            result = afspraakSet.getInt("ID");
        }
        
        return result;
    }
    
    public void setTaskApproved(int taskID) throws SQLException
    {
        String query = "UPDATE AFSPRAAK SET APPROVED_IND = 1 WHERE AFSPRAAK_ID = "+ taskID+"";
        DBcon.runQuery(query);
    }

    private int booleanConverter(String target)
    {
        return (target.equals("true")) ? 1 : 0;
    }
    
    private int booleanConverter(boolean target)
    {
        return (target) ? 1 : 0;
    }
    
    private boolean booleanConverter(int target)
    {
        return (target == 1) ? true : false; 
    }
}


