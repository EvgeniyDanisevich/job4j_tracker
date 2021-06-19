package ru.job4j.di;

import org.springframework.stereotype.Component;

@Component
public class StartUI {

    private final Store store;
    private final ConsoleInput consoleInput;

    public StartUI(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

    public void add(String value) {
        store.add(value);
    }

    public void addQuestion(String question) {
        System.out.println("Hello, " + consoleInput.askStr(question));
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}