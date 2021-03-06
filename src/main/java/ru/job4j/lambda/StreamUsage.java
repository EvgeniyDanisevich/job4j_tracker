package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
        public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name
                    + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
/*        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<String> names = tasks.stream().map(task -> task.name).collect(Collectors.toList());
        names.forEach(System.out::println);

        long total = tasks.stream().map(task -> task.spent).reduce(0L,Long::sum);
        System.out.println(total);

 */

/*        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, -3, 3, -2, 2, -1, 1);
        List<Integer> onlyPositive = integerList.stream()
                .filter(integer -> integer > 0)
                .collect(Collectors.toList());
        onlyPositive.forEach(System.out::println);
        */

        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}