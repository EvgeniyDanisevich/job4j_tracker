package ru.job4j.pojo;

public class Book {
    private String name;
    private int numberPages;

    public Book(String name, int numberPages) {
        this.name = name;
        this.numberPages = numberPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }
}
