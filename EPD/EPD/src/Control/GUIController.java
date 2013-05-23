package Control;

import Boundary.PatientOverview;

import java.util.Date;

public class GUIController {
    
    public GUIController() {
        
    }
    
    public static void main(String[] args)  {
        new PatientOverview("Admin", new Date());
    }
}
