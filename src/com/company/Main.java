package com.company;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<vaccine> vaccineList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.println("CoWin Portal initialised...");
            System.out.println("------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.print("Enter your command: ");
            System.out.println();
            int command = sc.nextInt();
            if (command == 1){
                System.out.print("Vaccine Name: ");
                String name = sc.next();
                System.out.print("Number of Doses: ");
                long doses = sc.nextLong();
                System.out.print("Gap between Doses: ");
                long doseGap = sc.nextLong();
                vaccine vaxi = new vaccine(name, doses, doseGap);
                vaxi.display();
                vaccineList.add(vaxi);
            }
            else if (command == 2){

            }
            else if (command == 3){

            }
            else if (command == 4){

            }
            else if (command == 5){

            }
            else if (command == 6){

            }
            else if (command == 7){

            }
            else if (command == 8){
                System.out.println();
                System.out.println("Thank you for visiting.");
                break;
            }
            else{
                System.out.println();
                System.out.println("Invalid command.");
                System.out.println("Please enter a valid command from the menu.");
            }
        }
    }
}

class vaccine{
    String name;
    long doses;
    long doseGap;
    public vaccine(String name, long doses, long doseGap){
        this.name = name;
        this.doses = doses;
        this.doseGap = doseGap;
    }
    public String getName() {
        return name;
    }
    public long getDoses() {
        return doses;
    }
    public long getDoseGap() {
        return doseGap;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDoses(long doses) {
        this.doses = doses;
    }
    public void setDoseGap(long doseGap) {
        this.doseGap = doseGap;
    }
    public void display(){
        System.out.print("Vaccine Name: " + getName() + ", ");
        System.out.print("Number of Doses: " + getDoses() + ", ");
        System.out.println("Gap Between Doses: " + getDoseGap() + ", ");
    }
}

