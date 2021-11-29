package com.company;

public class SoftToys implements Cloneable{
    private String name;

    public SoftToys(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public SoftToys clone(){
        try{
            SoftToys newToy = (SoftToys) super.clone();
            newToy.setName(this.name);
            return newToy;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
