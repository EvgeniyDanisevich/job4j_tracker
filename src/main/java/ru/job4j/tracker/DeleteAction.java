package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter id: "));
        boolean isDeleted = tracker.delete(id);
        if (isDeleted) {
            System.out.println("Item is deleted");
        } else {
            System.out.println("Id is not found");
        }
        return true;
    }
}
