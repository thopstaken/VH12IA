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
            data[i][0] = patientList.get(i).getPatientNumber();
            data[i][1] = patientList.get(i).getSurName();
            data[i][2] = patientList.get(i).getFirstName();
            data[i][3] = patientList.get(i).getDepartmentId();
            data[i][4] = patientList.get(i).getDateOfBirth();
            data[i][5] = patientList.get(i).getGender();
            data[i][6] = "Haal op uit anamnese.";
            data[i][7] = "Haal op uit anamnese.";
        }

        return data;
    }

    public void createDummiePatienten() {
        addPatient("1", "Buijs", "Maurits", "Chirurgie", "01-01-0001", "man");
        addPatient("2", "Lambregts", "Dave", "Psychiatrische Inrichting",
                   "05-02-2000", "man");
    }


    public Patient addPatient(String patientNr, String achterNaam,
                           String voorNaam, String afdeling,
                           String geboortedatum, String geslacht) {

        Patient p = new Patient();

        p.setPatientNumber(patientNr);
        p.setSurName(achterNaam);
        p.setFirstName(voorNaam);
        p.setDepartmentId(afdeling);
        p.setDateOfBirth(geboortedatum);
        p.setGender(geslacht);
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

    public void changePatient(String patientNr, String surName,
                                    String firstName, String departmentId,
                                    String dateOfBirth, String gender) {
        for (Patient p : patientList) {
            if (p.getPatientNumber().equals(patientNr)) {
                p.setSurName(surName);
                p.setFirstName(firstName);
                p.setDepartmentId(departmentId);
                p.setDateOfBirth(dateOfBirth);
                p.setGender(gender);
                this.dbAction("update", p);
            }
        }
    }

    public Patient checkPatient(String patientNr, String surName,
                                    String firstname, String departmentId,
                                    String dateOfBirth, String gender) {
        for (Patient p : patientList) {
            if (p.getPatientNumber().equals(patientNr)) {
                //Patient bestaat al
                return p;
            }
        }
        
        //Patient bestaat nog niet
        Patient p = addPatient(patientNr, surName, firstname, departmentId, dateOfBirth, gender);
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
