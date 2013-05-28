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
        addPatient("1","Buijs","Maurits","Chirurgie","01-01-0001","man","29-05-2013","Armando");
        addPatient("2","Lambregts","Dave","Psychiatrische Inrichting","05-02-2000","man","01-04-2013","Mo");
    }
    
    
    public void addPatient(String patientNr, String achterNaam, String voorNaam, 
                           String afdeling, String geboortedatum, String geslacht, 
                           String opnameDatum, String arts){
        
        Patient p1 = new Patient();
        p1.setPatientNummer(patientNr);
        p1.setAchterNaam(achterNaam);
        p1.setVoorNaam(voorNaam);
        p1.setAfdeling(afdeling);
        p1.setGeboorteDatum(geboortedatum);
        p1.setGeslacht(geslacht);
        p1.setOpnameDatum(opnameDatum);
        p1.setArts(arts);
        patientList.add(p1);
    }
    
    public void removePatient(String patientNr){
        for (Patient p : patientList) {
            if (p.getPatientNummer().equals(patientNr)) {
                patientList.remove(p);
            }
        }
    }
    
    public void changePatient(String patientNr, String achterNaam, String voorNaam, 
                           String afdeling, String geboortedatum, String geslacht, 
                           String opnameDatum, String arts){
        this.removePatient(patientNr);
        this.addPatient(patientNr, achterNaam, voorNaam, afdeling, geboortedatum, geslacht, opnameDatum, arts);
    }
}
