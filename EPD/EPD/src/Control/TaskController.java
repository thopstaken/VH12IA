package Control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Exceptions.*;
import Entity.*;

import java.text.DateFormat;

import java.util.HashMap;

public class TaskController {
	
	private ArrayList<Task> taskList = new ArrayList<Task>();
        private ArrayList<Employee> employeeList = new ArrayList<Employee>();
        private ArrayList<Location> locationList = new ArrayList<Location>();
	
	//Adds task to the tasklist
	private void addTask(Task task)
	{
		taskList.add(task);
	}
        
        //Adds employee to the employee list
        public void addEmployee(Employee employee)
        {
            employeeList.add(employee);
        }
        
        public void addLocation(Location location)
        {   
            locationList.add(location);
        }
        
        //Gets all available employees and put them in an Hashmap for the gui
        public HashMap<Integer,String> getAvailableEmployees()
        {
            HashMap<Integer,String> hmEmployee = new HashMap<Integer,String>();
            for(Employee employee: employeeList)
            {
                hmEmployee.put(employee.getEmployeeNr(), employee.getName());
            }           
            return hmEmployee;
        }
        
        //Gets all the categories for appointments and adds them to an ArrayList
        public ArrayList<String> getCategories(){
            ArrayList<String> categories = new ArrayList<String>();
            Task.Category[] ca = Task.Category.values();
            for (Task.Category cat : ca){
                categories.add(cat.toString());
            }
            return categories;
        }
        
        //Gets all the locations and puts them in an Hashmap for the gui
        public HashMap<String, String> getLocations(){
            HashMap<String, String> hmLocation = new HashMap<String, String>();

            for(Location location: locationList)
            {
                hmLocation.put(location.getZipcode(), location.getStreetName());
            }        
            return hmLocation;
        }
	
	//Create a new task

	public Task createTask(int taskId, String notes, boolean approved, boolean signed, String startDateTime, String endDateTime, Task.Category category, ArrayList<Employee> workingEmployeeList, ArrayList<LabTask> labTasks, Patient patient)
	{
            Task task = null;
		try
		{
			Calendar startCalendar = Calendar.getInstance();
			Calendar endCalendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
			Date startDate = dateFormat.parse(startDateTime);
			Date endDate = dateFormat.parse(endDateTime);
                        
			startCalendar.setTime(startDate);
			endCalendar.setTime(endDate);

			if (taskId == -1) 
                        {
                            task = new Task(notes, approved, signed, startCalendar, endCalendar, category, workingEmployeeList, labTasks, patient);
                        }
                        else 
                        {
                            task = new Task(taskId, notes, approved, signed, startCalendar, endCalendar, category, workingEmployeeList, labTasks, patient);
                        }
			
			try
			{
				validateTask(task);
				addTask(task);
                            return task;
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
		
                return task;
	}
	
	public boolean validateTask(Task checkTask) throws SamePatientException, SameEmployeeException
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

    private Patient getPatientByID(Patient patientID) {
        //Auto-generated method stub of zoiets
        return null;
    }

    private Location getLocationByID(Location locationID) {
        //Hetzelfde als hierboven
        return null;
    }
}

