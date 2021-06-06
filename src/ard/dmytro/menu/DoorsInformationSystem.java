package ard.dmytro.menu;

import ard.dmytro.doors_manager.DoorsManager;

import java.io.IOException;
import java.util.Scanner;

public class DoorsInformationSystem {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to doors information system");
        DoorsManager doorsManager = new DoorsManager();
        doorsManager
                .createFileIfNeeded()
                .setupDefaultDataIfNeeded()
                .readData();

        while (true) {
            printMenu();
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            switch (input) {
                case "l":
                case "L": {
                    System.out.println("-------------------------------------");
                    System.out.println("OUTPUT");
                    System.out.println("-------------------------------------");
                    doorsManager.printData();
                }
                break;
                case "f":
                case "F": {
                    doorsManager.getMostExpensiveAluminiumInstallationPart().print();
                }
                break;
                case "s":
                case "S": {
                    System.out.println("Sort by: ");
                    System.out.println("1 Material; 2 Width; 3 Height; 4 Manufacturer");
                    int sortId = sc.nextInt();
                    System.out.println("Order ? 1 Ascending; 2 Descending");
                    int sortOrder = sc.nextInt();
                    doorsManager.sort(sortId, sortOrder);
                    System.out.println("Sort done");
                }
                break;
                case "x":
                case "X": {
                    return;
                }
                default: {
                    System.out.println("Invalid Input");
                    continue;
                }
            }

        }

    }

    public static void printMenu() {
        System.out.println("-------------------------------------");
        System.out.println("DOORS INFO SYSTEM MENU");
        System.out.println("-------------------------------------");
        System.out.println("Show available door parts - L");
        System.out.println("Exit system - X");
        System.out.println("Sort entries - S");
        System.out.println("Find most expensive aluminium door installation part - F");
        System.out.println("-------------------------------------");
    }
}
