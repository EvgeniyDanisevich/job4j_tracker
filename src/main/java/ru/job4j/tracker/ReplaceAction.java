package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return  "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter an old Item id: "));
        String name = input.askStr("Enter a new Item name:");
        Item item = new Item(name);
        boolean isAdded = tracker.replace(id, item);
        if (isAdded) {
            out.println("Item is edited");
        } else {
            out.println("Id is not found");
        }
        return true;
    }
}
