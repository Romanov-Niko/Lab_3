package com.kpi.laboratory;

import java.util.*;
import java.lang.reflect.Array;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IterableProcessor {

    public static <T> Iterable<T> filter(Iterable<T> unfiltered, Predicate<? super T> retainIfTrue) {
        List<T> result = new LinkedList<>();
        for (T temp: unfiltered) {
            if (retainIfTrue.test(temp))
                result.add(temp);
        }
        return result;
    }
    public static <F, T> Iterable<T> transform(Iterable<F> fromIterable, Function<? super F, ? extends T> function)
    {
        List<T> result = new LinkedList<>();
        for (F temp: fromIterable)
            result.add(function.apply(temp));
        return result;
    }
}
