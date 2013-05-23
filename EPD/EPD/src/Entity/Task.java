package Entity;

import java.util.ArrayList;
import java.util.Calendar;

public class Task
{
	private int taskId;
	private String descripton;
	private Calendar startDateTime;
	private Calendar endDateTime;
	private Category category;
	private ArrayList<Employee> workingEmployeeList;
	private Patient patient;
	private Location location;
	
	
	public Task(String description, Calendar startDateTime, Calendar endDateTime, Category category, ArrayList<Employee> workingEmployeeList, Patient patient, Location location)
	{
		this.descripton = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.category = category;
		this.workingEmployeeList = workingEmployeeList;
		this.patient = patient;
		this.location = location;
	}
	
	//Zorgt ervoor dat er vaste categoriën zijn
	public enum Category
	{
		LAB, OTHER
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}


	public Calendar getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Calendar startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Calendar getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Calendar endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ArrayList<Employee> getWorkingEmployeeList() {
		return workingEmployeeList;
	}

	public void setWorkingEmployeeList(ArrayList<Employee> workingEmployeeList) {
		this.workingEmployeeList = workingEmployeeList;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	

}
