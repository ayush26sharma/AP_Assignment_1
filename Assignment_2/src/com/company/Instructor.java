package com.company;

class Instructor implements User {
    private final String name;
    public Instructor(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static void autoGenerate(){
        Instructor I0 = new Instructor("I0");
        Instructor I1 = new Instructor("I1");
        professors.add(I0);
        professors.add(I1);
    }
    public static void displayMenu(){
        System.out.println("INSTRUCTOR MENU");
        System.out.println("""
                1. Add class material
                2. Add assessments
                3. View lecture materials
                4. View assessments
                5. Grade assessments
                6. Close assessment
                7. View comments
                8. Add comments
                9. Logout""");
    }
    public static void displayList(){
        for (Instructor i: professors) {
            System.out.println(professors.indexOf(i) + " - " + i.getName());
        }
    }

}
