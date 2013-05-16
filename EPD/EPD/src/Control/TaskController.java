package Control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Exceptions.*;
import Entity.*;

public class TaskController {
	
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	//Adds task to the tasklist
	private void addTask(Task task)
	{
		taskList.add(task);
	}
	
	//Create a new task
	public void createTask(String description, String startDateTime, String endDateTime, Task.Category category, ArrayList<Employee> workingEmployeeList, Patient patient, Location location)
	{
		try
		{
			Calendar startCalendar = Calendar.getInstance();
			Calendar endCalendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
			Date startDate = dateFormat.parse(startDateTime);
			Date endDate = dateFormat.parse(endDateTime);
			
			startCalendar.setTime(startDate);
			endCalendar.setTime(endDate);
			
			
			Task task = new Task(description, startCalendar, endCalendar, category, workingEmployeeList, patient, location);
			try
			{
				validateTask(task);
				addTask(task);
			}
			
			catch(Exception exp)
			{
				System.out.println(exp);
			}
			
			System.out.println("Start Datum: " + task.getStartDateTime().getTime() + " en eind Datum: " + task.getEndDateTime().getTime());
		}
		catch(Exception e)
		{
			System.err.println("One of the dates was not well formatted");
		}
		
	}
	
	public boolean validateTask(Task checkTask) throws SamePatientException, SameLocationException, SameEmployeeException
	{
		boolean valid = true;
		
		//Loop through all the tasks..
		for(Task task : taskList)
		{
			boolean beforeNotAvail = task.getStartDateTime().before(checkTask.getEndDateTime());
			boolean afterNotAvail = task.getEndDateTime().after(checkTask.getStartDateTime());
			
			//Check if the Task is beginning or ending into another task
			if(beforeNotAvail && afterNotAvail)
			{
				//If it is the same patient..
				if(task.getPatient().equals(checkTask.getPatient()))
				{
					throw new SamePatientException();					
				}
				
				//Check on the employees
				for(Employee employee : task.getWorkingEmployeeList())
				{
					if(checkTask.getWorkingEmployeeList().contains(employee))
					{
						throw new SameEmployeeException();
					}
				}
				
				if(task.getLocation().equals(checkTask.getLocation()))
				{
					throw new SameLocationException();
				}
			
			}
		}
		return valid;
	}
	
	//Returns the task list
	public ArrayList<Task> getTaskList()
	{
		return taskList;
	}
	
	//Search tasks by Patient
	public ArrayList<Task> getTasks(Patient patient)
	{
		ArrayList<Task> foundTasks = new ArrayList<Task>();
		for(Task task : taskList)
		{
			Patient taskPatient = task.getPatient();
			
			if(patient.equals(taskPatient))
			{
				foundTasks.add(task);
			}
		}
		
		return foundTasks;
	}
	
	//Search tasks by Employee
	public ArrayList<Task> getTasks(Employee employee)
	{
		ArrayList<Task> foundTasks = new ArrayList<Task>();
		for(Task task : taskList)
		{
			ArrayList<Employee> taskEmployees = task.getWorkingEmployeeList();
			
			for(Employee taskEmployee : taskEmployees)
			{
				if(employee.equals(taskEmployee))
				{
					foundTasks.add(task);
				}
			}
		}
		
		return foundTasks;
	}
	
	//Search tasks by Category
	public ArrayList<Task> getTasks(String category)
	{
		Task.Category searchCategory = categoryStringToEnum(category);
		ArrayList<Task> foundTasks = new ArrayList<Task>();
		
		if(searchCategory != null)
		{
			for(Task task : taskList)
			{
				Task.Category taskCategory = task.getCategory();
			
				if(searchCategory.equals(taskCategory))
				{
					foundTasks.add(task);
				}
			}
		}
		return foundTasks;
	}
	
	
	private Task.Category categoryStringToEnum(String categoryString)
	{
		try 
		{
			Task.Category category = Task.Category.valueOf(categoryString.toUpperCase());
			return category;
		} 
		catch (IllegalArgumentException exception)
		{
			System.err.println("Task Category not found: " + categoryString);
			return null;
		}
		
	}
}

