package org.example;

public class Assortment {
    String name;
    int ram;
    int hdd;
    String os;
    String color;

    public Assortment(String name, int ram, int hdd, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ").append(ram).append("Gb").append(" ").append(hdd).append("Gb").append(" ")
                .append(os).append(" ").append(color);
        return builder.toString();
    }


}
