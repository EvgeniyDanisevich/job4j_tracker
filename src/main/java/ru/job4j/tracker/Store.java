package ru.job4j.tracker;

import java.util.List;

public interface Store extends AutoCloseable {

    default void init() {
    }

    Item add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(String id);
}