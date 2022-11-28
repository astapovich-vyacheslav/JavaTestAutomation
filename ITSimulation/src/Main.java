import com.solvd.it.Company;
import com.solvd.it.economy.reports.ProfitReport;
import com.solvd.it.people.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    static void printMenu() {
        System.out.println("""
                1 - Add client
                2 - Add programmer
                3 - Implement profitable projects
                0 - Exit
                """);
    }

    public static void main(String[] args) {
//        Programmer pr1;
//        Programmer pr2;
//        Programmer pr3;
//        Director dir;
//        Manager mngr;
//        Client client;
//        Client client2;
//        ArrayList<Worker> workers = new ArrayList<>();
//        try {
//            Date date = new Date();
//            pr1 = new Programmer("A", sdf.parse("20.11.2002"), IdTracker.getId(), 100, "Java");
//            pr2 = new Programmer("B", sdf.parse("21.12.2001"), IdTracker.getId(), 200, "C#");
//            pr3 = new Programmer("C", sdf.parse("02.05.1999"), IdTracker.getId(), 300, "PHP");
//            mngr = new Manager("M", sdf.parse("30.01.1989"), IdTracker.getId(), 350, 950, null);
//            dir = new Director("Dir", sdf.parse("20.11.2002"), IdTracker.getId(), 0, null);
//            client = new Client("Cl", sdf.parse("20.11.2002"), IdTracker.getId(),
//                    null, "project1", 1500);
//            client2 = new Client("Cl2", sdf.parse("20.11.2002"), IdTracker.getId(),
//                    null, "NewApp", 1000);
//            workers.add(pr1);
//            workers.add(pr2);
//            workers.add(pr3);
//            workers.add(mngr);
//            workers.add(dir);
//        } catch (ParseException e) {
//            return;
//        }
//        mngr.addClient(client);
//        ProfitReport report1 = mngr.generateProfitReport(client);
//        System.out.println(report1.toString());
//        dir.addProfitReport(report1);
//        System.out.println("Director's profit - " + dir.getTotalIncome());
//        for (Worker worker :
//                workers) {
//            System.out.println("Name: " + worker.getName() + "    id: " + worker.getId());
//        }
//        mngr.addClient(client2);
//        ProfitReport report2 = mngr.generateProfitReport(client2);
//        System.out.println(report2.toString());
//        dir.addProfitReport(report2);
//        System.out.println("Director's profit - " + dir.getTotalIncome());

        Company company = new Company();
        while (company.getDirector() == null) {
            System.out.println("Enter director's info:");
            company.setDirector(new Director(PersonGenerator.getNewWorkerData()));
        }
        while (company.getManager() == null) {
            System.out.println("Enter manager's info:");
            company.setManager(new Manager(PersonGenerator.getNewWorkerData()));
        }
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    Client client = PersonGenerator.getNewClientData();
                    company.addClient(client);
                    break;
                case 2:
                    company.addProgrammer(new Programmer(PersonGenerator.getNewWorkerData()));
                    break;
                case 3:
                    int result = company.completeWork();
                    System.out.println("Total profit: " + result);
            }
        } while (choice != 0);
    }
}

/* TODO:
 * Object randomization
 */