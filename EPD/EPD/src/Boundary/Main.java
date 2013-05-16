package Boundary;

import java.util.ArrayList;

import Control.TaskController;
import Entity.Employee;
import Entity.Location;
import Entity.Patient;
import Entity.Task;

public class Main {
	
	static TaskController taskController = new TaskController();
	
	public static void main(String args[])
	{
		Patient patient = new Patient("Ryan");
		Patient patient2 = new Patient("MagicMike");
		Employee emp1 = new Employee("Hans");
		Employee emp2 = new Employee("Echbert");
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);

		ArrayList<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(emp2);
		
		Location location = new Location();
		
		taskController.createTask("Test task", "15-05-2013 16:30", "15-05-2013 17:00", Task.Category.LAB, empList , patient, location);
		taskController.createTask("Test task", "15-05-2013 16:30", "15-05-2013 17:00", Task.Category.LAB, empList2 , patient2, location);
		
		System.out.println("Aantal tasks voor " + patient.getName() + " : " + taskController.getTasks("LAB").size());
		System.out.println("Aantal tasks voor " + patient2.getName() + " : " + taskController.getTasks("DoctorKoen").size());
	}

}
