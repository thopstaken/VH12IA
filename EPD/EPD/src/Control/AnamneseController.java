package Control;

import Entity.Patient;

import Entity.Anamnese;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class AnamneseController {
    
    private ArrayList<Anamnese> anamneseLijst;
    
    public AnamneseController() {
        
    }
    
    public Anamnese createAnamnese(String actPatrAankledenInd, String actPatrInameMedInd,
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
                    Long verslavingId, String vervolgafspraak,
                    String waardenLevensovertuigPatr, String zelfbelevingspatr,
                    String verslaving, String allergie) {
        
        Anamnese a = new Anamnese(actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd,
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
                                  verslaving, allergie);
        anamneseLijst.add(a);

        return a;
    }
    
    public void changeAnamnese(Anamnese a, String actPatrAankledenInd, String actPatrInameMedInd,
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
                    Long verslavingId, String vervolgafspraak,
                    String waardenLevensovertuigPatr, String zelfbelevingspatr,
                    String verslaving, String allergie) {
        for (Anamnese anamnese : anamneseLijst) {
            if (a.getAnamneseId() == anamnese.getAnamneseId()) {
                anamnese.changeData(actPatrAankledenInd, actPatrInameMedInd, actPatrMobInd, actPatrToiletInd,
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
                String query = "DELETE FROM Anamnese WHERE ANAMNESE_ID='"+a.getAnamneseId()+"'";
                Connection c = db.makeConnection(query);
                db.closeConnection(c);
            }
        }
    }
    
}
