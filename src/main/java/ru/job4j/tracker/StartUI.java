package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i].toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int id = Integer.valueOf(input.askInt("Enter an old Item id: "));
                String name = input.askStr("Enter a new Item name:");
                Item item = new Item(name);
                boolean isAdded = tracker.replace(id, item);
                if (isAdded) {
                    System.out.println("Item is edited");
                } else {
                    System.out.println("Id is not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int id = Integer.valueOf(input.askInt("Enter id: "));
                boolean isDeleted = tracker.delete(id);
                if (isDeleted) {
                    System.out.println("Item is deleted");
                } else {
                    System.out.println("Id is not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                int id = Integer.valueOf(input.askInt("Enter id: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Id is not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i].toString());
                    }
                } else {
                    System.out.println("Name not found");
                }
            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}