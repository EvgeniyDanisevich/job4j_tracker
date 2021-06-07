package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        int index = indexOf(Integer.parseInt(id));
        if (index != -1) {
            item.setId(Integer.parseInt(id));
            items.set(index, item);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(Integer.parseInt(id));
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    @Override
    public Item findById(String id) {
        int index = indexOf(Integer.parseInt(id));
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void close() throws Exception {

    }
}
