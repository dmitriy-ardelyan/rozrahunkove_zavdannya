package ard.dmytro.dveri.comparators;

import ard.dmytro.dveri.DoorPart;

import java.util.Comparator;

public class CompareByManufacturer implements Comparator<DoorPart> {
    @Override
    public int compare(DoorPart o1, DoorPart o2) {
        return o1.getManufacturer().compareTo(o2.getManufacturer());
    }
}
