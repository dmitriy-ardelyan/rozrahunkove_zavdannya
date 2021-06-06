package ard.dmytro.doors_manager;

import ard.dmytro.dveri.DoorPart;
import ard.dmytro.dveri.comparators.CompareByHeight;
import ard.dmytro.dveri.comparators.CompareByManufacturer;
import ard.dmytro.dveri.comparators.CompareByMaterial;
import ard.dmytro.dveri.comparators.CompareByWidth;
import ard.dmytro.dveri.installation_part.AluminiumInstallationDoorPart;
import ard.dmytro.dveri.installation_part.InstallationDoorPart;
import ard.dmytro.dveri.installation_part.WoodenInstallationDoorPart;
import ard.dmytro.dveri.main_part.DoorMainPart;

import java.io.*;
import java.util.*;

public class DoorsManager {
    private List<DoorPart> availableDoorParts;
    private File doorPartsList;

    public DoorsManager() {
        availableDoorParts = new ArrayList<>();
    }

    public List<DoorPart> getAvailableDoorParts() {
        return availableDoorParts;
    }

    public void setAvailableDoorParts(List<DoorPart> availableDoorParts) {
        this.availableDoorParts = availableDoorParts;
    }

    public DoorsManager createFileIfNeeded() throws IOException {
        doorPartsList = new File("./doorPartsList.txt");
        if (!doorPartsList.exists()) {
            doorPartsList.createNewFile();
        }
        return this;
    }

    public List<DoorPart> readData() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("./doorPartsList.txt"));
        String doorPart;
        while ((doorPart = bufferedReader.readLine()) != null) {
            availableDoorParts.add(parseDoorPart(doorPart));
        }
        return availableDoorParts;
    }

    public void writeDoorPartsDataToFile() throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("./doorPartsList.txt"), true);

        for (DoorPart doorPart : availableDoorParts) {
            printWriter.write(doorPart.toString().replace("DoorMainPart", doorPart.getClass().getSimpleName()));
            printWriter.append("\n");
        }
        printWriter.close();
    }

    public void addDoorPart(DoorPart doorPart) {
        availableDoorParts.add(doorPart);
    }

    private DoorPart parseDoorPart(String doorPartString) {
        DoorPart doorPart = null;
        if (doorPartString.contains("DoorMainPart")) {
            doorPart = new DoorMainPart(doorPartString);
        }
        if (doorPartString.contains("WoodenInstallationDoorPart")) {
            doorPart = new WoodenInstallationDoorPart(doorPartString);
        }
        if (doorPartString.contains("AluminiumInstallationDoorPart")) {
            doorPart = new AluminiumInstallationDoorPart(doorPartString);
        }
        return doorPart;
    }

    public DoorsManager setupDefaultDataIfNeeded() throws IOException {
        if (doorPartsList.length() == 0) {
            AluminiumInstallationDoorPart aluminiumInstallationDoorPart = new AluminiumInstallationDoorPart();
            aluminiumInstallationDoorPart.setDefaultValues();
            WoodenInstallationDoorPart woodenInstallationDoorPart = new WoodenInstallationDoorPart();
            woodenInstallationDoorPart.setDefaultValues();
            DoorMainPart doorMainPart = new DoorMainPart();
            doorMainPart.setDefaultValues();

            addDoorPart(aluminiumInstallationDoorPart);
            addDoorPart(woodenInstallationDoorPart);
            addDoorPart(doorMainPart);

            writeDoorPartsDataToFile();
        }

        return this;
    }

    public DoorsManager printData() {
        for (DoorPart doorPart : availableDoorParts) {
            System.out.println(doorPart);
        }

        return null;
    }

    public DoorsManager sort(int sortId, int sortOrder) {

        switch (sortId) {
            case 1: {
                if (sortOrder == 1) {
                    Collections.sort(availableDoorParts, new CompareByMaterial());
                }
                if (sortOrder == 2) {
                    Collections.sort(availableDoorParts, new CompareByMaterial().reversed());
                }
            }
            break;
            case 2: {
                if (sortOrder == 1) {
                    Collections.sort(availableDoorParts, new CompareByWidth());
                }
                if (sortOrder == 2) {
                    Collections.sort(availableDoorParts, new CompareByWidth().reversed());
                }
            }
            break;
            case 3: {
                if (sortOrder == 1) {
                    Collections.sort(availableDoorParts, new CompareByHeight());
                }
                if (sortOrder == 2) {
                    Collections.sort(availableDoorParts, new CompareByHeight().reversed());
                }
            }
            break;
            case 4: {
                if (sortOrder == 1) {
                    Collections.sort(availableDoorParts, new CompareByManufacturer());
                }
                if (sortOrder == 2) {
                    Collections.sort(availableDoorParts, new CompareByManufacturer().reversed());
                }
            }
            break;
            default: {
                System.out.println("Invalid sort parameter");
            }
            break;
        }

        return this;
    }

    public DoorPart getMostExpensiveAluminiumInstallationPart() {
        return availableDoorParts
                .stream()
                .filter(doorPart -> doorPart instanceof InstallationDoorPart)
                .filter(doorPart -> doorPart.getMaterial().equals("Aluminium"))
                .max(new Comparator<DoorPart>() {
                    @Override
                    public int compare(DoorPart o1, DoorPart o2) {
                        double result = ((InstallationDoorPart) o1).getPrice() - ((InstallationDoorPart) o2).getPrice();
                        if (result == 0) return 0;
                        return (result > 0) ? 1 : -1;
                    }
                })
                .get();
    }
}