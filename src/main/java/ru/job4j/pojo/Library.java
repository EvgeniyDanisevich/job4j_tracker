package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Dirty code", 200);
        Book book3 = new Book("Good code", 300);
        Book book4 = new Book("Bad code", 400);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNumberPages() + " страниц.");
        }

        System.out.println();
        books[0] = book4;
        books[3] = book1;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNumberPages() + " страниц.");
        }

        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " " + books[i].getNumberPages() + " страниц.");
                break;
            }
        }
    }
}
