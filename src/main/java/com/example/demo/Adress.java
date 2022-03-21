package com.example.demo;

public class Adress {
    public String street;
    public int house ;
    public Short floor;

    public Adress() {
    }

    public Adress(String street, int house, Short floor) {
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", house=" + house +
                ", floor=" + floor +
                '}';
    }
}
