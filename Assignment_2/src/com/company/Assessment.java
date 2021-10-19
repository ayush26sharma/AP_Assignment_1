package com.company;

import java.util.ArrayList;

interface Assessment {
    void add(Assessment S, ArrayList<Assessment> allAssessments);
    static void view(ArrayList<Assessment> allAssessments){
        for (Assessment a : allAssessments) {
            System.out.print("ID: " + allAssessments.indexOf(a));
            a.display();
        }
    }
    void display();
    int getMaxMarks();
    void close(Assessment S);
    boolean isOpen();
    void setOpen(boolean open);
    void setGraded(boolean graded);
    void setSubmitted(boolean submitted);
    boolean isGraded();
    boolean isSubmitted();
}
