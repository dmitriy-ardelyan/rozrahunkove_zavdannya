package ard.dmytro.dveri.comparators;

import ard.dmytro.dveri.DoorPart;

import java.util.Comparator;

public class CompareByWidth implements Comparator<DoorPart> {
    @Override
    public int compare(DoorPart o1, DoorPart o2) {
        return o1.getWidth() - o2.getWidth();
    }
}
