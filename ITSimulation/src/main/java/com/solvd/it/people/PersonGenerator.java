package com.solvd.it.people;

import com.solvd.it.custom.exceptions.*;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class PersonGenerator {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    private static final Logger log = LogManager.getLogger(PersonGenerator.class);

    public static Worker getNewWorkerData() {
        try {
            Scanner scanner = new Scanner(System.in);
            log.info("Enter name");
            String name = scanner.nextLine();
            if (Objects.equals(name, "")) {
                throw new EEmptyName();
            }

            log.info("Enter date of birth");
            String date = scanner.nextLine();

            log.info("Enter project income");
            int projectIncome = scanner.nextInt();
            if (projectIncome <= 0)
                throw new ENegativeSalary();

            return new Worker(name, sdf.parse(date), IdTracker.getId(), projectIncome);
        } catch (ENegativeSalary e) {
            log.info("Worker can't have non-positive salary");
            return null;
        } catch (EEmptyName e) {
            log.info("Name can't be an empty string");
            return null;
        } catch (Exception e) {
            log.info("Incorrect input, failed to create an object");
            return null;
        }
    }

    public static Client getNewClientData() {
        try {
            Scanner scanner = new Scanner(System.in);
            log.info("Enter name");
            String name = scanner.nextLine();
            if (Objects.equals(name, "")) {
                throw new EEmptyName();
            }
            log.info("Enter date of birth");
            String date = scanner.nextLine();
            log.info("Enter app's name");
            String appName = scanner.nextLine();
            log.info("Enter price");
            int price = scanner.nextInt();
            if (price <= 0) {
                throw new ENegativePrice();
            }
            return new Client(name, sdf.parse(date), IdTracker.getId(), null, appName, price);
        } catch (ENegativePrice e) {
            log.info("Project's price has to be greater than zero");
            return null;
        } catch (EEmptyName e) {
            log.info("Name can't be an empty string");
            return null;
        } catch (Exception e) {
            log.info("Incorrect input, failed to create an object");
            return null;
        }
    }


}
