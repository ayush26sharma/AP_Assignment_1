package com.company;

import java.util.ArrayList;
import java.util.Date;

class Assignment implements Assessment{
    private final String problemStatement;
    private final int maxMarks;
    private final Date date;
    private final Instructor currentInstructor;
    private boolean graded =  false;
    private boolean submitted = false;
    private boolean open = false;
    public Assignment(String problemStatement, int maxMarks, Date date, Instructor currentInstructor) {
        this.problemStatement = problemStatement;
        this.maxMarks = maxMarks;
        this.date = date;
        this.currentInstructor = currentInstructor;
        this.open = true;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isGraded() {
        return graded;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public String getProblemStatement() {
        return problemStatement;
    }
    public int getMaxMarks() {
        return maxMarks;
    }
    public Date getDate() {
        return date;
    }
    @Override
    public boolean isOpen() {
        return open;
    }
    public Instructor getCurrentInstructor() {
        return currentInstructor;
    }
    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }
    @Override
    public void add(Assessment S, ArrayList<Assessment> allAssessments) {
        allAssessments.add(S);
        for (Student i: User.students) {
            i.getPendingAssignment().add(S);
        }
    }
//    public static void view(ArrayList<Assessment> allAssessments) {
//        for (Assessment a : allAssessments) {
//            System.out.print("ID: " + allAssessments.indexOf(a));
//            a.display();
//        }
//    }
    @Override
    public void display() {
        System.out.println(" Assignment: " + getProblemStatement() + " Max Marks: " + getMaxMarks());
    }
    @Override
    public void close(Assessment S) {
        for (Student i: User.students) {
            i.getPendingAssignment().remove(S);
        }
    }
}
