package com.company;

import java.util.ArrayList;

public class Cart {
    ArrayList <Item2> items;
    public Cart(){
        items = new ArrayList<Item2>();
    }

    public Item2 getItems(int index) {
        return new Item2(this.items.get(index));
    }
    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public void setItems(int index,Item2 item) {
        items.add(index,new Item2(item));
    }
    public boolean add(Item2 item){
      boolean contains = items.contains(item);
      if(!contains){
          items.add(new Item2(item));
          return false;
      }
      else {
          return true;
      }

    }


    public void remove(String name){
        if(items.size()>=1){
            for (int i = 0; i < items.size() ; i++) {
                if(items.get(i).getName().equalsIgnoreCase(name)) {
                    this.items.remove(i);
                }
            }

        }
        else{
            throw new IllegalArgumentException("There are no items in your cart!");
        }


    }

    public String checkout(){
        if(items.size()==0){
            throw new IllegalArgumentException("There are no items in your cart!");
        }
        else{
            double price = 0;
            for (int i = 0; i <items.size() ; i++) {
                price+= items.get(i).getPrice();
            }
            double tax = .13*price;
            double total = tax+price;
            return  "\tRECEIPT\n\n" +
                    "\tSubtotal: $" + price + "\n" +
                    "\tTax: $" + tax + "\n" +
                    "\tTotal: $" + total + "\n";
        }
        }

    public String toString(){
        String temp="";
        for (int i = 0; i < items.size() ; i++) {
          temp +=  items.get(i).toString();
          temp+="\n";
        }
return temp;

    }





    /**
     * Name: add
     * @param item
     * @return boolean
     *
     * Inside the function:
     *   1. Adds an item to the cart if it wasn't already added.
     */




    /**
     * Name: remove
     * @param name
     *
     * Inside the function:
     *   1. Removes the item that matches the name passed in.
     */




    /**
     *  Name: checkout
     *  @return (String)
     *
     *  Inside the function:
     *   1. Calculates the subtotal (price before tax).
     *   2. Calculates the tax (assume tax is 13%).
     *   3. Calculates total: subtotal + tax
     *   4. Returns a String that resembles a receipt. See below.
     */
}
