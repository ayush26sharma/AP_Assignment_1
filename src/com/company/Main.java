package com.company;

import java.util.*;

public class Main {
    static ArrayList<vaccine> vaccineList = new ArrayList<>();
    static ArrayList<hospital> hospitalList = new ArrayList<>();
    static ArrayList<Long> hospitalUniqueID = new ArrayList<>();
    static ArrayList<Long> citizenUniqueID = new ArrayList<>();
    static ArrayList<citizen> citizensList = new ArrayList<>();
    static  ArrayList<slot> vaxSlots = new ArrayList<>();

    public static citizen searchPatient(long patientID){
        for (citizen patient: citizensList) {
            if (patient.getUniqueID()==patientID){
                return patient;
            }
        }
        return null;
    }
    public static hospital searchHospital(long hosID){
        for (hospital hos: hospitalList) {
            if (hos.getUniqueID()==hosID){
                return hos;
            }
        }
        return null;
    }

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
                System.out.print("Enter Hospital ID: ");
                long ID = sc.nextLong();
                if (hospitalUniqueID.contains(ID)){
                    System.out.print("Enter number of Slots to be added: ");
                    long numberOfSlots = sc.nextLong();
                    for (int i = 0; i < numberOfSlots ; i++) {
                        System.out.print("Enter Day Number: ");
                        long dayNumber = sc.nextLong();
                        System.out.print("Enter Quantity: ");
                        long quantity = sc.nextLong();
                        System.out.println("Select Vaccine: ");
                        for (int j = 0; j < vaccineList.size() ; j++) {
                            System.out.println(j + "." + vaccineList.get(j).getName());
                        }
                        int vaxNum = sc.nextInt();
                        if (vaxNum< vaccineList.size()) {
                            slot s = new slot(dayNumber, vaccineList.get(vaxNum), quantity, ID);
                            for (hospital j: hospitalList) {
                                if (j.getUniqueID()==ID){
                                    j.slots.add(s);
                                    vaxSlots.add(s);
                                    s.display();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else if (command == 5) {

                System.out.print("Enter patient Unique ID: ");
                long patientID = sc.nextLong();
                citizen person = searchPatient(patientID);
                if (person != null) {
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    int comm = sc.nextInt();

                    if (comm == 1) {
                        if (person.status == null){
                            ArrayList<hospital> availableHos = new ArrayList<>();
                            ArrayList<slot> availableSlots = new ArrayList<>();
                            System.out.println("Enter Pincode: ");
                            long pincode = sc.nextLong();
                            for (hospital hos : hospitalList) {
                                if (hos.getPincode() == pincode) {
                                    System.out.println(hos.getUniqueID() + " " + hos.getName());
                                    availableHos.add(hos);
                                }
                            }
                            System.out.print("Enter Hospital ID: ");
                            long hosID = sc.nextLong();
                            int x = 0;
                            for (hospital hos : availableHos) {
                                if (hos.getUniqueID() == hosID) {
                                    if (!hos.slots.isEmpty()) {                                     // partially vaccinated walo ka rehta hai
                                        for (slot s : hos.slots) {
                                            if (s.quantity > 0) {
                                                System.out.print(x + "-> ");
                                                s.printDetails();
                                                availableSlots.add(s);
                                                x++;
                                            } else {
                                                System.out.println("No slots available.");
                                            }
                                        }
                                    } else {
                                        System.out.println("No slots available.");
                                    }
                                }
                            }
                            System.out.print("Choose Slot: ");
                            int m = sc.nextInt();
                            if (m < availableSlots.size()) {
                                System.out.println(searchPatient(patientID).getName() + " vaccinated with " + availableSlots.get(m).vax.getName());
                                person.status.giveDose(person.status.dosesGiven);
                                person.status.updateStatus();
                                availableSlots.get(m).quantity--;
                                if (availableSlots.get(m).quantity==0){
                                    hospital hos = searchHospital(hosID);
                                    hos.slots.remove(availableSlots.get(m));
                                    availableSlots.remove(m);
                                }
                            }
                        }
                        else if (person.status.vStatus.equals("PARTIALLY VACCINATED")){
                            ArrayList<hospital> availableHos = new ArrayList<>();
                            ArrayList<slot> availableSlots = new ArrayList<>();
                            System.out.println("Enter Pincode: ");
                            long pincode = sc.nextLong();
                            for (hospital hos : hospitalList) {
                                if (hos.getPincode() == pincode) {
                                    System.out.println(hos.getUniqueID() + " " + hos.getName());
                                    availableHos.add(hos);
                                }
                            }
                            System.out.print("Enter Hospital ID: ");
                            long hosID = sc.nextLong();
                            int x = 0;
                            for (hospital hos : availableHos) {
                                if (hos.getUniqueID() == hosID) {
                                    if (!hos.slots.isEmpty()) {                                     // partially vaccinated walo ka rehta hai
                                        for (slot s : hos.slots) {
                                            if (s.dayNumber == person.status.vax.getDoseGap() ) {
                                                System.out.print(x + "-> ");
                                                s.printDetails();
                                                availableSlots.add(s);
                                                x++;
                                            } else {
                                                System.out.println("No slots available.");
                                            }
                                        }
                                    } else {
                                        System.out.println("No slots available.");
                                    }
                                }
                            }
                            System.out.print("Choose Slot: ");
                            int m = sc.nextInt();
                            if (m < availableSlots.size()) {
                                System.out.println(searchPatient(patientID).getName() + " vaccinated with " + availableSlots.get(m).vax.getName());
                                person.status.giveDose(person.status.dosesGiven);
                                person.status.updateStatus();
                                availableSlots.get(m).quantity--;
                                if (availableSlots.get(m).quantity==0){
                                    hospital hos = searchHospital(hosID);
                                    hos.slots.remove(availableSlots.get(m));
                                    availableSlots.remove(m);
                                }
                            }
                        }
                        else if (person.status.vStatus.equals("FULLY VACCINATED")){
                            System.out.println("Patient is already fully vaccinated.");
                        }
                    }
                    else if (comm == 2){
                        ArrayList<hospital>availableHos = new ArrayList<>();
                        ArrayList<slot> availableSlots = new ArrayList<>();
                        System.out.println("Enter Vaccine name: ");
                        String vaxName = sc.next();
                        for (hospital hos: hospitalList) {
                            for (slot s: hos.slots) {
                                if (s.vax.getName().equals(vaxName)){
                                    System.out.println(hos.getUniqueID() + " " + hos.getName());
                                    availableHos.add(hos);
                                }
                            }
                        }
                        long hosID = sc.nextLong();
                        int x = 0;
                        for (hospital hos : availableHos) {
                            if (hos.getUniqueID() == hosID) {
                                if (!hos.slots.isEmpty()) {                                     // partially vaccinated walo ka rehta hai
                                    for (slot s : hos.slots) {
                                        if (s.quantity > 0) {
                                            System.out.print(x + "-> ");
                                            s.printDetails();
                                            availableSlots.add(s);
                                            x++;
                                        } else {
                                            System.out.println("No slots available.");
                                        }
                                    }
                                } else {
                                    System.out.println("No slots available.");
                                }
                            }
                        }
                        System.out.print("Choose Slot: ");
                        int m = sc.nextInt();
                        if (m < availableSlots.size()) {
                            System.out.println(searchPatient(patientID).getName()+" vaccinated with " + availableSlots.get(m).vax.getName());
                        }
                    }
                    else if (comm == 3){
                        System.out.println();
                    }
                    else{
                        System.out.println("Invalid command chosen.");
                    }
                }
                else {
                    System.out.println("Person with Unique ID " + patientID + " does not exists.");
                }
            }
            else if (command == 6){
                System.out.print("Enter Hospital ID: ");
                long hosID = sc.nextLong();
                if (hospitalUniqueID.contains(hosID)){
                    hospital hospi = searchHospital(hosID);
                    for (slot s : hospi.slots) {
                        s.printDetails();
                    }
                }
            }
            else if (command == 7){
                System.out.print("Enter Patient ID: ");
                long patientID = sc.nextLong();
                citizen patient = searchPatient(patientID);
                if (patient!=null){
                    patient.getStatus();
                }
                else{
                    System.out.println("Citizen not found. Please register first.");
                }
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
    private final String name;
    private final long doses;
    private final long doseGap;
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
        System.out.println("Gap Between Doses: " + getDoseGap());
    }
}

class hospital{
    private final String name;
    private final long pincode;
    private final long uniqueID;
    ArrayList<slot> slots = new ArrayList<>();
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
        System.out.println("Unique ID: " + getUniqueID());
    }
}

class citizen{
    class vaccineStatus{
        String vStatus;
        vaccine vax;
        long dosesGiven = 0;
        public vaccineStatus(vaccine vax){
            this.vax = vax;
        }
        public void giveDose(long dosesGiven) {
            dosesGiven++;
        }
        public void updateStatus(){
            if (dosesGiven==vax.getDoses()){
                vStatus = "FULLY VACCINATED";
            }
            else{
                vStatus = "PARTIALLY VACCINATED";
            }
        }
    }
    private final String name;
    private final long age;
    private final long uniqueID;
    vaccineStatus status;
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
        System.out.println("Unique ID: " + getUniqueID());
    }
    public void setVaxStatus(vaccine vaxi){
        status = new vaccineStatus(vaxi);
    }

    public void getStatus(){
        if (status != null) {
            System.out.println(status.vStatus);
            System.out.println("Vaccine Given: " + status.vax.getName());
            System.out.println("No. of doses given: " + status.dosesGiven);
            if (status.vStatus.equals("PARTIALLY VACCINATED")) {
                System.out.println("Next Dose due date: " + status.vax.getDoseGap());
            }

        }
        else{
            System.out.println("Citizen REGISTERED");
        }
    }
}

class slot{
    long dayNumber;
    vaccine vax;
    long quantity;
    long hospitalID;
    public slot(long dayNumber, vaccine vax, long quantity, long hospitalID){
        this.dayNumber = dayNumber;
        this.vax = vax;
        this.quantity = quantity;
        this.hospitalID = hospitalID;
    }
    public long getDayNumber() {
        return dayNumber;
    }
    public vaccine getVax(){
        return vax;
    }
    public long getQuantity() {
        return quantity;
    }

    public void display(){
        System.out.print("Slot added by Hospital: " + hospitalID + " for Day: " + dayNumber + ", ");
        System.out.print("Available Quantity: " + quantity + ", of ");
        System.out.println("Vaccine " + vax.getName());
    }
    public void printDetails(){
        System.out.print("Day: " + dayNumber + ", ");
        System.out.print(" Available Qty: " + quantity + ", ");
        System.out.print("Vaccine: " + vax.getName());
    }
}
