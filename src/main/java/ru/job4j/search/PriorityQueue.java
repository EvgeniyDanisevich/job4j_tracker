package ru.job4j.search;

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out)
 * @author СHUCK NORRIS
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Хранение заданий осуществляется в коллекции типа LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает задачу на вход и добавляет ее в очередь.
     * Если встречаются 2 задачи с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        var i = 0;
        for (var current : tasks) {
            if (task.getPriority() < current.getPriority()) {
                break;
            }
            i++;
        }
        tasks.add(i, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */
    public Task take() {
        return this.tasks.poll();
    }
}