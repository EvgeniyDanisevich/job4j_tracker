package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student(90, "Ivanov"),
                new Student(80, "Petrov"),
                new Student(70, "Sidorov")
                );
        Map<String, Student> studentMap = studentList.stream()
                .collect(Collectors
                        .toMap(
                                student -> student.getSurname(),
                                student -> student
                        ));
        studentMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
