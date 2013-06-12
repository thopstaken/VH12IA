package Entity;


import java.util.Date;


public class TimeLineItem implements Comparable<TimeLineItem> {

    private int ID;
    private int patientID;
    private Date datum;
    private String titel;
    private String omschrijving;
    private int IDBehandelaar;
    
    //system data
    private EnumCollection.timeLineType type;
   

    //To Do add all kind of actions
    private BloedDruk bloeddruk;
    private Rapport rapport; 
    private Anamnese anamnese;


    public TimeLineItem() {
        datum = new Date();
    }
    

    public void addActionToTimeLineItem(Object item, EnumCollection.timeLineType type) {
        this.type = type;

        if (type == EnumCollection.timeLineType.bloedDrukMeting) {
            bloeddruk = (BloedDruk)item;
        } else if (type == EnumCollection.timeLineType.rapport) {
            rapport = (Rapport)item;
        }
        else if (type == EnumCollection.timeLineType.anamnese) {
            anamnese = (Anamnese)item;
        }
    }

    public Object getActionFromTimeLineItem() {
        if (type == EnumCollection.timeLineType.bloedDrukMeting) {
            return bloeddruk;
        } else if (type == EnumCollection.timeLineType.rapport) {
            return rapport;
        } 
        else if (type == EnumCollection.timeLineType.anamnese) {
                return anamnese;
                } 
        else {
            return null;
        }
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
    public EnumCollection.timeLineType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EnumCollection.timeLineType type) {
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

    @Override
    public int compareTo(TimeLineItem o) {
        return getDatum().compareTo(o.getDatum());
    }


}
