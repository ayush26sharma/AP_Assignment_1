package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private static final ArrayList<Floor> allFloors = new ArrayList<>();
    public static ArrayList<Floor> getAllFloors() {
        return allFloors;
    }
    private static final ArrayList<Player> allPlayers = new ArrayList<>();
    public static ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }
    public static Floor findFloor(int level){
        for (Floor floor: allFloors) {
            if (floor.getLevel()==level) return floor;
        }
        return null;
    }
    public static void run() {
        Scanner sc = new Scanner(System.in);
        Floor emptyfloor1 = new EmptyFloor(0, 1);
        Floor emptyfloor2 = new EmptyFloor(1, 1);
        Floor emptyfloor4 = new EmptyFloor(3, 1);
        Floor emptyfloor5 = new EmptyFloor(4, 1);
        Floor emptyfloor6 = new EmptyFloor(6, 1);
        Floor emptyfloor7 = new EmptyFloor(7, 1);
        Floor emptyfloor8 = new EmptyFloor(9, 1);
        Floor emptyfloor9 = new EmptyFloor(10, 1);
        Floor emptyfloor10 = new EmptyFloor(12, 1);
        Floor emptyfloor11 = new EmptyFloor(13, 1);
        Floor cobra = new KingCobra(11, -4, 3);
        Floor ladder = new Ladder(8, 2, 12);
        Floor elevator = new Elevator(2, 4, 10);
        Floor snake = new Snake(5, -2, 1);
        Dice dice = new Dice(2);
        while (true) {
            System.out.println("Welcome to Snake and ladders game");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter 1 to play");
            System.out.println("Enter 2 to view status of all the players");
            System.out.println("Enter 3 to exit");
            System.out.println("--------------------------------------------------");
            int command = sc.nextInt();
            sc.nextLine();
            if (command == 1) {
                System.out.println("Enter the player name and hit enter");
                String a = sc.nextLine();
                Player currentPlayer = new Player(a, -1, 0);
                getAllPlayers().add(currentPlayer);
                System.out.println("The game setup is ready");
                while (true) {
                    System.out.println("--------------------------------------------------");
                    System.out.print("Hit enter to roll the dice");
                    sc.nextLine();
                    dice.roll();
                    System.out.println("Dice gave " + dice.getFaceValue());
                    if (dice.getFaceValue() == 1) {
                        currentPlayer.start();
                        currentPlayer.display(emptyfloor1);
                        break;
                    } else {
                        System.out.println("Game cannot start until you get 1");
                    }
                }
                while (true) {
                    System.out.println("--------------------------------------------------");
                    System.out.print("Hit enter to roll the dice");
                    sc.nextLine();
                    dice.roll();
                    System.out.println("Dice gave " + dice.getFaceValue());
                    if (currentPlayer.getPosition() + dice.getFaceValue() <= 13) {
                        currentPlayer.setPosition(currentPlayer.getPosition() + dice.getFaceValue());
                        int position = currentPlayer.getPosition();
                        if (position == 0) {
                            Floor floor = findFloor(0);
                            assert floor != null;
                            currentPlayer.setPoints(currentPlayer.getPoints() + floor.getPointsRewarded());
                            currentPlayer.display(floor);
                        } else if (position == 1) {
                            Floor floor = findFloor(1);
                            assert floor != null;
                            currentPlayer.setPoints(currentPlayer.getPoints() + floor.getPointsRewarded());
                            currentPlayer.display(floor);
                        } else if (position == 2) {
                            Floor floor = findFloor(2);
                            assert floor != null;
                            int x = currentPlayer.getPoints();
                            currentPlayer.setPoints(x + floor.getPointsRewarded());
                            currentPlayer.display(floor);
                            currentPlayer.setPoints(x);
                            floor.changePoints(currentPlayer);
                            //change points
                            currentPlayer.setPosition(floor.getToLevel);
                            Floor newFloor = findFloor(currentPlayer.getPosition());
                            assert newFloor != null;
                            currentPlayer.setPoints(currentPlayer.getPoints() + newFloor.getPointsRewarded());
                            currentPlayer.display(newFloor);
                        } else if (position == 3) {
                            Floor floor = findFloor(3);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 4) {
                            Floor floor = findFloor(4);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 5) {
                            Floor floor = findFloor(5);
                            assert floor != null;
                            int x = currentPlayer.getPoints();
                            currentPlayer.setPoints(x + floor.getPointsRewarded());
                            currentPlayer.display(floor);
                            currentPlayer.setPoints(x);
                            floor.changePoints(currentPlayer);
                            //change points
                            currentPlayer.setPosition(floor.getToLevel);
                            Floor newFloor = findFloor(currentPlayer.getPosition());
                            assert newFloor != null;
                            currentPlayer.setPoints(currentPlayer.getPoints() + newFloor.getPointsRewarded());
                            currentPlayer.display(newFloor);
                        } else if (position == 6) {
                            Floor floor = findFloor(6);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 7) {
                            Floor floor = findFloor(7);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 8) {
                            Floor floor = findFloor(8);
                            assert floor != null;
                            int x = currentPlayer.getPoints();
                            currentPlayer.setPoints(x + floor.getPointsRewarded());
                            currentPlayer.display(floor);
                            currentPlayer.setPoints(x);
                            floor.changePoints(currentPlayer);
                            //change points
                            currentPlayer.setPosition(floor.getToLevel);
                            Floor newFloor = findFloor(currentPlayer.getPosition());
                            assert newFloor != null;
                            currentPlayer.setPoints(currentPlayer.getPoints() + newFloor.getPointsRewarded());
                            currentPlayer.display(newFloor);
                        } else if (position == 9) {
                            Floor floor = findFloor(9);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 10) {
                            Floor floor = findFloor(10);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 11) {
                            Floor floor = findFloor(11);
                            assert floor != null;
                            int x = currentPlayer.getPoints();
                            currentPlayer.setPoints(x + floor.getPointsRewarded());
                            currentPlayer.display(floor);
                            currentPlayer.setPoints(x);
                            floor.changePoints(currentPlayer);
                            //change points
                            currentPlayer.setPosition(floor.getToLevel);
                            Floor newFloor = findFloor(currentPlayer.getPosition());
                            assert newFloor != null;
                            currentPlayer.setPoints(currentPlayer.getPoints() + newFloor.getPointsRewarded());
                            currentPlayer.display(newFloor);
                        } else if (position == 12) {
                            Floor floor = findFloor(12);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            currentPlayer.display(floor);
                        } else if (position == 13) {
                            Floor floor = findFloor(13);
                            assert floor != null;
                            floor.changePoints(currentPlayer);
                            //currentPlayer.setPoints(currentPlayer.getPoints()+ floor.getPointsRewarded());
                            currentPlayer.display(floor);
                            System.out.println("Game Over");
                            System.out.println(currentPlayer.getName() + " accumulated " + currentPlayer.getPoints() + " points");
                            System.out.println("--------------------------------------------------");
                            break;
                        }
                    } else {
                        System.out.println("Player cannot move");
                    }
                }
            }
            else if (command == 2){
                System.out.println("--------------------------------------------------");
                System.out.println("All the players");
                System.out.println("--------------------------------------------------");
                int x = 0;
                for (Player player: getAllPlayers()) {
                    x++;
                    System.out.print(x + ". ");
                    player.printDetails();
                }
                System.out.println("--------------------------------------------------");
            }
            else if (command == 3){
                break;
            }
            else{
                System.out.println("Please enter a valid command");
            }
        }
    }
}
