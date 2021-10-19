package com.company;

import java.util.Date;

class Comment {
    private final User user;
    private final String comm;
    private final Date date;
    public Comment(String comm, User user, Date date){
        this.comm = comm;
        this.user = user;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public User getUser(){
        return user;
    }
    public String getComm(){
        return comm;
    }
    public void display(){
        System.out.println(this.getComm() + " - " + user.getName());
        System.out.println(this.getDate());
    }
}
