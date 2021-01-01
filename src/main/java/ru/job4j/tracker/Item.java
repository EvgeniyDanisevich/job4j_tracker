package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public class Item implements Comparable<Item>, Comparator<Item> {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();
    private String creation = creationDateFormat();

    public Item(){
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LocalDateTime getCreated() {
        return created;
    }

    public String creationDateFormat() {
        this.created = created;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        return created.format(formatter);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation='" + creation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(name, item.name) &&
                Objects.equals(created, item.created) &&
                Objects.equals(creation, item.creation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, creation);
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.getId());
    }

    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}