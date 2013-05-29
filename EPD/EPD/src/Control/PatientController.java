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
    public Object[][] getPatientList() {

        Object[][] data = new Object[patientList.size()][8];

        for (int i = 0; i < patientList.size(); i++) {
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

    public void createDummiePatienten() {
        addPatient("1", "Buijs", "Maurits", "Chirurgie", "01-01-0001", "man",
                   "29-05-2013", "Armando");
        addPatient("2", "Lambregts", "Dave", "Psychiatrische Inrichting",
                   "05-02-2000", "man", "01-04-2013", "Mo");
    }


    public Patient addPatient(String patientNr, String achterNaam,
                           String voorNaam, String afdeling,
                           String geboortedatum, String geslacht,
                           String opnameDatum, String arts) {

        Patient p = new Patient();

        p.setPatientNummer(patientNr);
        p.setAchterNaam(achterNaam);
        p.setVoorNaam(voorNaam);
        p.setAfdeling(afdeling);
        p.setGeboorteDatum(geboortedatum);
        p.setGeslacht(geslacht);
        p.setOpnameDatum(opnameDatum);
        p.setArts(arts);
        patientList.add(p);

        this.dbAction("insert", p);
        return p;
    }

    public void removePatient(String patientNr) {
        for (Patient p : patientList) {
            if (p.getPatientNumber().equals(patientNr)) {
                patientList.remove(p);
                this.dbAction("delete", p);
            }
        }
    }

    public void changePatient(String patientNr, String achterNaam,
                              String voorNaam, String afdeling,
                              String geboortedatum, String geslacht,
                              String opnameDatum, String arts) {
        for (Patient p : patientList) {
            if (p.getPatientNummer().equals(patientNr)) {
                p.setPatientNummer(patientNr);
                p.setAchterNaam(achterNaam);
                p.setVoorNaam(voorNaam);
                p.setAfdeling(afdeling);
                p.setGeboorteDatum(geboortedatum);
                p.setGeslacht(geslacht);
                p.setOpnameDatum(opnameDatum);
                p.setArts(arts);
                this.dbAction("update", p);
            }
        }
    }

    public Patient checkPatient(String patientNr, String achterNaam,
                                    String voorNaam, String afdeling,
                                    String geboortedatum, String geslacht,
                                    String opnameDatum, String arts) {
        for (Patient p : patientList) {
            if (p.getPatientNumber().equals(patientNr)) {
                //Patient bestaat al
                return p;
            }
        }
        
        //Patient bestaat nog niet
        Patient p = addPatient(patientNr, achterNaam, voorNaam, afdeling, geboortedatum, geslacht, opnameDatum, arts);
        return p;
    }

    private void dbAction(String dbAction, Patient patient) {
        if (dbAction.equals("insert")) {
            //TODO db insert action
        } else if (dbAction.equals("update")) {
            //TODO db update action
        } else if (dbAction.equals("delete")) {
            //TODO db delete action
        }
    }
}
