package Control;

import Entity.DataBaseimplementation;
import Entity.DataInterface;

import Entity.DeletePatient.DAPatient;
import Entity.DeletePatient.DeletePatientService;

import Entity.InsertPatient.InsertPatient;

import Entity.Patient;

import Entity.User;
import Entity.Users;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class PatientController {

    private ArrayList<Patient> patientList;
    private DataInterface database = new DataBaseimplementation();

    public PatientController() {
        patientList = new ArrayList<Patient>();
        patientList = database.getPatienten();
        //createDummiePatienten();
    }
    
    public ArrayList<Patient> getPatientArrayList() {
        return patientList;
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
            data[i][1] = patientList.get(i).getPrefix() + " " + patientList.get(i).getSurName();
            data[i][2] = patientList.get(i).getFirstName();
            data[i][3] = patientList.get(i).getDepartmentId();
            data[i][4] =
                    sdf.format(patientList.get(i).getDateOfBirth().getTime());
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
                sdf.format(patientList.get(i).getDateOfBirth().getTime()).contains(search)) {

                data[j][0] = patientList.get(i).getPatientNumber();
                data[j][1] = patientList.get(i).getSurName();
                data[j][2] = patientList.get(i).getFirstName();
                data[j][3] = patientList.get(i).getDepartmentId();
                data[j][4] =
                        sdf.format(patientList.get(i).getDateOfBirth().getTime());
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
        addPatient("1", "Maurits", "", "Buijs", Calendar.getInstance(), "man",
                   1, 1, 1, 1);
        addPatient("2", "Dave", "Duckface", "Lambregts",
                   Calendar.getInstance(), "man", 0, 0, 0, 0);
    }


    public Patient addPatient(String patientNr, String voorNaam,
                              String tussenVoegsel, String achterNaam,
                              Calendar geboortedatum, String geslacht,
                              int overleden, int accountId, int afdelingId,
                              int accountActief) {
        Patient p = new Patient();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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


        Calendar cal = Calendar.getInstance();
        cal.setTime(geboortedatum.getTime());
        p.setDateOfBirth(cal);

        patientList.add(p);

        //Insert User
        User user = new User();

        user.setEmail("email@email.com");
        user.setFirstname(voorNaam);
        user.setName(voorNaam + " " + tussenVoegsel + " " + achterNaam);
        user.setPassword("password1");
        user.setLogin(voorNaam + " " + tussenVoegsel + " " + achterNaam);
        this.dbAction("insert", p);
        this.dbAction("insert", user);
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
    
    public void setInactive(Patient pt) {
        this.dbAction("delete", pt);
    }

    public Patient checkPatient(String patientNr, String voorNaam,
                                String tussenVoegsel, String achterNaam,
                                Calendar geboortedatum, String geslacht,
                                int overleden, int accountId, int afdelingId,
                                int accountActief) {
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
            /*String query =
                "INSERT INTO PATIENT (" + "PATIENTNUMMER, " + "VOORNAAM, " +
                "TUSSENVOEGSEL, " + "ACHTERNAAM, " + "GEBOORTEDATUM_DT, " +
                "GESLACHT, " + "OVERLEDEN_IND, " + "USER_ID," +
                "AFDELING_ID, " + "ACTIVE_IND) VALUES('" +
                patient.getPatientNumber() + "','" + patient.getFirstName() +
                "','" + patient.getPrefix() + "','" + patient.getSurName() +
                "','" + patient.getDateOfBirth() + "','" +
                patient.getGender() + "','" + patient.getDeceased() + "','" +
                patient.getUserId() + "','" + patient.getDepartmentId() +
                "','" + patient.getActive() + "');";*/

            // pc.insertAction(query);
            InsertPatient insertPatient = new InsertPatient();
            Entity.InsertPatient.Execute_ptt ptt =
                insertPatient.getExecute_pt();

            Entity.InsertPatient.Patient patientWs =
                new Entity.InsertPatient.Patient();
            patientWs.setPatientnummer(new BigDecimal(patient.getPatientNumber()));
            patientWs.setVoornaam(patient.getFirstName());
            patientWs.setTussenvoegsel(patient.getPrefix());
            patientWs.setAchternaam(patient.getSurName());
            patientWs.setGeboortedatum(toXMLGregorianCalendar(patient.getDateOfBirth().getTime()));
            patientWs.setGeslacht(patient.getGender());
            patientWs.setOverledenInd("0");
            patientWs.setUserId(new BigDecimal(patient.getUserId()));
            patientWs.setAfdelingId(new BigDecimal(1));
            //patientWs.setAfdelingId(new BigDecimal(patient.getDepartmentId()));
            patientWs.setActiveInd(new BigDecimal(1));

            try {
                ptt.execute(patientWs);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (dbAction.equals("update")) {
            //TODO db update action
        } else if (dbAction.equals("delete")) {
            DeletePatientService dps = new DeletePatientService();
            Entity.DeletePatient.Execute_ptt ptt = dps.getExecute_pt();
            DAPatient dPatient = new DAPatient();

            dPatient.setPatientid(new BigDecimal(patient.getPatientId()));
            dPatient.setActiveInd(new BigDecimal(0));

            try {
                ptt.execute(dPatient);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            ex.printStackTrace();
        }
        return xmlCalendar;
    }

    private void dbAction(String dbAction, User user) {

        DatabaseController pc = new DatabaseController();
        if (dbAction.equals("insert")) {

            database.insertUser(user);
            
        }//more can be added

    }
}
