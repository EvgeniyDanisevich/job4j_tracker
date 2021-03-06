package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(String.valueOf(item.getId()));
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(String.valueOf(id), bugWithDesc);
        assertThat(tracker.findById(String.valueOf(id)).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(String.valueOf(id));
        assertThat(tracker.findById(String.valueOf(id)), is(nullValue()));
    }

    @Test
    public void whenFindName() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("First");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String name = "First";
        List<Item> items = tracker.findByName(name);
        List<Item> itemsControl = new ArrayList<>();
        itemsControl.add(first);
        itemsControl.add(third);
        assertThat(items, is(itemsControl));
    }
}