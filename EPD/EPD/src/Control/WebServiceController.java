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
        
        
        Entity.AfspraakWerknemer.Execute_ptt afspraakWerknemer_execute_ptt = afspraakWerknemerService.getExecute_pt();
        UserDBSelectLoginPassword loginService_params = new UserDBSelectLoginPassword();
        
        AfspraakWerknemer taskEmployee = new AfspraakWerknemer();
        BigDecimal afspraakId = new BigDecimal(taskId);
        BigDecimal EmployeeId = new BigDecimal(employeeId);
        
        taskEmployee.setAfspraakId(afspraakId);
        taskEmployee.setWerknemerId(EmployeeId);
        
        afspraakWerknemer_execute_ptt.execute(taskEmployee);
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
        
        try
        {
            insertTask_execute_ptt.execute(taskToAfspraak(task));
            return true;
        }
        
        catch(Exception e) {
            return false;
        }
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
        
        Entity.InsertAfspraak.ObjectFactory factory = new Entity.InsertAfspraak.ObjectFactory();
        Afspraak afspraak = new Afspraak();
        boolean approved = task.isApproved();
        boolean signed = task.isSigned();
        String notes = task.getNotes();
        //task.get
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
            
        }
        //ArrayList<LabTask> labtasks = task.getLabTasks()
        BigDecimal patientId = new BigDecimal(task.getPatient().getPatientId());
        ArrayList<Employee> employeeList = task.getWorkingEmployeeList();
        
        afspraak.setApprovedInd(String.valueOf(approved));
        afspraak.setCategorie(category);
        afspraak.setOpmerkingen(notes);
        afspraak.setPatientId(patientId);
        afspraak.setSigned(String.valueOf(signed));
        afspraak.setStartTijdDt(start);
        afspraak.setEindTijdDt(end);
        
        return afspraak;
    }
}
