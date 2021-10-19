package com.company;

import java.util.ArrayList;
import java.util.Date;

class LectureSlide implements LectureMaterial{
    private final String topic;
    private final int slideNumber;
    private final String[] contentSlides;
    private final Instructor prof;
    private final ArrayList<LectureMaterial> slidesList = new ArrayList<>();
    private final Date d;
    LectureSlide(String topic, int slideNumber, String[] contentSlides, Instructor prof, Date d) {
        this.topic = topic;
        this.slideNumber = slideNumber;
        this.contentSlides = contentSlides;
        this.prof = prof;
        this.d = d;
    }
    @Override
    public String getTopic() {
        return topic;
    }
    public int getSlideNumber() {
        return slideNumber;
    }
    public String [] getContentSlides() {
        return contentSlides;
    }
    @Override
    public Instructor getProf() {
        return prof;
    }

    public ArrayList<LectureMaterial> getSlidesList() {
        return slidesList;
    }
    @Override
    public Date getD() {
        return d;
    }
    @Override
    public void display() {
        System.out.println("Title: " + getTopic());
        System.out.println("Number of slides: " + getSlideNumber());
        System.out.println("Contents of the slide: ");
        int x = 0;
        for (String i: getContentSlides()) {
            x++;
            System.out.println("Slide " + x + ": " + i);
        }
        System.out.println("Date of upload: " + getD());
        System.out.println("Uploaded by: " + getProf().getName());
    }
}
