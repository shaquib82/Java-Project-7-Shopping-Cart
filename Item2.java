package com.company;

public class Item2 {
    private String name;
    private double price;

    public Item2(String name, double price){
        if(name.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if(price<0){
            throw new IllegalArgumentException("Price cannot be less than 0 ");
        }
        this.name = name;
        this.price=price;
    }

    public Item2(Item2 copy){
        this.name = copy.name;
        this.price=copy.price;
    }
    public String toString(){
        return name + ": $" + price + " ";
    }


    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Item2)){
            return false;
        }
        Item2 item = (Item2)obj;
        return this.name.equals(item.name) && this.price == item.price;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<0){
            throw new IllegalArgumentException("Price cannot be less than 0 ");
        }
        this.price = price;
    }


}
