/*
CS.11.03-Lab 3.1
Author: Katie Fu
Date: Sept 27 2023
 */

import java.util.*;
public class TextBasedGame {

    public static void main(String[] args) {
        // calling main page of program, storing user's input
        String instructionsResult = instructions();
        // if user wants to continue the game
        if(instructionsResult.equals("NEXT")){
            // calls door method
            String doorResult = door();
            // if user chooses red room
            if(doorResult.equals("red")){
                int redResult = redRoom();
                if(redResult % 2 == 0){
                    // if user chooses the right box, display winning message
                    boxWin1();
                }else{
                    int boxAns = chooseBox();
                    if(boxAns >= 2 && boxAns <= 5){
                        // if user chooses the right two numbers, display winning message
                        boxWin2();
                    }else{
                        // user chose the wrong numbers, display losing message
                        boxLose();
                    }
                }
            }
            // if user chooses blue room
            else if(doorResult.equals("blue")){
                double fit = blueRoom();
                if(fit >= 50 && fit <= 150){
                    // if user fits into the hole, display winning message
                    blueWin();
                }else{
                    // if user cannot fit into the hole, display losing message
                    blueLose();
                }
            }
            // if user chooses green room
            else if(doorResult.equals("green")){
                // user chose the wrong room, display losing message
                doorLose();
            }
            // if user chooses yellow room
            else if(doorResult.equals("yellow")){
                // user chose the wrong room, display losing message
                doorLose();
            }
        }else{
            // user doesn't want to continue game
            System.out.println("Oh no! You're not ready to take on the challenge! Game over");
        }
    }

    // main page instructions
    public static String instructions(){
        Scanner scan = new Scanner(System.in);
        System.out.println("You're trapped in an abandoned house in the middle of Lantau Island, " +
                "without any tools or support to help you get out. \nYour phone is dead, and the front door is locked, " +
                "so the only way you can escape is by finding a way to exit.\n");
        System.out.println("Enter \"NEXT\" to take on the challenge");
        String userInput = scan.nextLine();
        return userInput;
    }

    // user chooses which room to enter
    public static String door() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Great!\nIn the first room, there are four doors, which are red, green, yellow, and blue respectively." +
                "\nWhich one would you like to enter?");
        String doorInput = scan.nextLine();
        while(true){
            if (doorInput.equals("red") || doorInput.equals("blue") || doorInput.equals("yellow") || doorInput.equals("green")) {
                return doorInput;
            }
            System.out.println("Please enter again");
            doorInput = scan.nextLine();
        }
    }

    // in the red room, user chooses which box to open
    public static int redRoom(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Great! Once you enter the red room, you can see 5 boxes on the table.");
        System.out.println("Which box would you like to open?");
        int redResult = scan.nextInt();
        while(true){
            if(redResult >= 1 && redResult <= 5){
                return redResult;
            }
            System.out.println("Please enter again");
            redResult = scan.nextInt();
        }
    }

    // in the blue room, user checks whether they can fit inside the hole
    public static double blueRoom(){
        Scanner scan = new Scanner(System.in);
        System.out.println("The blue room contains a small hole that lets you crawl out and escape out of the house.");
        System.out.println("Enter your height and weight to determine whether you can fit inside the hole");
        double height = scan.nextDouble();
        double weight = scan.nextDouble();
        return height - weight;
    }

    // losing message for chosing the wrong rooms
    public static void doorLose(){
        System.out.println("Oh no! The room you chose is filled with zombies who want to eat you alive!");
        System.out.println("Game over...");
    }

    // user chooses 2 numbers after opening a specific box in the red room
    public static int chooseBox(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inside the box contains instructions to choose two numbers between 1 and 10");
        int a = scan.nextInt();
        int b = scan.nextInt();
        while(a<1 || a>10 || b<1 || b>10){
            System.out.println("Please enter again");
            a = scan.nextInt();
            b = scan.nextInt();
        }
        return (a*b)/5;
    }

    // user chose the right room and box
    public static void boxWin1() {
        System.out.println("The box contains a key to the front door that lets you escape!");
        System.out.println("Good job, you've won!");
    }

    // uer chooses the right numbers in a specific box in the red room
    public static void boxWin2(){
        System.out.println("Congrats! You have chosen the right numbers, and the main door has opened automatically.");
    }

    // user chooses the wrong numbers in the red room after opening a box
    public static void boxLose(){
        System.out.println("Oh no! You have chosen the wrong numbers! The main door breaks and you're unable to escape now.\nGame over");
    }

    // user can fit inside the hole in the blue room
    public static void blueWin(){
        System.out.println("Good job! You can successfully fit inside the hole. Congrats on escaping");
    }

    // user cannot fit inside the hole in the blue room
    public static void blueLose(){
        System.out.println("Oh no! You're unable to fit inside and escape!");
        System.out.println("Game over...");
    }
}
