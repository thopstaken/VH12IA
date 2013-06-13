package Control;

import Boundary.LoginFrame;
import Boundary.PatientOverview;

import Entity.Patient;

import Entity.Anamnese;

import Entity.TimeLineItem;

import java.sql.Connection;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class GUIController {

    PatientController patientControl;
    AnamneseController anamneseControl;
    PatientOverview patientOverview;
    
    LoginController loginController;
    LoginFrame loginFrame;

    public GUIController() {

        patientControl = new PatientController();
        patientControl.createDummiePatienten();
        anamneseControl = new AnamneseController();
        loginController = new LoginController();
        
        loginFrame = new LoginFrame(loginController);
        loginFrame.setVisible(true);

       patientOverview =  new PatientOverview("Admin", new Date(), this);
    }

    public static void main(String[] args) {
        new GUIController();
    }

    public void setUserTableModel(DefaultTableModel tm) {
            patientOverview.getMUserTable().setModel(tm);
    }
    
    public Patient addPatient(Patient p) {
            return patientControl.addPatient(p.getPatientNumber(), p.getFirstName(), p.getPrefix(), p.getSurName(), Calendar.getInstance(), p.getGender(), p.getDeceased(), p.getUserId(), p.getDepartmentId(), p.getActive());
        }


    public Object[][] getPatientList() {
        return patientControl.getPatientList();
    }
    
    public Object[][] getPatientList(String search) {
        return patientControl.getPatientList(search);
    }
    
    public Patient getPatientByNumber(String patientNr){
        return patientControl.getPatientByNumber(patientNr);
    }
    
    public Object[][] search(String val, DefaultTableModel model, int rowCount) {
        return patientControl.getPatientList(val);
    }
    
    public ArrayList<TimeLineItem> getAllItemsByID(int PatientID){
           TimeLineControl tlc  = TimeLineControl.getInstance();
           return tlc.getAllTimeLineItems(PatientID);
    }

    public boolean createAnamnese(String patientNr, String achterNaam,
                                  String voorNaam, String afdeling,
                                  String geboortedatum, String geslacht,
                                  String opnameDatum, String arts,
                                  String actPatrAankledenInd, String actPatrInameMedInd,
                                                      String actPatrMobInd, String actPatrToiletInd,
                                                      String actPatrValtRegInd, String actPatrVoedingInd,
                                                      String actPatrWassenInd, Long afspraakId, Long allergieId,
                                                      Long behandArts, Long behSpecId, String beroep,
                                                      String beschrijvingZiektebeeld, String bijzonderheden,
                                                      String conditie, String condHaar, String condHuid,
                                                      String condNagels, String datumGesprekDt,
                                                      Long decubitusGraad, String decubitusInd,
                                                      String denkWaarnPatr, String dieet, String eenConAdres,
                                                      String eenConNaam, String eenConRelatie, String eenConTel,
                                                      String gebrSondeInd, Long gespreksvoerderId, Long gewicht,
                                                      String gewichtsverloop, String gezonheidsbeleving,
                                                      Long lengte, String medEindDt, String medGesch,
                                                      String medNaam, String medStartDt,
                                                      String misselijkBraken, String mrsaDrager,
                                                      String noodzBeschMaatrInd, String noodzBeschMaatrReden,
                                                      String onbGewVerlies3kgInd, String onbGewVerlies6kgInd,
                                                      String opnameBuitenlandInd, java.sql.Date opnameDt,
                                                      String overGevoelVoor,
                                                      String patrProbleemhant, String persBezittingen,
                                                      Long puntenaant, String rolRelatiePatroon,
                                                      String rolRelatiePatrBijz, String seksualiteit,
                                                      String seksualiteitInd, String slaapRustPatroon,
                                                      String slikproblemen, String spreektaal,
                                                      String tweeConAdres, String tweeConNaam,
                                                      String tweeConRelatie, String tweeConTel,
                                                      String uitschPatroon, Long verantwVerplId,
                                                      Long verslavingId, String vervolgafspraak,
                                                      String waardenLevensovertuigPatr, String zelfbelevingspatr,
                                                      String verslaving, String allergie) {

        String tussenVoegsel = new String();
        String[] achterNaamArr = achterNaam.split(" ");
        for (int i = 0; i < (achterNaamArr.length - 1); i++) {
            tussenVoegsel += achterNaamArr[i];
        }
        achterNaam = achterNaamArr[achterNaamArr.length - 1];

        /* TODO Patient p =
            patientControl.checkPatient(patientNr, voorNaam, tussenVoegsel,
                                        achterNaam, geboortedatum, geslacht,
                                        1, null, null, 1);*/

        Anamnese a =
            anamneseControl.createAnamnese(actPatrAankledenInd, actPatrInameMedInd,
                                           actPatrMobInd, actPatrToiletInd,
                                           actPatrValtRegInd,
                                           actPatrVoedingInd, actPatrWassenInd,
                                           afspraakId, behandArts,
                                           behSpecId, beroep,
                                           beschrijvingZiektebeeld,
                                           bijzonderheden, conditie, condHaar,
                                           condHuid, condNagels,
                                           datumGesprekDt, decubitusGraad,
                                           decubitusInd, denkWaarnPatr, dieet,
                                           eenConAdres, eenConNaam,
                                           eenConRelatie, eenConTel,
                                           gebrSondeInd, gespreksvoerderId,
                                           gewicht, gewichtsverloop,
                                           gezonheidsbeleving, lengte,
                                           medEindDt, medGesch, medNaam,
                                           medStartDt, misselijkBraken,
                                           mrsaDrager, noodzBeschMaatrInd,
                                           noodzBeschMaatrReden,
                                           onbGewVerlies3kgInd,
                                           onbGewVerlies6kgInd,
                                           opnameBuitenlandInd, opnameDt,
                                           overGevoelVoor, patrProbleemhant,
                                           persBezittingen, puntenaant,
                                           rolRelatiePatroon,
                                           rolRelatiePatrBijz, seksualiteit,
                                           seksualiteitInd, slaapRustPatroon,
                                           slikproblemen, spreektaal,
                                           tweeConAdres, tweeConNaam,
                                           tweeConRelatie, tweeConTel,
                                           uitschPatroon, verantwVerplId,
                                           vervolgafspraak,
                                           waardenLevensovertuigPatr,
                                           zelfbelevingspatr, verslaving,
                                           allergie);


        a.setPatientId(Long.parseLong(patientNr));

        //TODO anamnese toevoegen aan patient

        DatabaseController db = new DatabaseController();
        Connection c = db.makeConnection(a.makeInsertQuery());
        db.closeConnection(c);

        return true;
    }
    
    // get the instance of the timelinecontroller
    // get the timeline items from the database
    public ArrayList<TimeLineItem> getTimeLineItems(){
        TimeLineControl tlc  = TimeLineControl.getInstance();
        //get patientID to pass to the database query
        //TODO Patient id dynamisch
        int patientId = 1;
        return tlc.getAllTimeLineItems(patientId);
    }
    
    public void removePatient(Patient p) {
        patientControl.setInactive(p);
    }
    
}
