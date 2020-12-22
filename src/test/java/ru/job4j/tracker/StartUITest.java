package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("First Item"));
        Item secondItem = tracker.add(new Item("Second Item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(new String[] {tracker.findAll()[0].toString(), tracker.findAll()[1].toString()},
                is(new String[] {firstItem.toString(), secondItem.toString()}));
    }

    @Test
    public void whenFindByNameItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "Item";
        Item firstItem = tracker.add(new Item(name));
        Item secondItem = tracker.add(new Item(name));
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(new String[] {tracker.findByName(name)[0].toString(), tracker.findByName(name)[1].toString()},
                is(new String[] {firstItem.toString(), secondItem.toString()}));
    }

    @Test
    public void whenFindByIdItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).toString(), is(item.toString()));
    }
}