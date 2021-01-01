package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorIncByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobIncByName().thenComparing(new JobIncByPriority());
        int rsl = cmpNamePriority.compare(new Job("First", 0), new Job("Second", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(new Job("First", 0), new Job("Second", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(new Job("First", 0), new Job("Second", 1));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorIncByName() {
        Comparator<Job> cmpName = new JobIncByName();
        int rsl = cmpName.compare(new Job("First", 0), new Job("Second", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorIncByPriority() {
        Job job = new Job("First", 0);
        int rsl = job.compareTo(new Job("Second", 1));
        assertThat(rsl, lessThan(0));
    }
}