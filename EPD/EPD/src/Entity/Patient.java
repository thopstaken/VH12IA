package Entity;

public class Patient {
    public Patient() {
    }
    private String patientNummer;
    private String achterNaam;
    private String voorNaam;
    private String afdeling;
    private String geboorteDatum;
    private String geslacht;
    private String opnameDatum;
    private String arts;

    public void setPatientNummer(String patientNummer) {
        this.patientNummer = patientNummer;
    }

    public String getPatientNummer() {
        return patientNummer;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setOpnameDatum(String opnameDatum) {
        this.opnameDatum = opnameDatum;
    }

    public String getOpnameDatum() {
        return opnameDatum;
    }

    public void setArts(String arts) {
        this.arts = arts;
    }

    public String getArts() {
        return arts;
    }
}
