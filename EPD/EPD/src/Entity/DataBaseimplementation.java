/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jan
 */
public class DataBaseimplementation implements DataInterface {

    DatabaseConnection DBcon;
    public DataBaseimplementation(){
      DBcon = new DatabaseConnection();
    }
    
    @Override
    public ArrayList<TimeLineItem> getAllTimeLineItems(int patientID) {
        ArrayList<TimeLineItem> list = new ArrayList<TimeLineItem>();
        try{
        ResultSet dataSet =  DBcon.runGetDataQuery("SELECT * FROM TIMELINEITEM WHERE PATIENT_ID ="+patientID+")");
        
        while(dataSet.next()){
             
                            String ID = dataSet.getString("TIMELINE_ID");                            
                            String datum = dataSet.getString("DATUM");
                            String type = dataSet.getString("TYPE");
                            String titel = dataSet.getString("TITEL");
                            String omschrijving = dataSet.getString("OMSCHRIJVING");
                            String IDBehandelaar = dataSet.getString("BEHANDELAAR_ID");
                            String rapportID = dataSet.getString("RAPPORT_ID");
                            
                        TimeLineItem item = new TimeLineItem();
                            item.setTitel(titel);
                            item.setType(EnumCollection.fromStringTimeLineType(type));
                            item.setOmschrijving(omschrijving);   
                        list.add(item);
                   }
        }
        catch(Exception ex){
            
        }
        /*TimeLineControl TLC  =  TimeLineControl.getInstance();
     //0 replace with Patient en behandelaat
     TimeLineItem item = TLC.addTimeLineItem(0, EnumCollection.timeLineType.bloedDrukMeting, "BloedDruk meting", Opmerking, 0);
     item.addActionToTimeLineItem(bloeddruk, EnumCollection.timeLineType.bloedDrukMeting);
     */
        return list;
     }
    
    @Override
    public boolean newBloedDruk(BloedDruk bloedDruk) {
       try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

    @Override
    public boolean updateBloedDruk(BloedDruk bloedDruk) {
        try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

    @Override
    public boolean deleteBloedDruk(BloedDruk bloedDruk) {
       try{
            DBcon.runQuery("");
            return true;
         }
       catch(Exception ex){
            return false;
        }
      
    }

   

    @Override
    public ArrayList<Rapport> getRapportByPatientID(int ID) {
        ArrayList<Rapport> rapport_Arraylist = new ArrayList<Rapport>();
        try{
            ResultSet dataSet =  DBcon.runGetDataQuery(

            "SELECT RAPPORT.RAPPORT_ID, RAPPORT.BESCHRIJVING, RAPPORT.DATUM_DT, RAPPORT.USER FROM PATIENT INNER JOIN PATIENT_RAPPORT ON PATIENT.PATIENT_ID = PATIENT_RAPPORT.PATIENT_ID INNER JOIN RAPPORT ON PATIENT_RAPPORT.RAPPORT_VITAL_ID = RAPPORT.RAPPORT_ID WHERE PATIENT_RAPPORT.ACTIVE_IND = 1 AND PATIENT.PATIENT_ID = "+ID+" ORDER BY PATIENT.PATIENT_ID)");

            while(dataSet.next()){
                int rapportID = Integer.parseInt(dataSet.getString("RAPPORT_ID"));
                String beschrijving = dataSet.getString("BESCHRIJVING");
                String user = dataSet.getString("USER");
                Date create_date = new SimpleDateFormat("dd-mm-yy", Locale.ENGLISH).parse(dataSet.getString("DATUM_DT"));
                Rapport rapport = new Rapport();
                rapport.setID(rapportID);
                rapport.setBeschrijving(beschrijving);
                rapport.setDatum(create_date);
                rapport.setUser(user);
                rapport_Arraylist.add(rapport);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return rapport_Arraylist;
    }

    @Override
    public boolean newRapport(Rapport rapport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateRapport(Rapport rapport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteRapport(Rapport rapport) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BloedDruk> getBloedDrukByPatientID(int ID) {
        
        ArrayList<BloedDruk> bloeddruk_Arraylist = new ArrayList<BloedDruk>();
        
        try{
            ResultSet dataSet =  DBcon.runGetDataQuery(

            "SELECT RAPPORT_VITAL.ONDERDRUK, RAPPORT_VITAL.BOVENDRUK, RAPPORT_VITAL.CREATE_DT, RAPPORT_VITAL.SATURATIE FROM PATIENT INNER JOIN PATIENT_RAPPORT_VITAL ON PATIENT.PATIENT_ID = PATIENT_RAPPORT_VITAL.PATIENT_ID INNER JOIN RAPPORT_VITAL ON PATIENT_RAPPORT_VITAL.RAPPORT_VITAL_ID = RAPPORT_VITAL.RAPPORT_VITAL_ID WHERE PATIENT_RAPPORT_VITAL.ACTIVE_IND = 1 AND PATIENT.PATIENT_ID = "+ID+" ORDER BY PATIENT.PATIENT_ID)");

            while(dataSet.next()){
                int onderdruk = Integer.parseInt(dataSet.getString("ONDERDRUK"));
                int bovendruk = Integer.parseInt(dataSet.getString("BOVENDRUK"));
                int saturatie = Integer.parseInt(dataSet.getString("SATURATIE"));
                Calendar create_date = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
                create_date.setTime(sdf.parse(dataSet.getString("CREATE_DT")));
                BloedDruk bloeddruk = new BloedDruk();
                bloeddruk.addBovenDrukValue(bovendruk, create_date);
                bloeddruk.addOnderDrukValue(onderdruk, create_date);
                bloeddruk.addSaturationValue(saturatie, create_date);
                bloeddruk_Arraylist.add(bloeddruk);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return bloeddruk_Arraylist;
    }

    public ArrayList<Anamnese> getAnamneses() {
       ArrayList<Anamnese> anamneseLijst = new ArrayList<Anamnese>();
       
       try{
           String query = "SELECT * FROM Anamnese WHERE ACTIVE_IND='1'";
           
           ResultSet rs = DBcon.runGetDataQuery(query);
           
           while (rs.next()) {
               String actPatrAankledenInd = rs.getString("ACT_PATR_AANKLEDEN_IND");
               String actPatrInameMedInd = rs.getString("ACT_PATR_INAME_MED_IND");
               String actPatrMobInd = rs.getString("ACT_PATR_MOB_IND");
               String actPatrToiletInd = rs.getString("ACT_PATR_TOILET_IND");
               String actPatrValtRegInd = rs.getString("ACT_PATR_VALT_REG_IND");
               String actPatrVoedingInd = rs.getString("ACT_PATR_VOEDING_IND");
               String actPatrWassenInd = rs.getString("ACT_PATR_WASSEN_IND");
               Long afspraakId = rs.getLong("AFSPRAAK_ID");
               Long behandArts = rs.getLong("BEHAND_ARTS");
               Long behSpecId = rs.getLong("BEH_SPEC_ID");
               String beroep = rs.getString("BEROEP");
               String beschrijvingZiektebeeld = rs.getString("BESCHRIJVING_ZIEKTEBEELD");
               String bijzonderheden = rs.getString("BIJZONDERHEDEN");
               String conditie = rs.getString("CONDITIE");
               String condHaar = rs.getString("COND_HAAR");
               String condHuid = rs.getString("COND_HUID");
               String condNagels = rs.getString("COND_NAGELS");
               String datumGesprekDt = rs.getString("DATUM_GESPREK_DT");
               Long decubitusGraad = rs.getLong("DECUBITUS_GRAAD");
               String decubitusInd = rs.getString("DECUBITUS_IND");
               String denkWaarnPatr = rs.getString("DENK_WAARN_PATR");
               String dieet = rs.getString("DIEET");
               String eenConAdres = rs.getString("EEN_CON_ADRES");
               String eenConNaam = rs.getString("EEN_CON_NAAM");
               String eenConRelatie = rs.getString("EEN_CON_RELATIE");
               String eenConTel = rs.getString("EEN_CON_TEL");
               String gebrSondeInd = rs.getString("GEBR_SONDE_IND");
               Long gespreksvoerderId = rs.getLong("GESPREKSVOERDER_ID");
               Long gewicht = rs.getLong("GEWICHT");
               String gewichtsverloop = rs.getString("GEWICHTSVERLOOP");
               String gezonheidsbeleving = rs.getString("GEZONHEIDSBELEVING");
               Long lengte = rs.getLong("LENGTE");
               String medEindDt = rs.getString("MED_EIND_DT");
               String medGesch = rs.getString("MED_GESCH");
               String medNaam = rs.getString("MED_NAAM");
               String medStartDt = rs.getString("MED_START_DT");
               String misselijkBraken = rs.getString("MISSELIJK_BRAKEN");
               String mrsaDrager = rs.getString("MRSA_DRAGER");
               String noodzBeschMaatrInd = rs.getString("NOODZ_BESCH_MAATR_IND");
               String noodzBeschMaatrReden = rs.getString("NOODZ_BESCH_MAATR_REDEN");
               String onbGewVerlies3kgInd = rs.getString("ONB_GEW_VERLIES_3KG_IND");
               String onbGewVerlies6kgInd = rs.getString("ONB_GEW_VERLIES_6KG_IND");
               String opnameBuitenlandInd = rs.getString("OPNAME_BUITENLAND_IND");
               java.sql.Date opnameDt = rs.getDate("OPNAME_DT");
               String overGevoelVoor = rs.getString("OVER_GEVOEL_VOOR");
               Long patientId = rs.getLong("PATIENT_ID");
               String patrProbleemhant = rs.getString("PATR_PROBLEEMHANT");
               String persBezittingen = rs.getString("PERS_BEZITTINGEN");
               Long puntenaant = rs.getLong("PUNTENAANT");
               String rolRelatiePatroon = rs.getString("ROL_RELATIE_PATROON");
               String rolRelatiePatrBijz = rs.getString("ROL_RELATIE_PATR_BIJZ");
               String seksualiteit = rs.getString("SEKSUALITEIT");
               String seksualiteitInd = rs.getString("SEKSUALITEIT_IND");
               String slaapRustPatroon = rs.getString("SLAAP_RUST_PATROON");
               String slikproblemen = rs.getString("SLIKPROBLEMEN");
               String spreektaal = rs.getString("SPREEKTAAL");
               String tweeConAdres = rs.getString("TWEE_CON_ADRES");
               String tweeConNaam = rs.getString("TWEE_CON_NAAM");
               String tweeConRelatie = rs.getString("TWEE_CON_RELATIE");
               String tweeConTel = rs.getString("TWEE_CON_TEL");
               String uitschPatroon = rs.getString("UITSCH_PATROON");
               Long verantwVerplId = rs.getLong("VERANTW_VERPL_ID");
               String vervolgafspraak = rs.getString("VERVOLGAFSPRAAK");
               String waardenLevensovertuigPatr = rs.getString("WAARDEN_LEVENSOVERTUIG_PATR");
               String zelfbelevingspatr = rs.getString("ZELFBELEVINGSPATR");
               String verslaving = rs.getString("VERSLAVING");
               String allergie = rs.getString("ALLERGIE");
               
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
               a.setPatientId(patientId);
               anamneseLijst.add(a);
           }
           
       }
        catch(Exception ex){
            System.out.println(ex);
        }
       
       return anamneseLijst;
    }
}
