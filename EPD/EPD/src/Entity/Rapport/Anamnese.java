package Entity.Rapport;

import java.sql.Time;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jan
 */
public class Anamnese extends Rapport{

    private Long anamneseId;

    private String actPatrAankledenInd;
    private String actPatrInameMedInd;
    private String actPatrMobInd;
    private String actPatrToiletInd;
    private char[] actPatrValtRegInd;
    private String actPatrVoedingInd;
    private String actPatrWassenInd;
    private Long afspraakId;
    private Long allergieId;
    private Long behandArts;
    private Long behSpecId;
    private String beroep;
    private char[] beschrijvingZiektebeeld;
    private char[] bijzonderheden;
    private char[] conditie;
    private char[] condHaar;
    private char[] condHuid;
    private char[] condNagels;
    private Timestamp datumGesprekDt;
    private Long decubitusGraad;
    private String decubitusInd;
    private char[] denkWaarnPatr;
    private char[] dieet;
    private String eenConAdres;
    private String eenConNaam;
    private String eenConRelatie;
    private String eenConTel;
    private String gebrSondeInd;
    private Long gespreksvoerderId;
    private Long gewicht;
    private char[] gewichtsverloop;
    private char[] gezonheidsbeleving;
    private Long lengte;
    private Timestamp medEindDt;
    private char[] medGesch;
    private char[] medNaam;
    private Timestamp medStartDt;
    private char[] misselijkBraken;
    private String mrsaDrager;
    private String noodzBeschMaatrInd;
    private char[] noodzBeschMaatrReden;
    private String onbGewVerlies3kgInd;
    private String onbGewVerlies6kgInd;
    private String opnameBuitenlandInd;
    private Timestamp opnameDt;
    private char[] overGevoelVoor;
    private Long patientId;
    private char[] patrProbleemhant;
    private char[] persBezittingen;
    private Long puntenaant;
    private char[] rolRelatiePatroon;
    private char[] rolRelatiePatrBijz;
    private char[] seksualiteit;
    private String seksualiteitInd;
    private char[] slaapRustPatroon;
    private char[] slikproblemen;
    private String spreektaal;
    private String tweeConAdres;
    private String tweeConNaam;
    private String tweeConRelatie;
    private String tweeConTel;
    private char[] uitschPatroon;
    private Long verantwVerplId;
    private Long verslavingId;
    private Timestamp vervolgafspraak;
    private char[] waardenLevensovertuigPatr;
    private char[] zelfbelevingspatr;
    
    private List<String> verslavingLijst;
    private List<String> allergieLijst;
    
    public Anamnese() {
        
    }
    
    public Anamnese(String actPatrAankledenInd, String actPatrInameMedInd,
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
                    List<String> verslavingLijst, List<String> allergieLijst) {
        this.actPatrAankledenInd = actPatrAankledenInd;
        this.actPatrInameMedInd = actPatrInameMedInd;
        this.actPatrMobInd = actPatrMobInd;
        this.actPatrToiletInd = actPatrToiletInd;
        this.actPatrValtRegInd = actPatrValtRegInd;
        this.actPatrVoedingInd = actPatrVoedingInd;
        this.actPatrWassenInd = actPatrWassenInd;
        this.afspraakId = afspraakId;
        this.allergieId = allergieId;
        this.behandArts = behandArts;
        this.behSpecId = behSpecId;
        this.beroep = beroep;
        this.beschrijvingZiektebeeld = beschrijvingZiektebeeld;
        this.bijzonderheden = bijzonderheden;
        this.conditie = conditie;
        this.condHaar = condHaar;
        this.condHuid = condHuid;
        this.condNagels = condNagels;
        this.datumGesprekDt = datumGesprekDt;
        this.decubitusGraad = decubitusGraad;
        this.decubitusInd = decubitusInd;
        this.denkWaarnPatr = denkWaarnPatr;
        this.dieet = dieet;
        this.eenConAdres = eenConAdres;
        this.eenConNaam = eenConNaam;
        this.eenConRelatie = eenConRelatie;
        this.eenConTel = eenConTel;
        this.gebrSondeInd = gebrSondeInd;
        this.gespreksvoerderId = gespreksvoerderId;
        this.gewicht = gewicht;
        this.gewichtsverloop = gewichtsverloop;
        this.gezonheidsbeleving = gezonheidsbeleving;
        this.lengte = lengte;
        this.medEindDt = medEindDt;
        this.medGesch = medGesch;
        this.medNaam = medNaam;
        this.medStartDt = medStartDt;
        this.misselijkBraken = misselijkBraken;
        this.mrsaDrager = mrsaDrager;
        this.noodzBeschMaatrInd = noodzBeschMaatrInd;
        this.noodzBeschMaatrReden = noodzBeschMaatrReden;
        this.onbGewVerlies3kgInd = onbGewVerlies3kgInd;
        this.onbGewVerlies6kgInd = onbGewVerlies6kgInd;
        this.opnameBuitenlandInd = opnameBuitenlandInd;
        this.opnameDt = opnameDt;
        this.overGevoelVoor = overGevoelVoor;
        this.patrProbleemhant = patrProbleemhant;
        this.persBezittingen = persBezittingen;
        this.puntenaant = puntenaant;
        this.rolRelatiePatroon = rolRelatiePatroon;
        this.rolRelatiePatrBijz = rolRelatiePatrBijz;
        this.seksualiteit = seksualiteit;
        this.seksualiteitInd = seksualiteitInd;
        this.slaapRustPatroon = slaapRustPatroon;
        this.slikproblemen = slikproblemen;
        this.spreektaal = spreektaal;
        this.tweeConAdres = tweeConAdres;
        this.tweeConNaam = tweeConNaam;
        this.tweeConRelatie = tweeConRelatie;
        this.tweeConTel = tweeConTel;
        this.uitschPatroon = uitschPatroon;
        this.verantwVerplId = verantwVerplId;
        this.verslavingId = verslavingId;
        this.vervolgafspraak = vervolgafspraak;
        this.waardenLevensovertuigPatr = waardenLevensovertuigPatr;
        this.zelfbelevingspatr = zelfbelevingspatr;
        this.verslavingLijst = verslavingLijst;
        this.allergieLijst = allergieLijst;
    }
    public void changeData(String actPatrAankledenInd, String actPatrInameMedInd,
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
                    List<String> verslavingLijst, List<String> allergieLijst) {
        this.actPatrAankledenInd = actPatrAankledenInd;
        this.actPatrInameMedInd = actPatrInameMedInd;
        this.actPatrMobInd = actPatrMobInd;
        this.actPatrToiletInd = actPatrToiletInd;
        this.actPatrValtRegInd = actPatrValtRegInd;
        this.actPatrVoedingInd = actPatrVoedingInd;
        this.actPatrWassenInd = actPatrWassenInd;
        this.afspraakId = afspraakId;
        this.allergieId = allergieId;
        this.behandArts = behandArts;
        this.behSpecId = behSpecId;
        this.beroep = beroep;
        this.beschrijvingZiektebeeld = beschrijvingZiektebeeld;
        this.bijzonderheden = bijzonderheden;
        this.conditie = conditie;
        this.condHaar = condHaar;
        this.condHuid = condHuid;
        this.condNagels = condNagels;
        this.datumGesprekDt = datumGesprekDt;
        this.decubitusGraad = decubitusGraad;
        this.decubitusInd = decubitusInd;
        this.denkWaarnPatr = denkWaarnPatr;
        this.dieet = dieet;
        this.eenConAdres = eenConAdres;
        this.eenConNaam = eenConNaam;
        this.eenConRelatie = eenConRelatie;
        this.eenConTel = eenConTel;
        this.gebrSondeInd = gebrSondeInd;
        this.gespreksvoerderId = gespreksvoerderId;
        this.gewicht = gewicht;
        this.gewichtsverloop = gewichtsverloop;
        this.gezonheidsbeleving = gezonheidsbeleving;
        this.lengte = lengte;
        this.medEindDt = medEindDt;
        this.medGesch = medGesch;
        this.medNaam = medNaam;
        this.medStartDt = medStartDt;
        this.misselijkBraken = misselijkBraken;
        this.mrsaDrager = mrsaDrager;
        this.noodzBeschMaatrInd = noodzBeschMaatrInd;
        this.noodzBeschMaatrReden = noodzBeschMaatrReden;
        this.onbGewVerlies3kgInd = onbGewVerlies3kgInd;
        this.onbGewVerlies6kgInd = onbGewVerlies6kgInd;
        this.opnameBuitenlandInd = opnameBuitenlandInd;
        this.opnameDt = opnameDt;
        this.overGevoelVoor = overGevoelVoor;
        this.patientId = patientId;
        this.patrProbleemhant = patrProbleemhant;
        this.persBezittingen = persBezittingen;
        this.puntenaant = puntenaant;
        this.rolRelatiePatroon = rolRelatiePatroon;
        this.rolRelatiePatrBijz = rolRelatiePatrBijz;
        this.seksualiteit = seksualiteit;
        this.seksualiteitInd = seksualiteitInd;
        this.slaapRustPatroon = slaapRustPatroon;
        this.slikproblemen = slikproblemen;
        this.spreektaal = spreektaal;
        this.tweeConAdres = tweeConAdres;
        this.tweeConNaam = tweeConNaam;
        this.tweeConRelatie = tweeConRelatie;
        this.tweeConTel = tweeConTel;
        this.uitschPatroon = uitschPatroon;
        this.verantwVerplId = verantwVerplId;
        this.verslavingId = verslavingId;
        this.vervolgafspraak = vervolgafspraak;
        this.waardenLevensovertuigPatr = waardenLevensovertuigPatr;
        this.zelfbelevingspatr = zelfbelevingspatr;
        this.verslavingLijst = verslavingLijst;
        this.allergieLijst = allergieLijst;
    }

    @Override
    public void addValue(actionOnRapport type, Object valueA, Object valueB) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void openExcel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    public void setAnamneseId(Long anamneseId) {
        this.anamneseId = anamneseId;
    }

    public Long getAnamneseId() {
        return anamneseId;
    }

    public void setActPatrAankledenInd(String actPatrAankledenInd) {
        this.actPatrAankledenInd = actPatrAankledenInd;
    }

    public String getActPatrAankledenInd() {
        return actPatrAankledenInd;
    }

    public void setActPatrInameMedInd(String actPatrInameMedInd) {
        this.actPatrInameMedInd = actPatrInameMedInd;
    }

    public String getActPatrInameMedInd() {
        return actPatrInameMedInd;
    }

    public void setActPatrMobInd(String actPatrMobInd) {
        this.actPatrMobInd = actPatrMobInd;
    }

    public String getActPatrMobInd() {
        return actPatrMobInd;
    }

    public void setActPatrToiletInd(String actPatrToiletInd) {
        this.actPatrToiletInd = actPatrToiletInd;
    }

    public String getActPatrToiletInd() {
        return actPatrToiletInd;
    }

    public void setActPatrValtRegInd(char[] actPatrValtRegInd) {
        this.actPatrValtRegInd = actPatrValtRegInd;
    }

    public char[] getActPatrValtRegInd() {
        return actPatrValtRegInd;
    }

    public void setActPatrVoedingInd(String actPatrVoedingInd) {
        this.actPatrVoedingInd = actPatrVoedingInd;
    }

    public String getActPatrVoedingInd() {
        return actPatrVoedingInd;
    }

    public void setActPatrWassenInd(String actPatrWassenInd) {
        this.actPatrWassenInd = actPatrWassenInd;
    }

    public String getActPatrWassenInd() {
        return actPatrWassenInd;
    }

    public void setAfspraakId(Long afspraakId) {
        this.afspraakId = afspraakId;
    }

    public Long getAfspraakId() {
        return afspraakId;
    }

    public void setAllergieId(Long allergieId) {
        this.allergieId = allergieId;
    }

    public Long getAllergieId() {
        return allergieId;
    }

    public void setBehandArts(Long behandArts) {
        this.behandArts = behandArts;
    }

    public Long getBehandArts() {
        return behandArts;
    }

    public void setBehSpecId(Long behSpecId) {
        this.behSpecId = behSpecId;
    }

    public Long getBehSpecId() {
        return behSpecId;
    }

    public void setBeroep(String beroep) {
        this.beroep = beroep;
    }

    public String getBeroep() {
        return beroep;
    }

    public void setBeschrijvingZiektebeeld(char[] beschrijvingZiektebeeld) {
        this.beschrijvingZiektebeeld = beschrijvingZiektebeeld;
    }

    public char[] getBeschrijvingZiektebeeld() {
        return beschrijvingZiektebeeld;
    }

    public void setBijzonderheden(char[] bijzonderheden) {
        this.bijzonderheden = bijzonderheden;
    }

    public char[] getBijzonderheden() {
        return bijzonderheden;
    }

    public void setConditie(char[] conditie) {
        this.conditie = conditie;
    }

    public char[] getConditie() {
        return conditie;
    }

    public void setCondHaar(char[] condHaar) {
        this.condHaar = condHaar;
    }

    public char[] getCondHaar() {
        return condHaar;
    }

    public void setCondHuid(char[] condHuid) {
        this.condHuid = condHuid;
    }

    public char[] getCondHuid() {
        return condHuid;
    }

    public void setCondNagels(char[] condNagels) {
        this.condNagels = condNagels;
    }

    public char[] getCondNagels() {
        return condNagels;
    }

    public void setDatumGesprekDt(Timestamp datumGesprekDt) {
        this.datumGesprekDt = datumGesprekDt;
    }

    public Timestamp getDatumGesprekDt() {
        return datumGesprekDt;
    }

    public void setDecubitusGraad(Long decubitusGraad) {
        this.decubitusGraad = decubitusGraad;
    }

    public Long getDecubitusGraad() {
        return decubitusGraad;
    }

    public void setDecubitusInd(String decubitusInd) {
        this.decubitusInd = decubitusInd;
    }

    public String getDecubitusInd() {
        return decubitusInd;
    }

    public void setDenkWaarnPatr(char[] denkWaarnPatr) {
        this.denkWaarnPatr = denkWaarnPatr;
    }

    public char[] getDenkWaarnPatr() {
        return denkWaarnPatr;
    }

    public void setDieet(char[] dieet) {
        this.dieet = dieet;
    }

    public char[] getDieet() {
        return dieet;
    }

    public void setEenConAdres(String eenConAdres) {
        this.eenConAdres = eenConAdres;
    }

    public String getEenConAdres() {
        return eenConAdres;
    }

    public void setEenConNaam(String eenConNaam) {
        this.eenConNaam = eenConNaam;
    }

    public String getEenConNaam() {
        return eenConNaam;
    }

    public void setEenConRelatie(String eenConRelatie) {
        this.eenConRelatie = eenConRelatie;
    }

    public String getEenConRelatie() {
        return eenConRelatie;
    }

    public void setEenConTel(String eenConTel) {
        this.eenConTel = eenConTel;
    }

    public String getEenConTel() {
        return eenConTel;
    }

    public void setGebrSondeInd(String gebrSondeInd) {
        this.gebrSondeInd = gebrSondeInd;
    }

    public String getGebrSondeInd() {
        return gebrSondeInd;
    }

    public void setGespreksvoerderId(Long gespreksvoerderId) {
        this.gespreksvoerderId = gespreksvoerderId;
    }

    public Long getGespreksvoerderId() {
        return gespreksvoerderId;
    }

    public void setGewicht(Long gewicht) {
        this.gewicht = gewicht;
    }

    public Long getGewicht() {
        return gewicht;
    }

    public void setGewichtsverloop(char[] gewichtsverloop) {
        this.gewichtsverloop = gewichtsverloop;
    }

    public char[] getGewichtsverloop() {
        return gewichtsverloop;
    }

    public void setGezonheidsbeleving(char[] gezonheidsbeleving) {
        this.gezonheidsbeleving = gezonheidsbeleving;
    }

    public char[] getGezonheidsbeleving() {
        return gezonheidsbeleving;
    }

    public void setLengte(Long lengte) {
        this.lengte = lengte;
    }

    public Long getLengte() {
        return lengte;
    }

    public void setMedEindDt(Timestamp medEindDt) {
        this.medEindDt = medEindDt;
    }

    public Timestamp getMedEindDt() {
        return medEindDt;
    }

    public void setMedGesch(char[] medGesch) {
        this.medGesch = medGesch;
    }

    public char[] getMedGesch() {
        return medGesch;
    }

    public void setMedNaam(char[] medNaam) {
        this.medNaam = medNaam;
    }

    public char[] getMedNaam() {
        return medNaam;
    }

    public void setMedStartDt(Timestamp medStartDt) {
        this.medStartDt = medStartDt;
    }

    public Timestamp getMedStartDt() {
        return medStartDt;
    }

    public void setMisselijkBraken(char[] misselijkBraken) {
        this.misselijkBraken = misselijkBraken;
    }

    public char[] getMisselijkBraken() {
        return misselijkBraken;
    }

    public void setMrsaDrager(String mrsaDrager) {
        this.mrsaDrager = mrsaDrager;
    }

    public String getMrsaDrager() {
        return mrsaDrager;
    }

    public void setNoodzBeschMaatrInd(String noodzBeschMaatrInd) {
        this.noodzBeschMaatrInd = noodzBeschMaatrInd;
    }

    public String getNoodzBeschMaatrInd() {
        return noodzBeschMaatrInd;
    }

    public void setNoodzBeschMaatrReden(char[] noodzBeschMaatrReden) {
        this.noodzBeschMaatrReden = noodzBeschMaatrReden;
    }

    public char[] getNoodzBeschMaatrReden() {
        return noodzBeschMaatrReden;
    }

    public void setOnbGewVerlies3kgInd(String onbGewVerlies3kgInd) {
        this.onbGewVerlies3kgInd = onbGewVerlies3kgInd;
    }

    public String getOnbGewVerlies3kgInd() {
        return onbGewVerlies3kgInd;
    }

    public void setOnbGewVerlies6kgInd(String onbGewVerlies6kgInd) {
        this.onbGewVerlies6kgInd = onbGewVerlies6kgInd;
    }

    public String getOnbGewVerlies6kgInd() {
        return onbGewVerlies6kgInd;
    }

    public void setOpnameBuitenlandInd(String opnameBuitenlandInd) {
        this.opnameBuitenlandInd = opnameBuitenlandInd;
    }

    public String getOpnameBuitenlandInd() {
        return opnameBuitenlandInd;
    }

    public void setOpnameDt(Timestamp opnameDt) {
        this.opnameDt = opnameDt;
    }

    public Timestamp getOpnameDt() {
        return opnameDt;
    }

    public void setOverGevoelVoor(char[] overGevoelVoor) {
        this.overGevoelVoor = overGevoelVoor;
    }

    public char[] getOverGevoelVoor() {
        return overGevoelVoor;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatrProbleemhant(char[] patrProbleemhant) {
        this.patrProbleemhant = patrProbleemhant;
    }

    public char[] getPatrProbleemhant() {
        return patrProbleemhant;
    }

    public void setPersBezittingen(char[] persBezittingen) {
        this.persBezittingen = persBezittingen;
    }

    public char[] getPersBezittingen() {
        return persBezittingen;
    }

    public void setPuntenaant(Long puntenaant) {
        this.puntenaant = puntenaant;
    }

    public Long getPuntenaant() {
        return puntenaant;
    }

    public void setRolRelatiePatroon(char[] rolRelatiePatroon) {
        this.rolRelatiePatroon = rolRelatiePatroon;
    }

    public char[] getRolRelatiePatroon() {
        return rolRelatiePatroon;
    }

    public void setRolRelatiePatrBijz(char[] rolRelatiePatrBijz) {
        this.rolRelatiePatrBijz = rolRelatiePatrBijz;
    }

    public char[] getRolRelatiePatrBijz() {
        return rolRelatiePatrBijz;
    }

    public void setSeksualiteit(char[] seksualiteit) {
        this.seksualiteit = seksualiteit;
    }

    public char[] getSeksualiteit() {
        return seksualiteit;
    }

    public void setSeksualiteitInd(String seksualiteitInd) {
        this.seksualiteitInd = seksualiteitInd;
    }

    public String getSeksualiteitInd() {
        return seksualiteitInd;
    }

    public void setSlaapRustPatroon(char[] slaapRustPatroon) {
        this.slaapRustPatroon = slaapRustPatroon;
    }

    public char[] getSlaapRustPatroon() {
        return slaapRustPatroon;
    }

    public void setSlikproblemen(char[] slikproblemen) {
        this.slikproblemen = slikproblemen;
    }

    public char[] getSlikproblemen() {
        return slikproblemen;
    }

    public void setSpreektaal(String spreektaal) {
        this.spreektaal = spreektaal;
    }

    public String getSpreektaal() {
        return spreektaal;
    }

    public void setTweeConAdres(String tweeConAdres) {
        this.tweeConAdres = tweeConAdres;
    }

    public String getTweeConAdres() {
        return tweeConAdres;
    }

    public void setTweeConNaam(String tweeConNaam) {
        this.tweeConNaam = tweeConNaam;
    }

    public String getTweeConNaam() {
        return tweeConNaam;
    }

    public void setTweeConRelatie(String tweeConRelatie) {
        this.tweeConRelatie = tweeConRelatie;
    }

    public String getTweeConRelatie() {
        return tweeConRelatie;
    }

    public void setTweeConTel(String tweeConTel) {
        this.tweeConTel = tweeConTel;
    }

    public String getTweeConTel() {
        return tweeConTel;
    }

    public void setUitschPatroon(char[] uitschPatroon) {
        this.uitschPatroon = uitschPatroon;
    }

    public char[] getUitschPatroon() {
        return uitschPatroon;
    }

    public void setVerantwVerplId(Long verantwVerplId) {
        this.verantwVerplId = verantwVerplId;
    }

    public Long getVerantwVerplId() {
        return verantwVerplId;
    }

    public void setVerslavingId(Long verslavingId) {
        this.verslavingId = verslavingId;
    }

    public Long getVerslavingId() {
        return verslavingId;
    }

    public void setVervolgafspraak(Timestamp vervolgafspraak) {
        this.vervolgafspraak = vervolgafspraak;
    }

    public Timestamp getVervolgafspraak() {
        return vervolgafspraak;
    }

    public void setWaardenLevensovertuigPatr(char[] waardenLevensovertuigPatr) {
        this.waardenLevensovertuigPatr = waardenLevensovertuigPatr;
    }

    public char[] getWaardenLevensovertuigPatr() {
        return waardenLevensovertuigPatr;
    }

    public void setZelfbelevingspatr(char[] zelfbelevingspatr) {
        this.zelfbelevingspatr = zelfbelevingspatr;
    }

    public char[] getZelfbelevingspatr() {
        return zelfbelevingspatr;
    }

    public void setVerslavingLijst(List<String> verslavingLijst) {
        this.verslavingLijst = verslavingLijst;
    }

    public List<String> getVerslavingLijst() {
        return verslavingLijst;
    }

    public void setAllergieLijst(List<String> allergieLijst) {
        this.allergieLijst = allergieLijst;
    }

    public List<String> getAllergieLijst() {
        return allergieLijst;
    }
}
