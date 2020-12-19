package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов И.И.");
        student.setGroup("42");
        student.setAdmissionDate("01.09.2000");
        System.out.println(student.getFio() + " учится в группе " + student.getGroup() + " начиная с " + student.getAdmissionDate());
    }
}
