package Entity;

import java.util.ArrayList;
import java.util.Calendar;

public class Task
{
	private int taskId;
	private String notes;
        private boolean approved;
        private boolean signed;
	private Calendar startDateTime;
	private Calendar endDateTime;
	private Category category;
	private ArrayList<Employee> workingEmployeeList;
        private ArrayList<LabTask> labTasks;
	private Patient patient;
	
	
        //Constructor with taskId
	public Task(int taskId, String notes, boolean approved, boolean signed, Calendar startDateTime, Calendar endDateTime, Category category, ArrayList<Employee> workingEmployeeList, ArrayList<LabTask> labTasks, Patient patient)
	{
            this.taskId = taskId;
            this.notes = notes;
            this.approved = approved;
            this.signed = signed;
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
            this.category = category;
            this.workingEmployeeList = workingEmployeeList;
            this.labTasks = labTasks;
            this.patient = patient;
	}
        
        //Constructor without taskId
        public Task(String notes, boolean approved, boolean signed, Calendar startDateTime, Calendar endDateTime, Category category, ArrayList<Employee> workingEmployeeList, ArrayList<LabTask> labTasks, Patient patient)
        {
            this.notes = notes;
            this.approved = approved;
            this.signed = signed;
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
            this.category = category;
            this.workingEmployeeList = workingEmployeeList;
            this.labTasks = labTasks;
            this.patient = patient;
        }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setStartDateTime(Calendar startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Calendar getStartDateTime() {
        return startDateTime;
    }

    public void setEndDateTime(Calendar endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Calendar getEndDateTime() {
        return endDateTime;
    }

    public void setCategory(Task.Category category) {
        this.category = category;
    }

    public Task.Category getCategory() {
        return category;
    }

    public void setWorkingEmployeeList(ArrayList<Employee> workingEmployeeList) {
        this.workingEmployeeList = workingEmployeeList;
    }

    public ArrayList<Employee> getWorkingEmployeeList() {
        return workingEmployeeList;
    }

    public void setLabTasks(ArrayList<LabTask> labTasks) {
        this.labTasks = labTasks;
    }

    public ArrayList<LabTask> getLabTasks() {
        return labTasks;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    //Zorgt ervoor dat er vaste categoriën zijn
	public enum Category
	{
		MRI_SCAN, BLOOD_TEST, FECES_TEST
	}
        
    public void addLab(LabTask labTask)
    {
        labTasks.add(labTask);
    }
        
        
}
