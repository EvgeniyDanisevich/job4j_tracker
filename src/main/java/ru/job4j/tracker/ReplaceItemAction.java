package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
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
            System.out.println("Item is edited");
        } else {
            System.out.println("Id is not found");
        }
        return true;
    }
}
