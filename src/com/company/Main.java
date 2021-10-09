package com.company;
import java.util.*;

public class Main {
    static ArrayList<vaccine> vaccineList = new ArrayList<>();
    static ArrayList<hospital> hospitalList = new ArrayList<>();
    static ArrayList<Long> hospitalUniqueID = new ArrayList<>();
    static ArrayList<Long> citizenUniqueID = new ArrayList<>();
    static ArrayList<citizen> citizensList = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
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
            int command = sc.nextInt();
            System.out.println();

            if (command == 1){
                System.out.print("Vaccine Name: ");
                String name = sc.next();
                System.out.print("Number of Doses: ");
                long doses = sc.nextLong();
                if (doses>1) {
                    System.out.print("Gap between Doses: ");
                    long doseGap = sc.nextLong();
                    vaccine vaxi = new vaccine(name, doses, doseGap);
                    vaxi.display();
                    vaccineList.add(vaxi);
                }
                else{
                    vaccine vaxi = new vaccine(name, doses, 0);
                    vaxi.display();
                    vaccineList.add(vaxi);
                }
            }
            else if (command == 2){
                System.out.print("Hospital Name: ");
                String name = sc.next();
                System.out.print("Pincode: ");
                long pincode = sc.nextLong();
                long uniqueID = rand.nextLong(900000) + 100000;
                while(true){
                    if (hospitalUniqueID.contains(uniqueID)){
                        uniqueID = rand.nextLong(900000) + 100000;
                    }
                    else{
                        hospitalUniqueID.add(uniqueID);
                        hospital hos = new hospital(name, pincode, uniqueID);
                        hospitalList.add(hos);
                        hos.display();
                        break;
                    }
                }
            }
            else if (command == 3){
                System.out.print("Citizen Name: ");
                String name = sc.next();
                System.out.print("Age: ");
                long age = sc.nextLong();
                System.out.print("Unique ID: ");
                long uniqueID = sc.nextLong();
                if (age<=18){
                    citizen person = new citizen(name, age, uniqueID);
                    person.display();
                    System.out.println("Only above 18 are allowed");
                }
                else{
                    if (citizenUniqueID.contains(uniqueID)){
                        System.out.println("Citizen with Unique ID " + uniqueID + " already exists.");
                    }
                    else {
                        if (uniqueID/ 100000000000L < 1) {
                            System.out.println("Invalid Unique ID");
                        }
                        else {
                            citizen person = new citizen(name, age, uniqueID);
                            citizensList.add(person);
                            person.display();
                            System.out.println("Registered");
                        }
                    }
                }
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
    private String name;
    private long doses;
    private long doseGap;
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
    public void display(){
        System.out.print("Vaccine Name: " + getName() + ", ");
        System.out.print("Number of Doses: " + getDoses() + ", ");
        System.out.println("Gap Between Doses: " + getDoseGap() + ", ");
    }
}

class hospital{
    private String name;
    private long pincode;
    private long uniqueID;
    public hospital(String name, long pincode, long uniqueID){
        this.name = name;
        this.pincode = pincode;
        this.uniqueID = uniqueID;
    }
    public String getName() {
        return name;
    }
    public long getPincode() {
        return pincode;
    }
    public long getUniqueID() {
        return uniqueID;
    }
    public void display(){
        System.out.print("Hospital Name: " + getName() + ", ");
        System.out.print("Pincode: " + getPincode() + ", ");
        System.out.println("Unique ID: " + getUniqueID() + ", ");
    }
}

class citizen{
    private String name;
    private long age;
    private long uniqueID;
    public citizen(String name, long age, long uniqueID){
        this.name = name;
        this.age = age;
        this.uniqueID = uniqueID;
    }
    public String getName() {
        return name;
    }
    public long getAge(){
        return age;
    }
    public long getUniqueID() {
        return uniqueID;
    }
    public void display(){
        System.out.print("Citizen Name: " + getName() + ", ");
        System.out.print("Age: " + getAge() + ", ");
        System.out.println("Unique ID: " + getUniqueID() + ", ");
    }
}