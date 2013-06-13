package Entity;

import java.sql.Time;

import java.sql.Timestamp;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import oracle.sql.DATE;

/**
 *
 * @author Jan
 */
public class Anamnese{

    private Long anamneseId;

    private String actPatrAankledenInd;
    private String actPatrInameMedInd;
    private String actPatrMobInd;
    private String actPatrToiletInd;
    private String actPatrValtRegInd;
    private String actPatrVoedingInd;
    private String actPatrWassenInd;
    private Long afspraakId;
    private Long behandArts;
    private Long behSpecId;
    private String beroep;
    private String beschrijvingZiektebeeld;
    private String bijzonderheden;
    private String conditie;
    private String condHaar;
    private String condHuid;
    private String condNagels;
    private String datumGesprekDt;
    private Long decubitusGraad;
    private String decubitusInd;
    private String denkWaarnPatr;
    private String dieet;
    private String eenConAdres;
    private String eenConNaam;
    private String eenConRelatie;
    private String eenConTel;
    private String gebrSondeInd;
    private Long gespreksvoerderId;
    private Long gewicht;
    private String gewichtsverloop;
    private String gezonheidsbeleving;
    private Long lengte;
    private String medEindDt;
    private String medGesch;
    private String medNaam;
    private String medStartDt;
    private String misselijkBraken;
    private String mrsaDrager;
    private String noodzBeschMaatrInd;
    private String noodzBeschMaatrReden;
    private String onbGewVerlies3kgInd;
    private String onbGewVerlies6kgInd;
    private String opnameBuitenlandInd;
    private Date opnameDt;
    private String overGevoelVoor;
    private Long patientId;
    private String patrProbleemhant;
    private String persBezittingen;
    private Long puntenaant;
    private String rolRelatiePatroon;
    private String rolRelatiePatrBijz;
    private String seksualiteit;
    private String seksualiteitInd;
    private String slaapRustPatroon;
    private String slikproblemen;
    private String spreektaal;
    private String tweeConAdres;
    private String tweeConNaam;
    private String tweeConRelatie;
    private String tweeConTel;
    private String uitschPatroon;
    private Long verantwVerplId;
    private String vervolgafspraak;
    private String waardenLevensovertuigPatr;
    private String zelfbelevingspatr;
    private String verslaving;
    private String allergie;
    
    public Anamnese() {
        
    }
    
    public Anamnese(String actPatrAankledenInd, String actPatrInameMedInd,
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
        this.actPatrAankledenInd = actPatrAankledenInd;
        this.actPatrInameMedInd = actPatrInameMedInd;
        this.actPatrMobInd = actPatrMobInd;
        this.actPatrToiletInd = actPatrToiletInd;
        this.actPatrValtRegInd = actPatrValtRegInd;
        this.actPatrVoedingInd = actPatrVoedingInd;
        this.actPatrWassenInd = actPatrWassenInd;
        this.afspraakId = afspraakId;
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
        this.vervolgafspraak = vervolgafspraak;
        this.waardenLevensovertuigPatr = waardenLevensovertuigPatr;
        this.zelfbelevingspatr = zelfbelevingspatr;
        this.verslaving = verslaving;
        this.allergie = allergie;
    }
    public void changeData(String actPatrAankledenInd, String actPatrInameMedInd,
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
        this.actPatrAankledenInd = actPatrAankledenInd;
        this.actPatrInameMedInd = actPatrInameMedInd;
        this.actPatrMobInd = actPatrMobInd;
        this.actPatrToiletInd = actPatrToiletInd;
        this.actPatrValtRegInd = actPatrValtRegInd;
        this.actPatrVoedingInd = actPatrVoedingInd;
        this.actPatrWassenInd = actPatrWassenInd;
        this.afspraakId = afspraakId;
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
        this.vervolgafspraak = vervolgafspraak;
        this.waardenLevensovertuigPatr = waardenLevensovertuigPatr;
        this.zelfbelevingspatr = zelfbelevingspatr;
        this.verslaving = verslaving;
        this.allergie = allergie;
    }
    
    public String makeInsertQuery() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        /*String s = sdf.format(opnameDt);
        java.util.Date d = null;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        opnameDt = new Date(d.getTime());*/
        DATE opnamedatum = new DATE(opnameDt);
        
        
        String query = "INSERT INTO Anamnese (PATIENT_ID, OPNAME_DT, DATUM_GESPREK_DT, BESCHRIJVING_ZIEKTEBEELD, BEROEP, SEKSUALITEIT_IND, " +
            "BIJZONDERHEDEN, EEN_CON_NAAM, EEN_CON_RELATIE, EEN_CON_ADRES, EEN_CON_TEL, TWEE_CON_NAAM, TWEE_CON_RELATIE, TWEE_CON_ADRES, TWEE_CON_TEL, " +
            "MED_GESCH, MED_NAAM, MED_START_DT, MED_EIND_DT, OVER_GEVOEL_VOOR, VERVOLGAFSPRAAK, OPNAME_BUITENLAND_IND, MRSA_DRAGER, SPREEKTAAL, " +
            "GEZONHEIDSBELEVING, DIEET, GEWICHT, GEWICHTSVERLOOP, MISSELIJK_BRAKEN, SLIKPROBLEMEN, COND_HUID, COND_HAAR, COND_NAGELS, CONDITIE, " +
            "LENGTE, ONB_GEW_VERLIES_6KG_IND, ONB_GEW_VERLIES_3KG_IND, GEBR_SONDE_IND, PUNTENAANT, DECUBITUS_IND, DECUBITUS_GRAAD, UITSCH_PATROON, " +
            "ACT_PATR_WASSEN_IND, ACT_PATR_AANKLEDEN_IND, ACT_PATR_TOILET_IND, ACT_PATR_VOEDING_IND, ACT_PATR_INAME_MED_IND, ACT_PATR_MOB_IND, " +
            "ACT_PATR_VALT_REG_IND, SLAAP_RUST_PATROON, DENK_WAARN_PATR, NOODZ_BESCH_MAATR_IND, NOODZ_BESCH_MAATR_REDEN, ZELFBELEVINGSPATR, " +
            "ROL_RELATIE_PATROON, ROL_RELATIE_PATR_BIJZ, SEKSUALITEIT, PATR_PROBLEEMHANT, WAARDEN_LEVENSOVERTUIG_PATR, PERS_BEZITTINGEN, VERSLAVING, " +
            "ALLERGIE, GESPREKSVOERDER_ID, VERANTW_VERPL_ID, BEH_SPEC_ID, BEHAND_ARTS, AFSPRAAK_ID) " +
            "VALUES ('"+patientId+"','"+sdf.format(opnamedatum.dateValue())+"','"+datumGesprekDt+"','"+beschrijvingZiektebeeld+"','"+beroep+"','"+seksualiteitInd+"','" +
            ""+bijzonderheden+"','"+eenConNaam+"','"+eenConRelatie+"','"+eenConAdres+"','"+eenConTel+"','"+tweeConNaam+"','"+tweeConRelatie+"','"+tweeConAdres+"','" +
            ""+tweeConTel+"','"+medGesch+"','"+medNaam+"','"+medStartDt+"','"+medEindDt+"','"+overGevoelVoor+"','"+vervolgafspraak+"','"+opnameBuitenlandInd+"','" +
            ""+mrsaDrager+"','"+spreektaal+"','"+gezonheidsbeleving+"','"+dieet+"','"+gewicht+"','"+gewichtsverloop+"','"+misselijkBraken+"','"+slikproblemen+"','" +
            ""+condHuid+"','"+condHaar+"','"+condNagels+"','"+conditie+"','"+lengte+"','"+onbGewVerlies6kgInd+"','"+onbGewVerlies3kgInd+"','"+gebrSondeInd+"','" +
            ""+puntenaant+"','"+decubitusInd+"','"+decubitusGraad+"','"+uitschPatroon+"','"+actPatrWassenInd+"','"+actPatrAankledenInd+"','"+actPatrToiletInd+"','" +
            ""+actPatrVoedingInd+"','"+actPatrInameMedInd+"','"+actPatrMobInd+"','"+actPatrValtRegInd+"','"+slaapRustPatroon+"','"+denkWaarnPatr+"','" +
            ""+noodzBeschMaatrInd+"','"+noodzBeschMaatrReden+"','"+zelfbelevingspatr+"','"+rolRelatiePatroon+"','"+rolRelatiePatrBijz+"','"+seksualiteit+"','" +
            ""+patrProbleemhant+"','"+waardenLevensovertuigPatr+"','"+persBezittingen+"','"+verslaving+"','"+allergie+"','"+gespreksvoerderId+"','" +
            ""+verantwVerplId+"','"+behSpecId+"','"+behandArts+"','"+afspraakId+"')";
        return query;
    }
    
    public String makeUpdateQuery() {
        String query = "UPDATE Anamnese SET PATIENT_ID='"+patientId+"', OPNAME_DT='"+opnameDt+"', DATUM_GESPREK_DT='"+datumGesprekDt+"', " +
            "BESCHRIJVING_ZIEKTEBEELD='"+beschrijvingZiektebeeld+" , BEROEP='"+beroep+"', SEKSUALITEIT_IND='"+seksualiteitInd+"', " +
            "BIJZONDERHEDEN='"+bijzonderheden+"', EEN_CON_NAAM='"+eenConNaam+"', EEN_CON_RELATIE='"+eenConRelatie+"', EEN_CON_ADRES='"+eenConAdres+"', " +
            "EEN_CON_TEL='"+eenConTel+"', TWEE_CON_NAAM='"+tweeConNaam+"', TWEE_CON_RELATIE='"+tweeConRelatie+"', TWEE_CON_ADRES='"+tweeConAdres+"', " +
            "TWEE_CON_TEL='"+tweeConTel+"', MED_GESCH='"+medGesch+"', MED_NAAM='"+medNaam+"', MED_START_DT='"+medStartDt+"', MED_EIND_DT='"+medEindDt+"', " +
            "OVER_GEVOEL_VOOR='"+overGevoelVoor+"', VERVOLGAFSPRAAK='"+vervolgafspraak+"', OPNAME_BUITENLAND_IND='"+opnameBuitenlandInd+"', " +
            "MRSA_DRAGER='"+mrsaDrager+"', SPREEKTAAL='"+spreektaal+"', GEZONHEIDSBELEVING='"+gezonheidsbeleving+"', DIEET='"+dieet+"', " +
            "GEWICHT='"+gewicht+"', GEWICHTSVERLOOP='"+gewichtsverloop+"', MISSELIJK_BRAKEN='"+misselijkBraken+"', SLIKPROBLEMEN='"+slikproblemen+"', " +
            "COND_HUID='"+condHuid+"', COND_HAAR='"+condHaar+"', COND_NAGELS='"+condNagels+"', CONDITIE='"+conditie+"', LENGTE='"+lengte+"', " +
            "ONB_GEW_VERLIES_6KG_IND='"+onbGewVerlies6kgInd+"', ONB_GEW_VERLIES_3KG_IND='"+onbGewVerlies3kgInd+"', GEBR_SONDE_IND='"+gebrSondeInd+"', " +
            "PUNTENAANT='"+puntenaant+"', DECUBITUS_IND='"+decubitusInd+"', DECUBITUS_GRAAD='"+decubitusGraad+"', UITSCH_PATROON='"+uitschPatroon+"', " +
            "ACT_PATR_WASSEN_IND='"+actPatrWassenInd+"', ACT_PATR_AANKLEDEN_IND='"+actPatrAankledenInd+"', ACT_PATR_TOILET_IND='"+actPatrToiletInd+"', " +
            "ACT_PATR_VOEDING_IND='"+actPatrVoedingInd+"', ACT_PATR_INAME_MED_IND="+actPatrInameMedInd+"', ACT_PATR_MOB_IND='"+actPatrMobInd+"', " +
            "ACT_PATR_VALT_REG_IND='"+actPatrValtRegInd+"', SLAAP_RUST_PATROON='"+slaapRustPatroon+"', DENK_WAARN_PATR='"+denkWaarnPatr+"', " +
            "NOODZ_BESCH_MAATR_IND='"+noodzBeschMaatrInd+"', NOODZ_BESCH_MAATR_REDEN='"+noodzBeschMaatrReden+"', ZELFBELEVINGSPATR='"+zelfbelevingspatr+"', " +
            "ROL_RELATIE_PATROON='"+rolRelatiePatroon+"', ROL_RELATIE_PATR_BIJZ='"+rolRelatiePatrBijz+"', SEKSUALITEIT='"+seksualiteit+"', " +
            "PATR_PROBLEEMHANT='"+patrProbleemhant+"', WAARDEN_LEVENSOVERTUIG_PATR='"+waardenLevensovertuigPatr+"', PERS_BEZITTINGEN='"+persBezittingen+"', " +
            "VERSLAVING='"+verslaving+"', ALLERGIE='"+allergie+"', GESPREKSVOERDER_ID='"+gespreksvoerderId+"', VERANTW_VERPL_ID='"+verantwVerplId+"', " +
            "BEH_SPEC_ID='"+behSpecId+"', BEHAND_ARTS='"+behandArts+"', AFSPRAAK_ID='"+afspraakId+"' WHERE ANAMNESE_ID='"+anamneseId+"'";
        return query;
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

    public void setActPatrValtRegInd(String actPatrValtRegInd) {
        this.actPatrValtRegInd = actPatrValtRegInd;
    }

    public String getActPatrValtRegInd() {
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

    public void setBeschrijvingZiektebeeld(String beschrijvingZiektebeeld) {
        this.beschrijvingZiektebeeld = beschrijvingZiektebeeld;
    }

    public String getBeschrijvingZiektebeeld() {
        return beschrijvingZiektebeeld;
    }

    public void setBijzonderheden(String bijzonderheden) {
        this.bijzonderheden = bijzonderheden;
    }

    public String getBijzonderheden() {
        return bijzonderheden;
    }

    public void setConditie(String conditie) {
        this.conditie = conditie;
    }

    public String getConditie() {
        return conditie;
    }

    public void setCondHaar(String condHaar) {
        this.condHaar = condHaar;
    }

    public String getCondHaar() {
        return condHaar;
    }

    public void setCondHuid(String condHuid) {
        this.condHuid = condHuid;
    }

    public String getCondHuid() {
        return condHuid;
    }

    public void setCondNagels(String condNagels) {
        this.condNagels = condNagels;
    }

    public String getCondNagels() {
        return condNagels;
    }

    public void setDatumGesprekDt(String datumGesprekDt) {
        this.datumGesprekDt = datumGesprekDt;
    }

    public String getDatumGesprekDt() {
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

    public void setDenkWaarnPatr(String denkWaarnPatr) {
        this.denkWaarnPatr = denkWaarnPatr;
    }

    public String getDenkWaarnPatr() {
        return denkWaarnPatr;
    }

    public void setDieet(String dieet) {
        this.dieet = dieet;
    }

    public String getDieet() {
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

    public void setGewichtsverloop(String gewichtsverloop) {
        this.gewichtsverloop = gewichtsverloop;
    }

    public String getGewichtsverloop() {
        return gewichtsverloop;
    }

    public void setGezonheidsbeleving(String gezonheidsbeleving) {
        this.gezonheidsbeleving = gezonheidsbeleving;
    }

    public String getGezonheidsbeleving() {
        return gezonheidsbeleving;
    }

    public void setLengte(Long lengte) {
        this.lengte = lengte;
    }

    public Long getLengte() {
        return lengte;
    }

    public void setMedEindDt(String medEindDt) {
        this.medEindDt = medEindDt;
    }

    public String getMedEindDt() {
        return medEindDt;
    }

    public void setMedGesch(String medGesch) {
        this.medGesch = medGesch;
    }

    public String getMedGesch() {
        return medGesch;
    }

    public void setMedNaam(String medNaam) {
        this.medNaam = medNaam;
    }

    public String getMedNaam() {
        return medNaam;
    }

    public void setMedStartDt(String medStartDt) {
        this.medStartDt = medStartDt;
    }

    public String getMedStartDt() {
        return medStartDt;
    }

    public void setMisselijkBraken(String misselijkBraken) {
        this.misselijkBraken = misselijkBraken;
    }

    public String getMisselijkBraken() {
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

    public void setNoodzBeschMaatrReden(String noodzBeschMaatrReden) {
        this.noodzBeschMaatrReden = noodzBeschMaatrReden;
    }

    public String getNoodzBeschMaatrReden() {
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

    public void setOpnameDt(Date opnameDt) {
        this.opnameDt = opnameDt;
    }

    public Date getOpnameDt() {
        return opnameDt;
    }

    public void setOverGevoelVoor(String overGevoelVoor) {
        this.overGevoelVoor = overGevoelVoor;
    }

    public String getOverGevoelVoor() {
        return overGevoelVoor;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatrProbleemhant(String patrProbleemhant) {
        this.patrProbleemhant = patrProbleemhant;
    }

    public String getPatrProbleemhant() {
        return patrProbleemhant;
    }

    public void setPersBezittingen(String persBezittingen) {
        this.persBezittingen = persBezittingen;
    }

    public String getPersBezittingen() {
        return persBezittingen;
    }

    public void setPuntenaant(Long puntenaant) {
        this.puntenaant = puntenaant;
    }

    public Long getPuntenaant() {
        return puntenaant;
    }

    public void setRolRelatiePatroon(String rolRelatiePatroon) {
        this.rolRelatiePatroon = rolRelatiePatroon;
    }

    public String getRolRelatiePatroon() {
        return rolRelatiePatroon;
    }

    public void setRolRelatiePatrBijz(String rolRelatiePatrBijz) {
        this.rolRelatiePatrBijz = rolRelatiePatrBijz;
    }

    public String getRolRelatiePatrBijz() {
        return rolRelatiePatrBijz;
    }

    public void setSeksualiteit(String seksualiteit) {
        this.seksualiteit = seksualiteit;
    }

    public String getSeksualiteit() {
        return seksualiteit;
    }

    public void setSeksualiteitInd(String seksualiteitInd) {
        this.seksualiteitInd = seksualiteitInd;
    }

    public String getSeksualiteitInd() {
        return seksualiteitInd;
    }

    public void setSlaapRustPatroon(String slaapRustPatroon) {
        this.slaapRustPatroon = slaapRustPatroon;
    }

    public String getSlaapRustPatroon() {
        return slaapRustPatroon;
    }

    public void setSlikproblemen(String slikproblemen) {
        this.slikproblemen = slikproblemen;
    }

    public String getSlikproblemen() {
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

    public void setUitschPatroon(String uitschPatroon) {
        this.uitschPatroon = uitschPatroon;
    }

    public String getUitschPatroon() {
        return uitschPatroon;
    }

    public void setVerantwVerplId(Long verantwVerplId) {
        this.verantwVerplId = verantwVerplId;
    }

    public Long getVerantwVerplId() {
        return verantwVerplId;
    }

    public void setVervolgafspraak(String vervolgafspraak) {
        this.vervolgafspraak = vervolgafspraak;
    }

    public String getVervolgafspraak() {
        return vervolgafspraak;
    }

    public void setWaardenLevensovertuigPatr(String waardenLevensovertuigPatr) {
        this.waardenLevensovertuigPatr = waardenLevensovertuigPatr;
    }

    public String getWaardenLevensovertuigPatr() {
        return waardenLevensovertuigPatr;
    }

    public void setZelfbelevingspatr(String zelfbelevingspatr) {
        this.zelfbelevingspatr = zelfbelevingspatr;
    }

    public String getZelfbelevingspatr() {
        return zelfbelevingspatr;
    }

    public void setVerslaving(String verslaving) {
        this.verslaving = verslaving;
    }

    public String getVerslaving() {
        return verslaving;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public String getAllergie() {
        return allergie;
    }
}
