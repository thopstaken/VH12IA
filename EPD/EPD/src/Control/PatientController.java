package Control;

import Entity.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;

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
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        for (int i = 0; i < patientList.size(); i++) {
            data[i][0] = patientList.get(i).getPatientNumber();
            data[i][1] = patientList.get(i).getSurName();
            data[i][2] = patientList.get(i).getFirstName();
            data[i][3] = patientList.get(i).getDepartmentId();
            data[i][4] = sdf.format(patientList.get(i).getDateOfBirth().getTime());
            data[i][5] = patientList.get(i).getGender();
            data[i][6] = "Haal op uit anamnese.";
            data[i][7] = "Haal op uit anamnese.";
        }

        return data;
    }
    
    /**
     * Transforms Pantient objects to table data.
     * @return table data for GUI.
     */
    public Object[][] getPatientList(String search) {

        Object[][] data = new Object[patientList.size()][8];
        
        int j = 0;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        for (int i = 0; i < patientList.size(); i++) {
            if (patientList.get(i).getPatientNumber().contains(search) ||
                patientList.get(i).getSurName().contains(search) ||
                patientList.get(i).getFirstName().contains(search) ||
                sdf.format(patientList.get(i).getDateOfBirth().getTime()).contains(search)
                ) {
                
                data[j][0] = patientList.get(i).getPatientNumber();
                data[j][1] = patientList.get(i).getSurName();
                data[j][2] = patientList.get(i).getFirstName();
                data[j][3] = patientList.get(i).getDepartmentId();
                data[j][4] = sdf.format(patientList.get(i).getDateOfBirth().getTime());
                data[j][5] = patientList.get(i).getGender();
                data[j][6] = "Haal op uit anamnese.";
                data[j][7] = "Haal op uit anamnese.";
                
                j++;
            }
        }
        
        //zorgen dat de nieuwe lijst wordt gevuld met de gefilterde data. 
        //dit is omdat de data lijst nog de verkeerde lengte heeft
        Object[][] data2 = new Object[j][8];
        
        for (int i = 0; i < j; i++) {
            data2[i] = data[i];
        }

        return data2;
    }
    
    public Patient getPatientById(int patientId) {
        Patient patient = null;
        for (Patient p : patientList) {
            if (p.getPatientId() == patientId) {
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
        addPatient("1", "Maurits", "", "Buijs", "11-11-2012", "man", 1, 1, 1, 1);
        addPatient("2", "Dave", "Duckface", "Lambregts", "12-12-2012", "man",
                   0, 0, 0, 0);
    }


    public Patient addPatient(String patientNr, String voorNaam,
                              String tussenVoegsel, String achterNaam,
                              String geboortedatum, String geslacht,
                              int overleden, int accountId, int afdelingId,
                              int accountActief) {
        Patient p = new Patient();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        //p.setPatientId(patientId);
        p.setPatientNumber(patientNr);
        p.setFirstName(voorNaam);
        p.setPrefix(tussenVoegsel);
        p.setSurName(achterNaam);
        
        p.setGender(geslacht);
        p.setDeceased(overleden);
        p.setUserId(afdelingId);
        p.setDepartmentId(accountId);
        p.setActive(accountActief);


        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(geboortedatum));
            p.setDateOfBirth(cal);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        
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
                //p.setDateOfBirth(dateOfBirth);
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
                "TUSSENVOEGSEL, " + "ACHTERNAAM, " + "GEBOORTEDATUM_DT, " +
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
