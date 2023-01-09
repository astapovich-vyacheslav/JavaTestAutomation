package com.solvd.it;

import com.solvd.it.people.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    public static final Logger log = LogManager.getLogger(Main.class);

    static void printMenu() {
        log.info(" 1 - Add client \n2 - Add programmer \n3 - Implement profitable projects \n0 - Exit ");
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Company company = new Company();
        
//        while (company.getDirector() == null) {
//            //System.out.println("Enter director's info:");
//            log.info("Enter director's info");
//
//            company.setDirector(new Director(PersonGenerator.getNewWorkerData()));
//        }
//        while (company.getManager() == null) {
//            //System.out.println("Enter manager's info:");
//            log.info("Enter manager's info");
//            company.setManager(new Manager(PersonGenerator.getNewWorkerData()));
//        }
        company.setDirector(new Director("dir", IdTracker.getId(), 300));
        company.setManager(new Manager("man", IdTracker.getId(), 200));
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            try {
                choice = scanner.nextByte();
            } catch (Exception ignored) {
            }
            switch (choice) {
                case 1 -> {
                    Client client = PersonGenerator.getNewClientData();
                    company.addClient(client);
                }
                case 2 -> company.addProgrammer(new Programmer(PersonGenerator.getNewWorkerData()));
                case 3 -> {
                    int result = company.completeWork();
                    //System.out.println("Total profit: " + result);
                    log.info("Total profit: " + result);
                }
            }
        } while (choice != 0);
    }

}
