/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Jan
 */
public class Rapport {
    
    private int ID;
    private String beschrijving;
    private Date datum;
    private String user;

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
     * @return the beschrijving
     */
    public String getBeschrijving() {
        return beschrijving;
    }

    /**
     * @param beschrijving the beschrijving to set
     */
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
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
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
