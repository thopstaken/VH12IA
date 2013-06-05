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
    
    public Patient getPatientById(String patientId) {
        Patient patient = null;
        for (Patient p : patientList) {
            if (p.getPatientId().equals(patientId)) {
                patient = p;
            }
        }
        return patient;
    }
    
    public Patient getPatientByNumber(String patientNumber) {
        Patient patient = null;
        for (Patient p : patientList) {
            if (p.getPatientNumber().equals(patientNumber)) {
                patient = p;
            }
        }
        return patient;
    }

    public void createDummiePatienten() {
        addPatient("1", "Maurits", "", "Buijs", "00-00-0000", "man", 1, 1, 1, 1);
        addPatient("2", "Dave", "Duckface", "Lambregts", "12-12-2012", "man",
                   0, 0, 0, 0);
    }


    public Patient addPatient(String patientNr, String voorNaam,
                              String tussenVoegsel, String achterNaam,
                              String geboortedatum, String geslacht,
                              int overleden, int accountId, int afdelingId,
                              int accountActief) {
        Patient p = new Patient();

        //p.setPatientId(patientId);
        p.setPatientNumber(patientNr);
        p.setFirstName(voorNaam);
        p.setPrefix(tussenVoegsel);
        p.setSurName(achterNaam);
        p.setDateOfBirth(geboortedatum);
        p.setGender(geslacht);
        p.setDeceased(overleden);
        p.setUserId(afdelingId);
        p.setDepartmentId(accountId);
        p.setActive(accountActief);
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
                              String firstName, int departmentId,
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

    public Patient checkPatient(String patientNr, String voorNaam,
                                String tussenVoegsel, String achterNaam,
                                String geboortedatum, String geslacht,
                                int overleden, int accountId,
                                int afdelingId, int accountActief) {
        for (Patient p : patientList) {
            if (p.getPatientNumber().equals(patientNr)) {
                //Patient bestaat al
                return p;
            }
        }

        //Patient bestaat nog niet
        Patient p =
            addPatient(patientNr, voorNaam, tussenVoegsel, achterNaam, geboortedatum,
                       geslacht, overleden, accountId, afdelingId,
                       accountActief);
        return p;
    }

    private void dbAction(String dbAction, Patient patient) {
        DatabaseController pc = new DatabaseController();
        if (dbAction.equals("insert")) {
            String query =
                "INSERT INTO PATIENT (" + "PATIENTNUMMER, " + "VOORNAAM, " +
                "TUSSENVOEGSEL, " + "ACHTERNAAM," + "GEBOORTEDATUM_DT, " +
                "GESLACHT, " + "OVERLEDEN_IND, " + "USER_ID," +
                "AFDELING_ID, " + "ACTIVE_IND) VALUES('" +
                patient.getPatientNumber() + "','" + patient.getFirstName() +
                "','" + patient.getPrefix() + "','" + patient.getSurName() +
                "','" + patient.getDateOfBirth() + "','" +
                patient.getGender() + "','" + patient.getDeceased() + "','" +
                patient.getUserId() + "','" + patient.getDepartmentId() +
                "','" + patient.getActive() + "');";
            pc.insertAction(query);
        } else if (dbAction.equals("update")) {
            //TODO db update action
        } else if (dbAction.equals("delete")) {
            //TODO db delete action
        }
    }
}
