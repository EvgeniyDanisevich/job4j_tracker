package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {
    @Test
    public void addAndFindByIdItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "first");
        hbmTracker.add(item);
        assertEquals(hbmTracker.findById("1"), item);
    }

    @Test
    public void replaceAndFindByIdItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "first");
        hbmTracker.add(item);
        Item item1 = new Item("second");
        hbmTracker.replace("1", item1);
        assertEquals(hbmTracker.findById("1").getName(), item1.getName());
    }

    @Test
    public void addAndDeleteItemAndFindAllAndFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item(1, "first");
        Item item2 = new Item(2, "second");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        hbmTracker.delete("2");
        assertEquals(hbmTracker.findAll(), List.of(item1));
        assertEquals(hbmTracker.findByName("first"), List.of(item1));
    }
}