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