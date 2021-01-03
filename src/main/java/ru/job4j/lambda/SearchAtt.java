package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> attachmentPredicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, attachmentPredicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> attachmentPredicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, attachmentPredicate);
    }

    public static List<Attachment> filter(List<Attachment> list,
                                          Predicate<Attachment> attachmentPredicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (attachmentPredicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}