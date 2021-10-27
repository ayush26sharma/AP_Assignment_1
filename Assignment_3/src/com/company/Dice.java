package com.company;

import java.util.Random;

public class Dice {
    private final int faces;
    private int faceValue;
    private final Random rand = new Random();
    public Dice(int faces) {
        this.faces = faces;
    }
    public void roll() {
        int currentFaceValue = 1 + rand.nextInt(faces);
        setFaceValue(currentFaceValue);
    }
    private void setFaceValue (int value) {
        if (value <= faces)
            faceValue = value;
    }
    public int getFaceValue() {
        return faceValue;
    }
}
