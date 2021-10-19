package com.company;

import java.util.ArrayList;
import java.util.Date;

class Quiz implements Assessment{
    private final String question;
    private final Date d;
    private final int maxMarks = 1;
    private final Instructor currentInstructor;
    private boolean open = false;
    private boolean graded = false;
    private boolean submitted = false;

    public Quiz(String question, int maxMarks, Date d, Instructor currentInstructor) {
        this.question = question;
        this.d = d;
        this.currentInstructor = currentInstructor;
        this.open = true;
    }
    @Override
    public int getMaxMarks() {
        return maxMarks;
    }
    @Override
    public boolean isOpen() {
        return open;
    }
    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }
    public String getQuestion() {
        return question;
    }
    public Date getD() {
        return d;
    }
    public Instructor getCurrentInstructor() {
        return currentInstructor;
    }
    @Override
    public void add(Assessment S, ArrayList<Assessment> allAssessments) {
        allAssessments.add(S);
        for (Student i: User.students) {
            i.getPendingQuizzes().add(S);

        }

    }
    @Override
    public void setGraded(boolean graded) {
        this.graded = graded;
    }
    @Override
    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
    @Override
    public boolean isGraded() {
        return graded;
    }
    @Override
    public boolean isSubmitted() {
        return submitted;
    }
//    @Override
//    public void view(ArrayList<Assessment> allAssessments) {
//        for (Assessment a : allAssessments) {
//            System.out.print("ID: " + allAssessments.indexOf(a));
//            a.display();
//        }
//    }
    @Override
    public void display() {
        System.out.println(" Question: " + getQuestion());
    }
    @Override
    public void close(Assessment S) {
        for (Student i: User.students) {
            i.getPendingQuizzes().remove(S);
        }
    }
}
