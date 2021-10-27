package com.company;

public class Player {
    private final String name;
    private int points;
    private int position;

    public Player(String name, int position, int points) {
        this.name = name;
        this.position = position;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void display(Floor floor){
        System.out.println("Player position Floor - " + this.position);
        System.out.println(this.name + " has reached an " + floor.type);
        System.out.println("Total points: " + this.points);
    }

    public String getName() { return name; }
    public void start(){
        this.position = 0;
        this.points = 1;
    }
    public void printDetails(){
        System.out.println("Name: " + getName() + " , Points Earned: " + getPoints());
    }
}
