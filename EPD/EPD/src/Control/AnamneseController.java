package Control;

import Entity.Patient;

import Entity.Anamnese;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class AnamneseController {
    
    private ArrayList<Anamnese> anamneseLijst;
    
    public AnamneseController() {
        
    }
    
    public Anamnese createAnamnese(String actPatrAankledenInd,
                               String actPatrInameMedInd, String actPatrMobInd,
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
                               String opnameBuitenlandInd, Timestamp opnameDt,
                               char[] overGevoelVoor,
                               char[] patrProbleemhant, char[] persBezittingen,
                               Long puntenaant, char[] rolRelatiePatroon,
                               char[] rolRelatiePatrBijz, char[] seksualiteit,
                               String seksualiteitInd, char[] slaapRustPatroon,
                               char[] slikproblemen, String spreektaal,
                               String tweeConAdres, String tweeConNaam,
                               String tweeConRelatie, String tweeConTel,
                               char[] uitschPatroon, Long verantwVerplId,
                               Long verslavingId, Timestamp vervolgafspraak,
                               char[] waardenLevensovertuigPatr,
                               char[] zelfbelevingspatr,
                               String verslaving,
                               String allergie) {
        
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
                    char[] actPatrValtRegInd, String actPatrVoedingInd,
                    String actPatrWassenInd, Long afspraakId, Long allergieId,
                    Long behandArts, Long behSpecId, String beroep,
                    char[] beschrijvingZiektebeeld, char[] bijzonderheden,
                    char[] conditie, char[] condHaar, char[] condHuid,
                    char[] condNagels, Timestamp datumGesprekDt,
                    Long decubitusGraad, String decubitusInd,
                    char[] denkWaarnPatr, char[] dieet, String eenConAdres,
                    String eenConNaam, String eenConRelatie, String eenConTel,
                    String gebrSondeInd, Long gespreksvoerderId, Long gewicht,
                    char[] gewichtsverloop, char[] gezonheidsbeleving,
                    Long lengte, Timestamp medEindDt, char[] medGesch,
                    char[] medNaam, Timestamp medStartDt,
                    char[] misselijkBraken, String mrsaDrager,
                    String noodzBeschMaatrInd, char[] noodzBeschMaatrReden,
                    String onbGewVerlies3kgInd, String onbGewVerlies6kgInd,
                    String opnameBuitenlandInd, Timestamp opnameDt,
                    char[] overGevoelVoor,
                    char[] patrProbleemhant, char[] persBezittingen,
                    Long puntenaant, char[] rolRelatiePatroon,
                    char[] rolRelatiePatrBijz, char[] seksualiteit,
                    String seksualiteitInd, char[] slaapRustPatroon,
                    char[] slikproblemen, String spreektaal,
                    String tweeConAdres, String tweeConNaam,
                    String tweeConRelatie, String tweeConTel,
                    char[] uitschPatroon, Long verantwVerplId,
                    Long verslavingId, Timestamp vervolgafspraak,
                    char[] waardenLevensovertuigPatr, char[] zelfbelevingspatr,
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
            }
        }
    }
    
    public void removeAnamnese(Anamnese anamnese) {
        for (Anamnese a : anamneseLijst) {
            if (a.getAnamneseId() == anamnese.getAnamneseId()) {
                anamneseLijst.remove(a);
            }
        }
    }
    
}
