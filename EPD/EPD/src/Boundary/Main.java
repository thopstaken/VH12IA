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
            LoginFrame task = new LoginFrame();
            task.setVisible(true);
        }
}