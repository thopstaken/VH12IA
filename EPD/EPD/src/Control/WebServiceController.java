package Control;

import Entity.AfspraakWerknemer.AfspraakWerknemer;
import Entity.AfspraakWerknemer.AfspraakWerknemerService;

import Entity.AfspraakWerknemer.ApproveAfspraak;

import Entity.ApproveAfspraak.ApproveAfspraakService;

import Entity.Employee;

import Entity.InsertAfspraak.Afspraak;
import Entity.InsertAfspraak.InsertAfspraakService;

import Entity.InsertLab.InsertLabService;

import Entity.InsertLab.Lab;

import Entity.JAXWS.UserDBSelectLoginPassword;

import Entity.LabTask;
import Entity.Patient;
import Entity.Task;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

public class WebServiceController {
    @WebServiceRef
    private static AfspraakWerknemerService afspraakWerknemerService;
    private static ApproveAfspraakService approveTaskService;
    private static InsertAfspraakService insertTaskService;
    private static InsertLabService insertLabService;
    
    public WebServiceController() {
        afspraakWerknemerService = new AfspraakWerknemerService();
        approveTaskService = new ApproveAfspraakService();
        insertTaskService = new InsertAfspraakService();
        insertLabService = new InsertLabService();
    }
    
    public void combineTaskEmployee(int taskId, int employeeId) {
        try{
        System.out.println("Combinen voor employeeId " + employeeId);
        
        Entity.AfspraakWerknemer.Execute_ptt afspraakWerknemer_execute_ptt = afspraakWerknemerService.getExecute_pt();
        
        AfspraakWerknemer taskEmployee = new AfspraakWerknemer();
        BigDecimal afspraakId = new BigDecimal(taskId);
        BigDecimal EmployeeId = new BigDecimal(employeeId);
        
        taskEmployee.setAfspraakId(afspraakId);
        taskEmployee.setWerknemerId(EmployeeId);
        
        afspraakWerknemer_execute_ptt.execute(taskEmployee);
        }
        catch(Exception e) {
            System.out.println("Combineren is een hoer.");
            e.printStackTrace();
        }
    }
    
    public void approveTask(int taskId)
    {
       Entity.ApproveAfspraak.Execute_ptt approveTask_execute_ptt = approveTaskService.getExecute_pt();
       Entity.ApproveAfspraak.ApproveAfspraak approveTask = new Entity.ApproveAfspraak.ApproveAfspraak();
       BigDecimal afpsraakId = new BigDecimal(taskId);
       
       approveTask.setAfspraakId(afpsraakId);
       approveTask.setApprovedInd("true");
       
       approveTask_execute_ptt.execute(approveTask);
    }
    
    public boolean insertTask(Task task)
    {
        Entity.InsertAfspraak.Execute_ptt insertTask_execute_ptt = insertTaskService.getExecute_pt();
        boolean valid = true;
        
        System.out.println("Probeer ff de webservice aan te roepen");
        
        try
        {
            Afspraak afspraak = taskToAfspraak(task);
            insertTask_execute_ptt.execute(afspraak);
        }
        
        catch(Exception e) {
            System.out.println("Nullpointer zeker?");
            e.printStackTrace();
            valid = false;
        }
        
        return valid;
    }
    
    public void insertLabTask(LabTask labTask)
    {
        Entity.InsertLab.Execute_ptt insertLab_execute_ptt = insertLabService.getExecute_pt();
        
        Lab lab = new Lab();
        lab.setNaam(labTask.getDescription());
        lab.setSoort(labTask.getType());
        
        insertLab_execute_ptt.execute(lab);
    }
    
    private Afspraak taskToAfspraak(Task task)
    {
        Afspraak afspraak = new Afspraak();
        String approved = String.valueOf(booleanConverter(task.isApproved()));
        String signed = String.valueOf(booleanConverter(task.isSigned()));
        String notes = task.getNotes();
        String category = task.getCategory().toString();
        
        GregorianCalendar startTime = new GregorianCalendar();
        startTime.setTime(task.getStartDateTime().getTime());
        
        GregorianCalendar endTime = new GregorianCalendar();
        endTime.setTime(task.getEndDateTime().getTime());
        
        XMLGregorianCalendar start = null;
        XMLGregorianCalendar end = null;
        
        try
        {
            start = DatatypeFactory.newInstance().newXMLGregorianCalendar(startTime);
            end = DatatypeFactory.newInstance().newXMLGregorianCalendar(endTime);
        }
        
        catch(Exception e)
        {
            System.out.println("Nee toch?");
            e.printStackTrace();
        }

        BigDecimal patientId = new BigDecimal(task.getPatient().getPatientId());
        
        afspraak.setApprovedInd(approved);
        afspraak.setCategorie(category);
        afspraak.setOpmerkingen(notes);
        afspraak.setPatientId(patientId);
        afspraak.setSigned(String.valueOf(signed));
        afspraak.setStartTijdDt(start);
        afspraak.setEindTijdDt(end);
        
        return afspraak;
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
