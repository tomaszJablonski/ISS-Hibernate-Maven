package com.iss;

import com.iss.program.locationOfTheISS.ISSController;
import com.iss.program.locationOfTheISS.ISSLocation;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface {
    private final Scanner scanner;

    private final ISSController issController;

    public void runApplication() {
        System.out.println("Hello in Space Station Application!");

        while (true) {

            System.out.println("What would you do?");
            System.out.println("1.Add and save current location of ISS Space Station ");
            System.out.println("2.Return a list of upcoming ISS sessions for a specific location");
            System.out.println("3.Show number of people in space ");
            System.out.println("4.Exit application");

            int option = newInteger();

            switch (option) {
                case 1 -> {
                    System.out.println("You choose 1");
                    getLocation();
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

    private int newInteger() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("You must enter only numbers");
            }
        }
    }

    private void getLocation() {
        String responseBody = issController.getISSLocation(new ISSLocation());
        responseBody = responseBody
                .replaceAll("\\{", "\n\t\\{")
                .replaceAll("}]", "}\n]");

        // GET: http://mojadomena.pl/locations
        System.out.println("Odpowiedź serwera: \n" + responseBody + "\n");
    }
}
