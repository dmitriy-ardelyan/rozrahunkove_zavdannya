package ard.dmytro.dveri.installation_part;

import ard.dmytro.dveri.DoorPart;

import java.util.Objects;

public class InstallationDoorPart extends DoorPart {
    protected int warrantyMonth;

    public InstallationDoorPart() {
    }

    public int getWarrantyMonth() {
        return warrantyMonth;
    }

    public void setWarrantyMonth(int warrantyMonth) {
        this.warrantyMonth = warrantyMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InstallationDoorPart that = (InstallationDoorPart) o;
        return warrantyMonth == that.warrantyMonth && Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyMonth, price);
    }
}
