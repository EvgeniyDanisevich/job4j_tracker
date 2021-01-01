package ru.job4j.oop;

/** Такое приведение типов
 *  является повышающим
 */

public class College {
    private Freshman freshman = new Freshman();
    private Student student = freshman;
    private Object ob = freshman;

    public Freshman getFreshman() {
        return freshman;
    }

    public void setFreshman(Freshman freshman) {
        this.freshman = freshman;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Object getOb() {
        return ob;
    }

    public void setOb(Object ob) {
        this.ob = ob;
    }
}
