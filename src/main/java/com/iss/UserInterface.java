package com.iss;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello in Space Station Application!");

        while (true){

            System.out.println("What would you do?");
            System.out.println("1.Calculate the speed of the ISS");
            System.out.println("2.Return a list of upcoming ISS sessions for a specific location");
            System.out.println("3.Show number of people in space ");
            System.out.println("4.Exit application");

            Integer option = newInteger();

            switch (option){
                case 1 -> {
                    System.out.println("You choose 1");
                    break;
                }
                case 2 -> {
                    System.out.println("You choose 2");
                    break;
                }
                case 3 -> {
                    System.out.println("you choose 3");
                    break;
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("You choose wrong number");
            }
        }

    }

    private static int newInteger() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            }catch (Exception e){
                System.out.println("You must enter only numbers");
            }
            }

    }
}