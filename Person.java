package com.vedantkakade;

import java.util.ArrayList;

public class Person {
    private final String name;
    private double totalAmountPaid;
    private final ArrayList<Items> items;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name.strip();
        totalAmountPaid = 0;
        items = new ArrayList<>();
    }

    public void boughtItem(String name, int quantity , double price){
        items.add(new Items(name,quantity,price));
        totalAmountPaid = totalAmountPaid + price*quantity;
    }

    public void print(){
        System.out.print(name + " : \n");
        for (Items item : items) {
            System.out.print("\tItem Name : " + item.getItemName() + " \nPrice per Item: " + item.getPricePerItem()
                    + " \nquantity bought : " + item.getAmountOfItemsBought() + "\n");
        }

        System.out.println("Total Amount Spend :" + totalAmountPaid + "\n");
    }

}
