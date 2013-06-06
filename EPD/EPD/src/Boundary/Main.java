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

import javax.swing.JFrame;

public class Main {
	
	public static void main(String args[])

	{   
            Patient patient = new Patient();
            patient.setPatientNumber("123123123");
            patient.setPatientId("1");
            patient.setFirstName("Test");
            patient.setSurName("McTest");
            
            
            TaskController taskController = new TaskController(patient);
            NewTask nt = new NewTask(taskController);
            taskController.setMessageDialogImplementation(nt);
            nt.setVisible(true);
    }

}                      


