package com.solvd.it.people;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class PersonGenerator {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    public static Worker getNewWorkerData() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name");
            String name = scanner.nextLine();
            System.out.println("Enter date of birth");
            String date = scanner.nextLine();
            System.out.println("Enter project income");
            int projectIncome = scanner.nextInt();
            return new Worker(name, sdf.parse(date), IdTracker.getId(), projectIncome);
        } catch (Exception e) {
            System.out.println("Incorrect input, failed to create an object");
            return null;
        }
    }

    public static Client getNewClientData() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name");
            String name = scanner.nextLine();
            System.out.println("Enter date of birth");
            String date = scanner.nextLine();
            System.out.println("Enter app's name");
            String appName = scanner.nextLine();
            System.out.println("Enter price");
            int price = scanner.nextInt();
            return new Client(name, sdf.parse(date), IdTracker.getId(), null, appName, price);
        } catch (Exception e) {
            System.out.println("Incorrect input, failed to create an object");
            return null;
        }
    }
}
