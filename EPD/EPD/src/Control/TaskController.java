package Control;

import Boundary.Common.MessageDialogInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Exceptions.*;
import Entity.*;

import java.text.ParseException;

public class TaskController {
	
	private ArrayList<Task> taskList = new ArrayList<Task>();
        private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private InformationControl informationControl = InformationControl.getInstance();
        private MessageDialogInterface messageDialogImplementation;
        private Patient selectedPatient;
        
        
        public TaskController (Patient selectedPatient) {
            this.selectedPatient = selectedPatient;
            
            //fill in the lists
            try 
            {
                taskList = informationControl.getTasks();
                employeeList = informationControl.getEmployees();
            }
            catch (Exception e) 
            {
                if(taskList.size() > 0)
                System.out.println("Kan geen EmployeeList ophalen in taskController: \n" + e);
                else
                System.out.println("Kan geen TaskList ophalen in taskController: \n" + e);
            }
        }
        
        public void setMessageDialogImplementation (MessageDialogInterface messageDialogImplementation) {
            this.messageDialogImplementation = messageDialogImplementation;
        }
        
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
        
        /*Gets all available employees and put them in an Hashmap for the gui
        public HashMap<Integer,String> getAvailableEmployees()
        {
            HashMap<Integer,String> hmEmployee = new HashMap<Integer,String>();
            for(Employee employee: employeeList)
            {
                hmEmployee.put(employee.getEmployeeNr(), employee.getName());
            }           
            return hmEmployee;
        }*/
        
        public ArrayList<Employee> getAvailableEmployees()
        {
            return employeeList;
        }
        
        //Gets all the categories for appointments and adds them to an ArrayList
        public Task.Category[] getCategories(){
            return Task.Category.values();
        }
	
	//Create a new task
	public Task createTask(int taskId, String notes, boolean approved, boolean signed, String startDateTime, String endDateTime, Task.Category category, ArrayList<Employee> workingEmployeeList, ArrayList<LabTask> labTasks)
	{
            Task task = null;
		try
		{
                    System.out.println("Maken met de dates: " + startDateTime);
                    Calendar startCalendar = Calendar.getInstance();
                    Calendar endCalendar = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                    Date startDate = dateFormat.parse(startDateTime);
                    Date endDate = dateFormat.parse(endDateTime);
                        
                    startCalendar.setTime(startDate);
                    endCalendar.setTime(endDate);
                    
                    if (taskId <= 0) 
                    {
                        task = new Task(notes, approved, signed, startCalendar, endCalendar, category, workingEmployeeList, labTasks, selectedPatient);
                    }
                    else 
                    {
                        task = new Task(taskId, notes, approved, signed, startCalendar, endCalendar, category, workingEmployeeList, labTasks, selectedPatient);
                    }
			
                    if (validateTask(task) && informationControl.newTask(task)) 
                    {
                        addTask(task);
                        return task;
                    }
                }
                catch (ParseException exp)
                {
                    messageDialogImplementation.showError("Error", "Er is een datumveld niet goed geformateerd. (dd-mm-jjjj UU:MM)");
                    System.out.println(exp);
                }
		catch(SamePatientException exp)
                {
                    messageDialogImplementation.showError("Error", "Deze patiënt heeft al een afspraak op deze tijd en datum");
		    System.out.println(exp);
		}
                catch(SameEmployeeException exp) 
                {
                    messageDialogImplementation.showError("Error", "Deze medewerker(s) hebben al een afspraak op deze tijd en datum");
                    System.out.println(exp);
                }
                catch(BackToTheFutureException exp) 
                {
                    messageDialogImplementation.showError("Error", "De starttijd moet voor de eindtijd komen");
                    System.out.println(exp);
                }
                catch(NoCommentException exp) 
                {
                    messageDialogImplementation.showError("Error", "Er is geen omschrijving ingevoerd");
                    System.out.println(exp);
                }
		catch(Exception exp)
		{
                    messageDialogImplementation.showError("Error", "Onbekende fout");
                    System.out.println(exp);
                }
		
            return null;
	}
	
	public boolean validateTask(Task checkTask) throws SamePatientException, SameEmployeeException, BackToTheFutureException, NoCommentException
	{
		boolean valid = true;
		
                //start tijd mag niet later of gelijk zijn aan eind tijd
                if(!checkTask.getEndDateTime().after(checkTask.getStartDateTime()))
                {
                    throw new BackToTheFutureException();
                }
                
                if(checkTask.getNotes().trim().equals(""))
                {
                    throw new NoCommentException();
                }
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
                                    System.out.println("working employee: " + employee.getName() + " in task " + task.getTaskId());
					if(checkTask.getWorkingEmployeeList().contains(employee))
					{
					    System.out.println("duplicate employee: " + employee.getName() + " in " + checkTask.getTaskId()); 
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
}

