package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUIMockitoTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(String.valueOf(1));
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Item is edited" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(String.valueOf(1));

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Item is deleted" + ln));
        assertThat(tracker.findById("1"), is(nullValue()));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(String.valueOf(1));

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(item.toString() + ln));
    }

    @Test
    public void whenNotFoundByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(String.valueOf(2));

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Id is not found" + ln));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Item");

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is(item.toString() + ln));
    }

    @Test
    public void whenNotFoundByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Not Item");

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Name not found" + ln));
    }
}
