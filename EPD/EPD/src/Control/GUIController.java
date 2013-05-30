package Control;

import Boundary.PatientOverview;

import Entity.Patient;

import Entity.Anamnese;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

public class GUIController {
    
    PatientController patientControl;
    AnamneseController anamneseControl;
    
    public GUIController() {
        
        patientControl = new PatientController();
        patientControl.createDummiePatienten();
        anamneseControl = new AnamneseController();
        
        new PatientOverview("Admin", new Date(), this);
    }
    
    public static void main(String[] args)  {
        new GUIController();
    }
    
    public Object[][] getPatientList(){
        return patientControl.getPatientList();
    }
    
    public boolean createAnamnese(String patientNr, String achterNaam,
                                    String voorNaam, String afdeling,
                                    String geboortedatum, String geslacht,
                                    String opnameDatum, String arts,
                                  String actPatrAankledenInd,
                                  String actPatrInameMedInd,
                                  String actPatrMobInd,
                                  String actPatrToiletInd,
                                  String actPatrValtRegInd,
                                  String actPatrVoedingInd,
                                  String actPatrWassenInd, Long afspraakId,
                                  Long allergieId, Long behandArts,
                                  Long behSpecId, String beroep,
                                  String beschrijvingZiektebeeld,
                                  String bijzonderheden, String conditie,
                                  String condHaar, String condHuid,
                                  String condNagels, String datumGesprekDt,
                                  Long decubitusGraad, String decubitusInd,
                                  String denkWaarnPatr, String dieet,
                                  String eenConAdres, String eenConNaam,
                                  String eenConRelatie, String eenConTel,
                                  String gebrSondeInd, Long gespreksvoerderId,
                                  Long gewicht, String gewichtsverloop,
                                  String gezonheidsbeleving, Long lengte,
                                  String medEindDt, String medGesch,
                                  String medNaam, String medStartDt,
                                  String misselijkBraken, String mrsaDrager,
                                  String noodzBeschMaatrInd,
                                  String noodzBeschMaatrReden,
                                  String onbGewVerlies3kgInd,
                                  String onbGewVerlies6kgInd,
                                  String opnameBuitenlandInd,
                                  String opnameDt, String overGevoelVoor,
                                  String patrProbleemhant,
                                  String persBezittingen, Long puntenaant,
                                  String rolRelatiePatroon,
                                  String rolRelatiePatrBijz,
                                  String seksualiteit, String seksualiteitInd,
                                  String slaapRustPatroon,
                                  String slikproblemen, String spreektaal,
                                  String tweeConAdres, String tweeConNaam,
                                  String tweeConRelatie, String tweeConTel,
                                  String uitschPatroon, Long verantwVerplId,
                                  Long verslavingId, String vervolgafspraak,
                                  String waardenLevensovertuigPatr,
                                  String zelfbelevingspatr,
                                  String verslavingLijst,
                                  String allergieLijst) {
        
        Patient p = patientControl.checkPatient(patientNr, achterNaam, voorNaam, afdeling, geboortedatum, geslacht);
        
        Anamnese a = anamneseControl.createAnamnese(actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd,
                                  actPatrValtRegInd, actPatrVoedingInd, actPatrWassenInd, afspraakId,
                                  allergieId, behandArts, behSpecId, beroep, beschrijvingZiektebeeld,
                                  bijzonderheden, conditie, condHaar, condHuid, condNagels,
                                  datumGesprekDt, decubitusGraad, decubitusInd, denkWaarnPatr, dieet,
                                  eenConAdres, eenConNaam, eenConRelatie, eenConTel, gebrSondeInd, 
                                  gespreksvoerderId, gewicht, gewichtsverloop, gezonheidsbeleving, lengte, 
                                  medEindDt, medGesch, medNaam, medStartDt, misselijkBraken, mrsaDrager,
                                  noodzBeschMaatrInd, noodzBeschMaatrReden, onbGewVerlies3kgInd, 
                                  onbGewVerlies6kgInd, opnameBuitenlandInd, opnameDt, overGevoelVoor,
                                  patrProbleemhant, persBezittingen, puntenaant, rolRelatiePatroon, rolRelatiePatrBijz,
                                  seksualiteit, seksualiteitInd, slaapRustPatroon, slikproblemen, spreektaal,
                                  tweeConAdres, tweeConNaam, tweeConRelatie, tweeConTel, uitschPatroon, verantwVerplId,
                                  verslavingId, vervolgafspraak, waardenLevensovertuigPatr, zelfbelevingspatr,
                                  verslavingLijst, allergieLijst);
        
        
        a.setPatientId(Long.parseLong(patientNr));
        
        //TODO opslaan in database

        return true;
    }
}
