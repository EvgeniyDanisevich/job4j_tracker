//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.nullValue;
//import static org.junit.Assert.assertThat;
//
//public class StartUITest {
//
//    @Test
//    public void whenFindAllItem() {
//        Output out = new StubOutput();
//        MemTracker tracker = new SqlTracker();
//        tracker.init();
//        Item firstItem = tracker.add(new Item("First Item"));
//        Item secondItem = tracker.add(new Item("Second Item"));
//        Input in = new StubInput(
//                new String[] {"0", "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindAllAction(out));
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(),
//                is("Menu." + System.lineSeparator()
//                        + "0. === Show all items ====" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator() + firstItem.toString()
//                        + System.lineSeparator() + secondItem.toString() + System.lineSeparator()
//                        + "Menu." + System.lineSeparator() + "0. === Show all items ===="
//                        + System.lineSeparator() + "1. Exit" + System.lineSeparator()
//                ));
//    }
//
//    @Test
//    public void whenFindByNameItem() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        tracker.init();
//        String name = "Item";
//        Item firstItem = tracker.add(new Item(name));
//        Item secondItem = tracker.add(new Item(name));
//        Input in = new StubInput(
//                new String[] {"0", name, "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindByNameAction(out));
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(),
//                is("Menu." + System.lineSeparator() + "0. === Find items by name ===="
//                        + System.lineSeparator() + "1. Exit" + System.lineSeparator()
//                        + firstItem.toString() + System.lineSeparator() + secondItem.toString()
//                        + System.lineSeparator() + "Menu." + System.lineSeparator()
//                        + "0. === Find items by name ====" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//                ));
//    }
//
//    @Test
//    public void whenCreateItem() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Store tracker = new SqlTracker();
//        tracker.init();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new CreateAction(out));
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        tracker.init();
//        Item item = tracker.add(new Item("Replaced item"));
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new ReplaceAction(out));
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(String.valueOf(item.getId())).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        tracker.init();
//        Item item = tracker.add(new Item("Deleted item"));
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(item.getId()), "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new DeleteAction(out));
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(String.valueOf(item.getId())), is(nullValue()));
//    }
//
//    @Test
//    public void whenExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"0"}
//        );
//        Store tracker = new SqlTracker();
//        tracker.init();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator()
//                        + "0. Exit" + System.lineSeparator()
//        ));
//    }
//
//    @Test
//    public void whenFindByIdItem() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        tracker.init();
//        Item item = tracker.add(new Item("Item"));
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(item.getId()), "1"}
//        );
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new FindByIdAction(out));
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator() + "0. === Find item by Id ===="
//                        + System.lineSeparator() + "1. Exit" + System.lineSeparator()
//                        + item.toString() + System.lineSeparator() + "Menu."
//                        + System.lineSeparator() + "0. === Find item by Id ===="
//                        + System.lineSeparator() + "1. Exit" + System.lineSeparator()
//        ));
//    }
//
//    @Test
//    public void whenInvalidExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"10", "0"}
//        );
//        Store tracker = new SqlTracker();
//        tracker.init();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new Exit());
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                String.format(
//                        "Menu.%n"
//                                + "0. Exit%n"
//                                + "Wrong input, you can select: 0 .. 0%n"
//                                + "Menu.%n"
//                                + "0. Exit%n"
//                )
//        ));
//    }
//}