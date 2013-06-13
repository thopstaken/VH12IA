package Control;

import Entity.Patient;

import Entity.Anamnese;

import Entity.DataBaseimplementation;
import Entity.DataInterface;

import Entity.Employee;
import Entity.Task;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class AnamneseController {
    
    private ArrayList<Anamnese> anamneseLijst;
    
    public AnamneseController() {
        anamneseLijst = new ArrayList<Anamnese>();
        readAnamneses();
        createDummyAnamnese();
    }
    
    public ArrayList<Anamnese> getAnamneseLijst() {
        return anamneseLijst;
    }
    
    public void createDummyAnamnese() {
        String actPatrAankledenInd = "-";
        String actPatrInameMedInd = "-";
        String actPatrMobInd = "-";
        String actPatrToiletInd = "-";
        String actPatrValtRegInd = "-";
        String actPatrVoedingInd = "-";
        String actPatrWassenInd = "-";
        PatientController patientControl = new PatientController();
        Patient p = patientControl.getPatientArrayList().get(0);
        TaskController taskControl = new TaskController(p);
        Task t = taskControl.getFirstTaskInList();
        Integer employee =  t.getWorkingEmployeeList().get(0).getEmployeeNr();
        Integer afspraak = t.getTaskId();
        Long afspraakId =  afspraak.longValue();
        Long behandArts = employee.longValue();
        Long behSpecId = employee.longValue();
        String beroep = "Straatwerker";
        String beschrijvingZiektebeeld = "continu ziek";
        String bijzonderheden = "-";;
        String conditie = "goed";
        String condHaar = "-";
        String condHuid = "-";
        String condNagels = "-";
        String datumGesprekDt = "-";
        Long decubitusGraad = Long.parseLong("0");
        String decubitusInd = "-";
        String denkWaarnPatr = "-";
        String dieet = "-";
        String eenConAdres = "-";
        String eenConNaam = "-";
        String eenConRelatie = "-";
        String eenConTel = "-";
        String gebrSondeInd = "-";
        Long gespreksvoerderId = employee.longValue();
        Long gewicht = Long.parseLong("87");
        String gewichtsverloop = "-";
        String gezonheidsbeleving = "-";
        Long lengte = Long.parseLong("179");
        String medEindDt = "-";
        String medGesch = "-";
        String medNaam = "-";
        String medStartDt = "-";
        String misselijkBraken = "-";
        String mrsaDrager = "-";
        String noodzBeschMaatrInd = "-";
        String noodzBeschMaatrReden = "-";
        String onbGewVerlies3kgInd = "-";
        String onbGewVerlies6kgInd = "-";
        String opnameBuitenlandInd = "-";
        java.sql.Date opnameDt = new java.sql.Date(11,12,2012);
        String overGevoelVoor = "-";
        Integer patient = p.getPatientId();
        Long patientId = patient.longValue();
        String patrProbleemhant = "-";
        String persBezittingen = "-";
        Long puntenaant = Long.parseLong("0");
        String rolRelatiePatroon = "-";
        String rolRelatiePatrBijz = "-";
        String seksualiteit = "-";
        String seksualiteitInd = "-";
        String slaapRustPatroon = "-";
        String slikproblemen = "-";
        String spreektaal = "-";
        String tweeConAdres = "-";
        String tweeConNaam = "-";
        String tweeConRelatie = "-";
        String tweeConTel = "-";
        String uitschPatroon = "-";
        Long verantwVerplId = employee.longValue();
        String vervolgafspraak = "-";
        String waardenLevensovertuigPatr = "-";
        String zelfbelevingspatr = "-";
        String verslaving = "-";
        String allergie = "-";
        
        Anamnese a = createAnamnese(actPatrAankledenInd, actPatrInameMedInd,
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
        a.setPatientId(patientId);
        
        DatabaseController db = new DatabaseController();
        Connection c = db.makeConnection(a.makeInsertQuery());
        db.closeConnection(c);
    }
    
    public Anamnese createAnamnese(String actPatrAankledenInd, String actPatrInameMedInd,
                    String actPatrMobInd, String actPatrToiletInd,
                    String actPatrValtRegInd, String actPatrVoedingInd,
                    String actPatrWassenInd, Long afspraakId,
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
                    String opnameBuitenlandInd, Date opnameDt,
                    String overGevoelVoor,
                    String patrProbleemhant, String persBezittingen,
                    Long puntenaant, String rolRelatiePatroon,
                    String rolRelatiePatrBijz, String seksualiteit,
                    String seksualiteitInd, String slaapRustPatroon,
                    String slikproblemen, String spreektaal,
                    String tweeConAdres, String tweeConNaam,
                    String tweeConRelatie, String tweeConTel,
                    String uitschPatroon, Long verantwVerplId,
                    String vervolgafspraak,
                    String waardenLevensovertuigPatr, String zelfbelevingspatr,
                    String verslaving, String allergie) {
        
        Anamnese a = new Anamnese(actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd,
                                  actPatrValtRegInd, actPatrVoedingInd, actPatrWassenInd, afspraakId,
                                  behandArts, behSpecId, beroep, beschrijvingZiektebeeld,
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
                                  vervolgafspraak, waardenLevensovertuigPatr, zelfbelevingspatr,
                                  verslaving, allergie);
        anamneseLijst.add(a);

        return a;
    }
    
    public void changeAnamnese(Anamnese a, String actPatrAankledenInd, String actPatrInameMedInd,
                    String actPatrMobInd, String actPatrToiletInd,
                    String actPatrValtRegInd, String actPatrVoedingInd,
                    String actPatrWassenInd, Long afspraakId,
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
                    String opnameBuitenlandInd, Date opnameDt,
                    String overGevoelVoor,
                    String patrProbleemhant, String persBezittingen,
                    Long puntenaant, String rolRelatiePatroon,
                    String rolRelatiePatrBijz, String seksualiteit,
                    String seksualiteitInd, String slaapRustPatroon,
                    String slikproblemen, String spreektaal,
                    String tweeConAdres, String tweeConNaam,
                    String tweeConRelatie, String tweeConTel,
                    String uitschPatroon, Long verantwVerplId,
                    String vervolgafspraak,
                    String waardenLevensovertuigPatr, String zelfbelevingspatr,
                    String verslaving, String allergie) {
        for (Anamnese anamnese : anamneseLijst) {
            if (a.getAnamneseId() == anamnese.getAnamneseId()) {
                anamnese.changeData(actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd,
                                  actPatrValtRegInd, actPatrVoedingInd, actPatrWassenInd, afspraakId,
                                  behandArts, behSpecId, beroep, beschrijvingZiektebeeld,
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
                                  vervolgafspraak, waardenLevensovertuigPatr, zelfbelevingspatr,
                                  verslaving, allergie);
                
                DatabaseController db = new DatabaseController();
                Connection c = db.makeConnection(anamnese.makeUpdateQuery());
                db.closeConnection(c);
            }
        }
    }
    
    public void removeAnamnese(Anamnese anamnese) {
        for (Anamnese a : anamneseLijst) {
            if (a.getAnamneseId() == anamnese.getAnamneseId()) {
                anamneseLijst.remove(a);
                
                DatabaseController db = new DatabaseController();
                String query = "UPDATE Anamnese SET ACTIVE_IND='0'";
                Connection c = db.makeConnection(query);
                db.closeConnection(c);
            }
        }
    }
    
    public void readAnamneses() {
        anamneseLijst.clear();
        DataInterface db = new DataBaseimplementation();
        anamneseLijst = db.getAnamneses();
    }
    
}
