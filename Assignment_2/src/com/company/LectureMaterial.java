package com.company;

import java.util.ArrayList;
import java.util.Date;

interface LectureMaterial {

    static void viewLectureMaterial(ArrayList<LectureMaterial> videos, ArrayList<LectureMaterial> slides) {
        System.out.println("LECTURE VIDEOS: ");
        for (LectureMaterial i: videos) {
            i.display();
        }
        System.out.println("LECTURE SLIDES: ");
        for (LectureMaterial i: slides) {
            i.display();
        }
    }
    void display();
    String getTopic();
    Instructor getProf();
    Date getD();
}
