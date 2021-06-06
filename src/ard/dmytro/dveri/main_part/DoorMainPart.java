package ard.dmytro.dveri.main_part;

import ard.dmytro.dveri.DoorPart;
import ard.dmytro.dveri.materials.SurfaceType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DoorMainPart extends DoorPart {
    private boolean isLockSystemInstalled;
    private SurfaceType surfaceType;
    private String colour;
    private boolean isVarnished;
    private boolean isPainted;

    public DoorMainPart() {
    }

    public DoorMainPart(String doorPartString){
        List<String> doorPartParameters = Arrays.asList(doorPartString.split(","));
        this.material = doorPartParameters.get(1);
        this.width = Integer.valueOf(doorPartParameters.get(2));
        this.height = Integer.valueOf(doorPartParameters.get(3));
        this.manufacturer = doorPartParameters.get(4);
        this.isLockSystemInstalled = Boolean.valueOf(doorPartParameters.get(5));
        this.surfaceType = SurfaceType.valueOf(doorPartParameters.get(6));
        this.colour = doorPartParameters.get(7);
        this.isVarnished = Boolean.parseBoolean(doorPartParameters.get(8));
        this.isPainted = Boolean.parseBoolean(doorPartParameters.get(9));
    }

    @Override
    public String toString() {

        return "DoorMainPart,"
                + material + ","
                + width + ","
                + height + ","
                + manufacturer + ","
                + isLockSystemInstalled + ","
                + surfaceType + ","
                + colour + ","
                + isVarnished + ","
                + isPainted;
    }

    public void setDefaultValues() {
        colour = "Black";
        isVarnished = true;
        isPainted = false;
        isLockSystemInstalled = true;
        surfaceType = SurfaceType.Dotted;
        material = "Aluminium";
        width = 200;
        height = 300;
        manufacturer = "JustDoIt";
    }

    public boolean isLockSystemInstalled() {
        return isLockSystemInstalled;
    }

    public void setLockSystemInstalled(boolean lockSystemInstalled) {
        isLockSystemInstalled = lockSystemInstalled;
    }

    public SurfaceType getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(SurfaceType surfaceType) {
        this.surfaceType = surfaceType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isVarnished() {
        return isVarnished;
    }

    public void setVarnished(boolean varnished) {
        isVarnished = varnished;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoorMainPart that = (DoorMainPart) o;
        return isLockSystemInstalled == that.isLockSystemInstalled && isVarnished == that.isVarnished && isPainted == that.isPainted && surfaceType == that.surfaceType && Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isLockSystemInstalled, surfaceType, colour, isVarnished, isPainted);
    }
}
