package ard.dmytro.dveri.installation_part;

import ard.dmytro.dveri.materials.SurfaceType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AluminiumInstallationDoorPart extends InstallationDoorPart{
    private boolean isLockSystemInstalled;
    private SurfaceType surfaceType;

    public AluminiumInstallationDoorPart() {
    }

    public AluminiumInstallationDoorPart(String doorPartString) {
        List<String> doorPartParameters = Arrays.asList(doorPartString.split(","));
        this.material = doorPartParameters.get(1);
        this.width = Integer.valueOf(doorPartParameters.get(2));
        this.height = Integer.valueOf(doorPartParameters.get(3));
        this.manufacturer = doorPartParameters.get(4);
        this.isLockSystemInstalled = Boolean.parseBoolean(doorPartParameters.get(5));
        this.surfaceType = SurfaceType.valueOf(doorPartParameters.get(6));
        this.warrantyMonth = Integer.valueOf(doorPartParameters.get(7));
        this.price = Double.valueOf(doorPartParameters.get(8));
    }

    @Override
    public String toString() {
        return "AluminiumInstallationDoorPart,"
                + material + ","
                + width + ","
                + height + ","
                + manufacturer + ","
                + isLockSystemInstalled + ","
                + surfaceType + ","
                + warrantyMonth + ","
                + price;
    }

    public void setDefaultValues(){
        isLockSystemInstalled = true;
        surfaceType = SurfaceType.Dotted;
        warrantyMonth = 12;
        price = 22.22;
        material = "Aluminium";
        width = 200;
        height = 300;
        manufacturer = "Bangladesh Door Factory";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AluminiumInstallationDoorPart that = (AluminiumInstallationDoorPart) o;
        return isLockSystemInstalled == that.isLockSystemInstalled && surfaceType == that.surfaceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isLockSystemInstalled, surfaceType);
    }
}
