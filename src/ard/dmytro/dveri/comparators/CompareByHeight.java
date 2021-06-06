package ard.dmytro.dveri.comparators;

import ard.dmytro.dveri.DoorPart;

import java.util.Comparator;

public class CompareByHeight implements Comparator<DoorPart> {
    @Override
    public int compare(DoorPart o1, DoorPart o2) {
        return o1.getHeight() - o2.getHeight();
    }
}
