package com.company;

import java.util.ArrayList;

class Submission {
    static ArrayList<Submission> submissions = new ArrayList<>();
    private final Assessment s;
    private final Student stud;
    private final String name;
    private boolean graded = false;
    private int grade = 0;
    private Instructor gradedBy;

    public static ArrayList<Submission> getSubmissions() {
        return submissions;
    }

    public Instructor getGradedBy() {
        return gradedBy;
    }

    public void setGradedBy(Instructor gradedBy) {
        this.gradedBy = gradedBy;
    }
    public Submission(Assessment s, Student stud, String name) {
        this.s = s;
        this.stud = stud;
        this.name = name;
    }

    public Assessment getS() {
        return s;
    }

    public Student getStud() {
        return stud;
    }

    public String getName() {
        return name;
    }

    public boolean isGraded() {
        return graded;
    }

    public int getGrade() {
        return grade;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
