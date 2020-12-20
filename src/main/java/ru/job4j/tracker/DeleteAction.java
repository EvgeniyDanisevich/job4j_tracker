package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter id: "));
        boolean isDeleted = tracker.delete(id);
        if (isDeleted) {
            out.println("Item is deleted");
        } else {
            out.println("Id is not found");
        }
        return true;
    }
}
