package Org;

import java.io.Serializable;

public class Address implements Serializable {

    private String street; //Поле не может быть null

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @Override
    public String toString() {
        return street + '\'' +
                '}';
    }
}

