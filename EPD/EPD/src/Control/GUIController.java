package Control;

import Boundary.PatientOverview;

import Entity.Patient;

import Entity.Anamnese;

import java.sql.Connection;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class GUIController {

    PatientController patientControl;
    AnamneseController anamneseControl;

    public GUIController() {

        patientControl = new PatientController();
        patientControl.createDummiePatienten();
        anamneseControl = new AnamneseController();

        new PatientOverview("Admin", new Date(), this);
    }

    public static void main(String[] args) {
        new GUIController();
    }

    public Object[][] getPatientList() {
        return patientControl.getPatientList();
    }
    
    public Patient getPatientByNumber(String patientNr){
        return patientControl.getPatientByNumber(patientNr);
    }
    
    public Object[][] search(String val, DefaultTableModel model, int rowCount) {
        Object[][] rows = null;
        
        return rows;
    }

    public boolean createAnamnese(String patientNr, String achterNaam,
                                  String voorNaam, String afdeling,
                                  String geboortedatum, String geslacht,
                                  String opnameDatum, String arts,
                                  String actPatrAankledenInd,
                                  String actPatrInameMedInd,
                                  String actPatrMobInd,
                                  String actPatrToiletInd,
                                  char[] actPatrValtRegInd,
                                  String actPatrVoedingInd,
                                  String actPatrWassenInd, Long afspraakId,
                                  Long allergieId, Long behandArts,
                                  Long behSpecId, String beroep,
                                  char[] beschrijvingZiektebeeld,
                                  char[] bijzonderheden, char[] conditie,
                                  char[] condHaar, char[] condHuid,
                                  char[] condNagels, Timestamp datumGesprekDt,
                                  Long decubitusGraad, String decubitusInd,
                                  char[] denkWaarnPatr, char[] dieet,
                                  String eenConAdres, String eenConNaam,
                                  String eenConRelatie, String eenConTel,
                                  String gebrSondeInd, Long gespreksvoerderId,
                                  Long gewicht, char[] gewichtsverloop,
                                  char[] gezonheidsbeleving, Long lengte,
                                  Timestamp medEindDt, char[] medGesch,
                                  char[] medNaam, Timestamp medStartDt,
                                  char[] misselijkBraken, String mrsaDrager,
                                  String noodzBeschMaatrInd,
                                  char[] noodzBeschMaatrReden,
                                  String onbGewVerlies3kgInd,
                                  String onbGewVerlies6kgInd,
                                  String opnameBuitenlandInd,
                                  Timestamp opnameDt, char[] overGevoelVoor,
                                  char[] patrProbleemhant,
                                  char[] persBezittingen, Long puntenaant,
                                  char[] rolRelatiePatroon,
                                  char[] rolRelatiePatrBijz,
                                  char[] seksualiteit, String seksualiteitInd,
                                  char[] slaapRustPatroon,
                                  char[] slikproblemen, String spreektaal,
                                  String tweeConAdres, String tweeConNaam,
                                  String tweeConRelatie, String tweeConTel,
                                  char[] uitschPatroon, Long verantwVerplId,
                                  Long verslavingId, Timestamp vervolgafspraak,
                                  char[] waardenLevensovertuigPatr,
                                  char[] zelfbelevingspatr, String verslaving,
                                  String allergie) {

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
                                           afspraakId, allergieId, behandArts,
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
                                           verslavingId, vervolgafspraak,
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
}
