package com.company;

import java.util.ArrayList;

class Student implements User{
    private final ArrayList<Assessment> pendingAssignment = new ArrayList<>();
    private final ArrayList<Assessment> pendingQuizzes = new ArrayList<>();
    private final ArrayList<Submission> submittedAssignment = new ArrayList<>();
    private final ArrayList<Submission> SubmittedQuizzes = new ArrayList<>();
    private final String name;
    public Student(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static void autoGenerate(){
        Student S0 = new Student("S0");
        Student S1 = new Student("S1");
        Student S2 = new Student("S2");
        students.add(S0);
        students.add(S1);
        students.add(S2);
    }
    public static void displayMenu(){
        System.out.println("STUDENT MENU");
        System.out.println("""
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout""");
    }
    public static void displayList(){
        for (Student i: students) {
            System.out.println(students.indexOf(i) + " - " + i.getName());
        }
    }
    public ArrayList<Assessment> getPendingAssignment() {
        return pendingAssignment;
    }
    public ArrayList<Assessment> getPendingQuizzes() {
        return pendingQuizzes;
    }

    public ArrayList<Submission> getSubmittedAssignment() {
        return submittedAssignment;
    }

    public ArrayList<Submission> getSubmittedQuizzes() {
        return SubmittedQuizzes;
    }
}
