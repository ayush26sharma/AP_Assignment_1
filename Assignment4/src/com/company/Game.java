package com.company;

import java.util.*;

public class Game {
    private final Player player;
    private final ArrayList<SoftToys> toysArrayList = new ArrayList<>();;
    private final Calculator<String> calc;
    private static final HashMap<Integer,String> hashmapuh = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    public Game() {
        calc = new  Calculator<>();
        System.out.print("Hit enter to initialize the game");
        sc.nextLine();
        System.out.println("Game is ready");
        this.player = new Player();
        setTiles();
        getHopName();
    }
    public void setTiles(){
        SoftToys sample = new SoftToys("Sample");
        toysArrayList.add(sample);
        for (int i = 1; i < 21; i++) {
            SoftToys toy = new SoftToys("toy"+i);
            toysArrayList.add(toy);
        }
    }
    public void getHopName(){
        hashmapuh.put(1,"First");
        hashmapuh.put(2,"Second");
        hashmapuh.put(3,"Third");
        hashmapuh.put(4,"Fourth");
        hashmapuh.put(5,"Fifth");
    }
    public String randomString(){
        String characters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        Random rand = new Random();
        String str="";
        for(int i = 0; i < 4; i++) {                                                                                  // theek karo
            int index = rand.nextInt(52);
            str+=characters.charAt(index);
        }
        return str;
    }

    public void playGame(){
        for (int i = 1; i < 6; i++) {
            System.out.print("Hit enter for your " + hashmapuh.get(i) + " hop");
            sc.nextLine();
            Random rand = new Random();
            int hopTo = 1 + rand.nextInt(21);
            if (hopTo>20){
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
            }
            else{
                System.out.println("You landed on tile " + hopTo);
                if (hopTo%2==0){
                    SoftToys newtoy = toysArrayList.get(hopTo);
                    System.out.println("You won a "+ newtoy.getName());
                    SoftToys cloneToy = newtoy.clone();
                    player.addToBucket(cloneToy);
                }
                else{
                    System.out.println("Question answer round. Integer or String?");
                    boolean flag = true;
                    while(flag){
                        try{
                            String input = sc.next();
                            if(input.equals("Integer")){
                                flag = false;
//                                int rand1 = 5;
//                                int rand2 = 2;
                                int rand1 = rand.nextInt();
                                int rand2;
                                while(true){
                                    rand2 = rand.nextInt();
                                    if (rand2!=0){
                                        break;
                                    }
                                }
                                System.out.println("Calculate the result of " + rand1 + " divided by " + rand2);
                                boolean flag2 = true;
                                int answer = 0;
                                while(flag2){
                                    try{
                                        Scanner scn = new Scanner(System.in);
                                        answer = scn.nextInt();
                                        flag2 = false;
                                    }
                                    catch (InputMismatchException e){
                                        System.out.println("Invalid Input. Enter an integer");
                                    }
                                }
                                if (calc.calculate(String.valueOf(rand1), String.valueOf(rand2), String.valueOf(answer))){
                                    System.out.println("Correct Answer");
                                    SoftToys newtoy2 = toysArrayList.get(hopTo);
                                    System.out.println("You won a "+ newtoy2.getName());
                                    SoftToys cloneToy = newtoy2.clone();
                                    player.addToBucket(cloneToy);
                                }
                                else{
                                    System.out.println("Incorrect Answer");
                                    System.out.println("You did not win any soft toy");
                                }
                                sc.nextLine();
                            }
                            else if(input.equals("String")){
                                flag = false;
                                String rand1 = randomString();
                                String rand2 = randomString();
                                System.out.println("Calculate the concatenation of strings " + rand1 + " and "+ rand2);
                                String answer = sc.next();
                                if(calc.calculate(String.valueOf(rand1), String.valueOf(rand2), String.valueOf(answer))){
                                    System.out.println("Correct Answer");
                                    SoftToys newtoy3 = toysArrayList.get(hopTo);
                                    System.out.println("You won a "+ newtoy3.getName());
                                    SoftToys cloneToy = newtoy3.clone();
                                    player.addToBucket(cloneToy);
                                }
                                else{
                                    System.out.println("Incorrect Answer");
                                    System.out.println("You did not win any soft toy");
                                }
                                sc.nextLine();
                            }
                            else{
                                throw new Exception1("Invalid input. Please enter either 'Integer' or 'String'");
                            }
                        } catch (Exception1 exception1) {
                            System.out.println("Invalid input. Please enter either 'Integer' or 'String'");
                        }
                    }
                }
            }
        }
        System.out.println("Game over");
        System.out.println("Soft toys won by you are: ");
        player.displayToys();
    }

}
