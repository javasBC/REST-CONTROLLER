package com.example.demo;

public class Restaurant {
    public int id ;
    public String name ;
    public Adress adrress ;
    public String foodtype  ;
    public Double  price ;

    public Restaurant(int id, String name, Adress adrress, String foodtype, Double price) {
        this.id = id;
        this.name = name;
        this.adrress = adrress;
        this.foodtype = foodtype;
        this.price = price;
    }
    public Restaurant() {
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adrress=" + adrress +
                ", foodtype='" + foodtype + '\'' +
                ", price=" + price +
                '}';
    }
}
