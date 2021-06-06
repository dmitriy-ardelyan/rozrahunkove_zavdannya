package ard.dmytro.dveri.installation_part;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WoodenInstallationDoorPart extends InstallationDoorPart {
    private String colour;
    private boolean isVarnished;
    private boolean isPainted;

    public WoodenInstallationDoorPart() {
    }

    public WoodenInstallationDoorPart(String doorPartString) {
        List<String> doorPartParameters = Arrays.asList(doorPartString.split(","));
        this.material = doorPartParameters.get(1);
        this.width = Integer.valueOf(doorPartParameters.get(2));
        this.height = Integer.valueOf(doorPartParameters.get(3));
        this.manufacturer = doorPartParameters.get(4);
        this.warrantyMonth = Integer.valueOf(doorPartParameters.get(5));
        this.price = Double.valueOf(doorPartParameters.get(6));
        this.colour = doorPartParameters.get(7);
        this.isVarnished = Boolean.parseBoolean(doorPartParameters.get(8));
        this.isPainted = Boolean.parseBoolean(doorPartParameters.get(9));
    }

    @Override
    public String toString() {
        return "WoodenInstallationDoorPart,"
                + material + ","
                + width + ","
                + height + ","
                + manufacturer + ","
                + warrantyMonth + ","
                + price + ","
                + colour + ","
                + isVarnished + ","
                + isPainted;
    }

    public void setDefaultValues() {
        colour = "Black";
        isVarnished = true;
        isPainted = false;
        warrantyMonth = 12;
        price = 22.22;
        material = "Wooden";
        width = 200;
        height = 300;
        manufacturer = "NewDeliMegaDoors";
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
        WoodenInstallationDoorPart that = (WoodenInstallationDoorPart) o;
        return isVarnished == that.isVarnished && isPainted == that.isPainted && Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), colour, isVarnished, isPainted);
    }
}
