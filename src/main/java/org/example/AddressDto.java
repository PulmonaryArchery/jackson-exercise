package org.example;

import java.util.Objects;

public class AddressDto {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String council;
    private String postcode;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCouncil() {
        return council;
    }

    public void setCouncil(String council) {
        this.council = council;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return getAddressLine1().equals(that.getAddressLine1()) && getAddressLine2().equals(that.getAddressLine2()) && getCity().equals(that.getCity()) && getCouncil().equals(that.getCouncil()) && getPostcode().equals(that.getPostcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressLine1(), getAddressLine2(), getCity(), getCouncil(), getPostcode());
    }
}
