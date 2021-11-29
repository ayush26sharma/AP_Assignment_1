package com.company;

import java.util.ArrayList;

public class Player {
    private final ArrayList<SoftToys> bucket;
    public Player(){
        this.bucket = new ArrayList<>();
    }

    public void addToBucket(SoftToys toy){
        bucket.add(toy);
    }

    public ArrayList<SoftToys> getBucket() {
        return bucket;
    }

    public void displayToys(){
        for (SoftToys toy:this.bucket) {
            System.out.print(toy.getName()+", ");
        }
    }
}
