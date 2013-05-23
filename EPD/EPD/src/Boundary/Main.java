package Boundary;

import java.util.ArrayList;

import Control.TaskController;
import Entity.Employee;
import Entity.LabTask;
import Entity.Location;
import Entity.Patient;
import Entity.Task;

import java.util.Calendar;
import java.util.Date;

public class Main {
	
	static TaskController taskController = new TaskController();
	
	public static void main(String args[])
	{
                Calendar calendar = Calendar.getInstance();
		Patient patient = new Patient(1, "Ryan", "von", "Rommel", calendar.getTime(), Patient.Sex.MAN, false );
		Patient patient2 = new Patient(2, "Magic", "", "Mike", calendar.getTime(), Patient.Sex.MAN, false);
		Employee emp1 = new Employee("Hans ter Aarde", "Arts", Employee.Sex.MAN);
		Employee emp2 = new Employee("Echbert Koens", "LABMAN", Employee.Sex.MAN);
                
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);

		ArrayList<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(emp2);
                
                ArrayList<LabTask> labList = new ArrayList<LabTask>();
                ArrayList<LabTask> labList2 = new ArrayList<LabTask>();
		
		Location location = new Location();
		
		Task task1 = taskController.createTask(1,"Test Note", true, false, "15-05-2013 16:30", "15-05-2013 17:00", Task.Category.BLOOD_TEST, empList , labList, patient);
		Task task2 = taskController.createTask(-1,"Test Note", false, true, "15-05-2013 16:30", "15-05-2013 17:00", Task.Category.MRI_SCAN, empList2 , labList2, patient2);
		
                LabTask labtask1 = new LabTask(task1, "Hipetites", "Check voor heppie");
                task1.getLabTasks().add(labtask1);
                
		System.out.println("Aantal Labtasks voor " + patient.getFirstName() + " : " + task1.getLabTasks().size());
		System.out.println("Aantal Labtasks voor " + patient2.getFirstName() + " : " + task2.getLabTasks().size());
                
                
	
        NewTask newtask = new NewTask(taskController);
        newtask.setVisible(true);
        
        }

}
