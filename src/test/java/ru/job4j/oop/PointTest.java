package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void when10To20Then1() {
        Point a = new Point(1, 0);
        Point b = new Point(2, 0);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(1, 0.001));
    }

    @Test
    public void when34To39Then5() {
        Point a = new Point(3, 4);
        Point b = new Point(3, 9);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(5, 0.001));
    }

    @Test
    public void when64To34Then3() {
        Point a = new Point(6, 4);
        Point b = new Point(3, 4);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(3, 0.001));
    }
}