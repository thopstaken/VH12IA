package Entity;


import Entity.Rapport.Rapport;

import java.util.Date;


public class TimeLineItem {
  
    
    private int ID;
    //patient object
    private int patientID;    
    private Date datum;
    private timeLineType  type;   
    private String titel;
    private String omschrijving;
    private int IDBehandelaar;    
    private Rapport report;
    
    public TimeLineItem(){          
        datum = new Date();
    }   
    
    
    

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the type
     */
    public timeLineType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(timeLineType type) {
        this.type = type;
    }

    /**
     * @return the titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * @return the omschrijving
     */
    public String getOmschrijving() {
        return omschrijving;
    }

    /**
     * @param omschrijving the omschrijving to set
     */
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    /**
     * @return the IDBehandelaar
     */
    public int getIDBehandelaar() {
        return IDBehandelaar;
    }

    /**
     * @param IDBehandelaar the IDBehandelaar to set
     */
    public void setIDBehandelaar(int IDBehandelaar) {
        this.IDBehandelaar = IDBehandelaar;
    }

    /**
     * @return the reports
     */
    public Rapport getReport() {
        return report;
    }

    /**
     * @param reports the reports to set
     */
    public void setReport(Rapport report) {
        this.report = report;
    }
    
    
     public enum timeLineType{
        afspraak,
        behandeling,
        checkUp,
        metingPatient    
    }
}
