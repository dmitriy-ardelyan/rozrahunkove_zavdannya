package ard.dmytro.dveri;

import java.util.Objects;

public class DoorPart implements Comparable{
    protected String material;
    protected int width;
    protected int height;
    protected String manufacturer;

    public DoorPart() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorPart doorPart = (DoorPart) o;
        return width == doorPart.width && height == doorPart.height && Objects.equals(material, doorPart.material) && Objects.equals(manufacturer, doorPart.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, width, height, manufacturer);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public void print(){
        System.out.println(this.toString());
    }
}
