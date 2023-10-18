package org.example;

import java.util.List;
import java.util.Objects;

public class PersonDTO {

    private String name;
    private int age;
    private String email;
    private List<AddressDto> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return getAge() == personDTO.getAge() && getName().equals(personDTO.getName()) && getEmail().equals(personDTO.getEmail()) && getAddresses().equals(personDTO.getAddresses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getEmail(), getAddresses());
    }
}
