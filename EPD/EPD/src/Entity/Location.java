package Entity;

public class Location {
    private String propertyName;
    private String streetName;
    private int streetNr;
    private String city;
    private String zipcode;
    private String country;

    public Location(String propertyName, String streetName, int streetNr, String city, String zipcode, String country)
    {
        this.propertyName = propertyName;
        this.streetName = streetName;
        this.streetNr = streetNr;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }
    

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetNr(int streetNr) {
        this.streetNr = streetNr;
    }

    public int getStreetNr() {
        return streetNr;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
