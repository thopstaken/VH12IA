package Entity;

import java.util.Date;

public class Patient {
        private int patientNr;
	private String firstName;
        private String insertion;
        private String surname;
        private Date dateOfBirth;
        private Sex sex;
        private boolean death;


    public Patient(int patientNr, String firstName, String insertion, String surname, Date dateOfBirth, Sex sex, boolean death)
    {
        this.patientNr = patientNr;
        this.firstName = firstName;
        this.insertion = insertion;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.death = death;
    }

    public enum Sex
    {
        MAN, WOMAN    
    }
    
    public void setPatientNr(int patientNr) {
        this.patientNr = patientNr;
    }

    public int getPatientNr() {
        return patientNr;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setSex(Patient.Sex sex) {
        this.sex = sex;
    }

    public Patient.Sex getSex() {
        return sex;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public boolean isDeath() {
        return death;
    }
}