package Control;

import Boundary.PatientOverview;

import java.util.Date;

public class GUIController {
    
    PatientController patientControl;
    
    public GUIController() {
        
        patientControl = new PatientController();
        patientControl.createDummiePatienten();
        
        new PatientOverview("Admin", new Date(), this);
    }
    
    public static void main(String[] args)  {
        new GUIController();
    }
    
    public Object[][] getPatientList(){
        return patientControl.getPatientList();
    }
}
