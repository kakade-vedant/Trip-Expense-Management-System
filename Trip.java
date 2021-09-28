package com.vedantkakade;

import java.util.ArrayList;
import java.util.Scanner;

public class Trip {
    private final String name ;
    private final ArrayList<Person> people;
    private final Scanner scan = new Scanner(System.in);

    public Trip(String name) {
        this.name = name.strip();
        people = new ArrayList<>();
    }

    private boolean addPerson(String name){
        if(existInPerson(name) == -1)
        {
            people.add(new Person(name));
            return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean bought(String personName){
        if(existInPerson(personName) != -1){
            System.out.println("Please enter Item Name:");
            String itemName = scan.nextLine();
            itemName = itemName.strip();

            System.out.println("Please enter quantity bought:");
            int quantity = scan.nextInt();

            System.out.println("Please enter price per Item:");
            double price =  scan.nextDouble();

            people.get(existInPerson(personName)).boughtItem(itemName,quantity,price);

            return true;
        }
        return false;
    }
    private int existInPerson(String name) {
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        System.out.println("For Trip " + name + ":\n");
        for (Person person : people) {
            person.print();
        }
    }

    public int printOptions() {
        System.out.println("Please Enter Your Choice Between 1-4");
        System.out.println("\t1. Add person.");
        System.out.println("\t2. Show person details.");
        System.out.println("\t3. Bought Item.");
        System.out.println("\t4. Print All people in Trips.");
        System.out.println("\t5. End.");

        return scan.nextInt();
    }

    public void navigateMenu(){
        int choice = printOptions();
        do{
            String personName;

            switch (choice){
                case 1 :
                    scan.nextLine();
                    System.out.println("Enter name of the Person:");
                    personName = scan.nextLine();
                    personName = personName.strip();
                    if(addPerson(personName)){
                        System.out.println(personName + " Added Successfully.");
                    }
                    else{
                        System.out.println(personName + " Already with you.");
                    }

                    break;

                case 2 :
                    scan.nextLine();
                    System.out.println("Please Enter Person Name:");
                    personName = scan.nextLine();
                    personName = personName.strip();
                    if(existInPerson(personName) != -1){
                        //System.out.println("Showing " + name + " details.");
                        people.get(existInPerson(personName)).print();
                    }
                    else{
                        System.out.println(personName + " didn't came with you.");
                    }

                    break;

                case 3 :
                    scan.nextLine();
                    System.out.println("Enter buyer's Name:");
                    personName = scan.nextLine();
                    personName = personName.strip();
                    if(bought(personName)){
                        System.out.println("Expense Added Successfully");
                    }
                    else{
                        System.out.println(personName + " didn't Came with you.");
                    }
                    break;

                case 4 :
                    print();
                    break;

                case 5 :
                    return;

                default:
                    System.out.println("please Enter Valid Choice");
            }

            choice = printOptions();
        }while(choice != 5);
    }


}
