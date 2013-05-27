package Entity.Rapport;

import java.util.Date;


public abstract class Rapport {  
    
    private String titel;
    private String omschrijving;
    private Date datum;
    
    public Rapport(){       
    
    }    
    
    public String toString(){        
        return getTitel()+" "+ getOmschrijving();
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
    
    public abstract void addValue(actionOnRapport type,Object valueA,Object valueB );
    public abstract void open();     
    public abstract void openExcel();
    
    public enum actionOnRapport{
        AddOnderDruk_BloedDruk,
        AddBovenDruk_BloedDruk
    }
    
  
}
