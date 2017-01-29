package net.apispark.cell30.version1.representation;

public class Address {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String street;


    @com.fasterxml.jackson.annotation.JsonProperty("street")
    public java.lang.String getStreet() {
        return street;
    }

    public void setStreet(java.lang.String street) {
        this.street = street;
    }


    private java.lang.String zipcode;


    @com.fasterxml.jackson.annotation.JsonProperty("zipcode")
    public java.lang.String getZipcode() {
        return zipcode;
    }

    public void setZipcode(java.lang.String zipcode) {
        this.zipcode = zipcode;
    }


    private java.lang.String city;


    @com.fasterxml.jackson.annotation.JsonProperty("city")
    public java.lang.String getCity() {
        return city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }

}
