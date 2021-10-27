package com.company;

public class Player {
    private final String name;
    private long points;
    private int position;

    public Player(String name, int position, int points) {
        this.name = name;
        this.position = position;
        this.points = points;
    }

    protected long getPoints() {
        return points;
    }

    protected void setPoints(long points) {
        this.points = points;
    }

    protected int getPosition() {
        return position;
    }

    protected void setPosition(int position) {
        this.position = position;
    }

    protected void display(Floor floor){
        System.out.println("Player position Floor - " + this.position);
        System.out.println(this.name + " has reached an " + floor.type);
        System.out.println("Total points: " + this.points);
    }

    protected String getName() { return name; }
    protected void start(){
        this.position = 0;
        this.points = 1;
    }
}
