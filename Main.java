package com.vedantkakade;
/*
* Starting date 23-09(sep)-2021
*
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Trip> trip;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice; //= Integer.MAX_VALUE ;
         trip = new ArrayList<>();

        do{
            printOptions();
            choice = scan.nextInt();


            String name;

            switch (choice){
                case 1 :
                    scan.nextLine();
                    System.out.println("Adding Trip... \nEnter name of trip:");
                    name = scan.nextLine();
                    name = name.strip();
                    //scan.nextLine();
                    trip.add(new Trip(name));
                    System.out.println(name + " Trip added Successfully");
                    break;

                case 2:
                    scan.nextLine();
                    System.out.println("Please Enter Trip Name");
                    name = scan.nextLine();
                    name = name.strip();
                    if(contains(name) != -1){
                        System.out.println("Trip " + name + " opened.");
                        System.out.println("Opening Menu for Trip " + name);
                        trip.get(contains(name)).navigateMenu();
                    }
                    else{
                        System.out.println(name + " doesn't exist.");
                    }
                    break;

                case 3:
                    if(!trip.isEmpty()){
                        for(Trip trips : trip){
                            System.out.println(trips.getName());
                        }
                    }
                    else{
                        System.out.println("You didn't went to any trip yet.");
                    }
                    break;

                case 4:
                    System.out.println("Thanking for using out Program.");
                    break;

                default:
                    System.out.println("Please Enter a Valid Choice");
                    break;
            }
        }while(choice != 4);
    }

    private static int contains(String name) {
        for(int i = 0 ; i < trip.size() ; i++){
            if (!trip.get(i).getName().equalsIgnoreCase(name)) {
                continue;
            }
            return i;
        }
        return -1;
    }


    private static void printOptions() {
        System.out.println("Please Enter Your Choice Between 1-4");
        System.out.println("\t1. Add Trip.");
        System.out.println("\t2. Open Trip.");
//        System.out.println("\t3. Check Trip Expenses.");
        System.out.println("\t3. Print All Trips Till Now.");
        System.out.println("\t4. End.");
    }
}
