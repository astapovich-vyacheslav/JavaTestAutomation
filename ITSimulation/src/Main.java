import com.solvd.it.Company;
import com.solvd.it.custom.structures.CustomLinkedList;
import com.solvd.it.economy.reports.ProfitReport;
import com.solvd.it.people.*;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    static void printMenu() {
        log.info("""
                                
                1 - Add client
                2 - Add programmer
                3 - Implement profitable projects
                0 - Exit
                """);
    }

    public static void main(String[] args) {

        //Testing custom linked list
        try {
            CustomLinkedList<Client> list = new CustomLinkedList<>();
            Client cl1 = new Client("name1", sdf.parse("20.11.2002"), 0);
            Client cl2 = new Client("name2", sdf.parse("20.11.2002"), 1);
            Client cl3 = new Client("name3", sdf.parse("20.11.2002"), 2);
            Client cl4 = new Client("name4", sdf.parse("20.11.2002"), 3);
            list.add(cl1);
            list.add(cl2);
            list.add(cl3);
            list.add(cl4);
            list.print();
            list.remove(cl1);
            list.print();
            list.remove(cl4);
            list.print();
            list.add(cl1);
            list.remove(cl3);
            list.print();
            log.info("");
            list.printFlipped();
        } catch (Exception ignored) {
        }

        Company company = new Company();
        while (company.getDirector() == null) {
            //System.out.println("Enter director's info:");
            log.info("Enter director's info");

            company.setDirector(new Director(PersonGenerator.getNewWorkerData()));
        }
        while (company.getManager() == null) {
            //System.out.println("Enter manager's info:");
            log.info("Enter manager's info");
            company.setManager(new Manager(PersonGenerator.getNewWorkerData()));
        }
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
            }
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
                    //System.out.println("Total profit: " + result);
                    log.info("Total profit: " + result);
                    break;
            }
        } while (choice != 0);
    }
}
