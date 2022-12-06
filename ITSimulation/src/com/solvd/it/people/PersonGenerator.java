package com.solvd.it.people;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class PersonGenerator {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    public static Worker getNewWorkerData() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name");
            String name = scanner.nextLine();
            if (Objects.equals(name, "")) {
                throw new EEmptyName();
            }

            System.out.println("Enter date of birth");
            String date = scanner.nextLine();

            System.out.println("Enter project income");
            int projectIncome = scanner.nextInt();
            if (projectIncome <= 0)
                throw new ENegativeSalary();

            return new Worker(name, sdf.parse(date), IdTracker.getId(), projectIncome);
        } catch (ENegativeSalary e) {
            System.out.println("Worker can't have non-positive salary");
            return null;
        } catch (EEmptyName e) {
            System.out.println("Name can't be an empty string");
            return null;
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
            if (Objects.equals(name, "")) {
                throw new EEmptyName();
            }
            System.out.println("Enter date of birth");
            String date = scanner.nextLine();
            System.out.println("Enter app's name");
            String appName = scanner.nextLine();
            System.out.println("Enter price");
            int price = scanner.nextInt();
            if (price <= 0) {
                throw new ENegativePrice();
            }
            return new Client(name, sdf.parse(date), IdTracker.getId(), null, appName, price);
        } catch (ENegativePrice e) {
            System.out.println("Project's price has to be greater than zero");
            return null;
        } catch (EEmptyName e) {
            System.out.println("Name can't be an empty string");
            return null;
        } catch (Exception e) {
            System.out.println("Incorrect input, failed to create an object");
            return null;
        }
    }

    private static class ENegativeSalary extends Exception {
    }

    private static class ENegativePrice extends Exception {
    }

    private static class EEmptyName extends Exception {
    }
}
