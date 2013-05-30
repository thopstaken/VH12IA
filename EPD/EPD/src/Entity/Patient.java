package Entity;

public class Patient {
    public Patient() {
        //empty constructor
    }
    
    private String patientId;
    private String patientNumber;
    private String firstName;
    private String prefix;
    private String surName;
    private String dateOfBirth;
    private String gender;
    private String deceased;
    private String userId;
    private String departmentId;
    private String active;

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActive() {
        return active;
    }
}