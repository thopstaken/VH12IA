package Control;

import Entity.Patient;

import java.util.ArrayList;

public class PatientController {
    
    private ArrayList<Patient> patientList;
    
    public PatientController() {
        patientList = new ArrayList<Patient>();
        createDummiePatienten();
    }


    /**
     * Transforms Pantient objects to table data.
     * @return table data for GUI.
     */
    public Object[][] getPatientList(){
        
        Object[][] data = new Object[patientList.size()][8];
        
        for(int i = 0; i < patientList.size(); i++){
            data[i][0] = patientList.get(i).getPatientNummer();
            data[i][1] = patientList.get(i).getAchterNaam();
            data[i][2] = patientList.get(i).getVoorNaam();
            data[i][3] = patientList.get(i).getAfdeling();
            data[i][4] = patientList.get(i).getGeboorteDatum();
            data[i][5] = patientList.get(i).getGeslacht();
            data[i][6] = patientList.get(i).getOpnameDatum();
            data[i][7] = patientList.get(i).getArts();
        }
              
        return data;
    }
    
    public void createDummiePatienten(){
        Patient p1 = new Patient();
        p1.setPatientNummer("1");
        p1.setAchterNaam("Buijs");
        p1.setVoorNaam("Maurits");
        p1.setAfdeling("Chirurgie");
        p1.setGeboorteDatum("idunno");
        p1.setGeslacht("man");
        p1.setOpnameDatum("29-05-2013");
        p1.setArts("Mo");
        patientList.add(p1);
        
        Patient p2 = new Patient();
        p2.setPatientNummer("2");
        p2.setAchterNaam("Lambregts");
        p2.setVoorNaam("Dave");
        p2.setAfdeling("Psychetariaat");
        p2.setGeboorteDatum("idunno2");
        p2.setGeslacht("man");
        p2.setOpnameDatum("14-05-2013");
        p2.setArts("Sander Both");
        patientList.add(p2);
    }
    
}
