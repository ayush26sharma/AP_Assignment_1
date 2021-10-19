package com.company;

import java.util.Date;

class LectureVideo implements LectureMaterial{
    private final String topic;
    private final String name;
    private final Instructor prof;
    private final Date d;
    LectureVideo(String topic, String name, Instructor prof, Date d) {
        this.topic = topic;
        this.name = name;
        this.prof = prof;
        this.d = d;
    }
    @Override
    public String getTopic() {
        return topic;
    }
    public String getName() {
        return name;
    }
    @Override
    public Instructor getProf() {
        return prof;
    }
    @Override
    public Date getD() {
        return d;
    }

    @Override
    public void display() {
        System.out.println("Title of video: " + getTopic());
        System.out.println("Video file: " + getName());
        System.out.println("Date of upload: " + getD());
        System.out.println("Uploaded by: " + getProf().getName());
    }
}
