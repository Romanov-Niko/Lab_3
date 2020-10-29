package com.kpi.laboratory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IterableProcessorTest {

    private IterableProcessor iterableProcessor;

    @BeforeEach
    public void setUp() {
        iterableProcessor = new IterableProcessor();
    }

    @Test
    void filter_integer() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        List<Integer> testData = new ArrayList<>();
        testData.add(1);
        testData.add(2);
        testData.add(3);
        testData.add(4);
        testData.add(5);

        Iterable<Integer> actual = IterableProcessor.filter(testData, integer -> integer > 2);

        assertEquals(expected, actual);
    }

    @Test
    void filter_string() {
        List<String> expected = new ArrayList<>();
        expected.add("aaa");
        List<String> testData = new ArrayList<>();
        testData.add("aaa");
        testData.add("bbbbbbb");
        testData.add("ccccccccc");

        Iterable<String> actual = IterableProcessor.filter(testData, string -> string.length() < 4);

        assertEquals(expected, actual);
    }

    @Test
    void filter_character() {
        List<Character> expected = new ArrayList<>();
        expected.add('a');
        expected.add('a');
        expected.add('a');
        List<Character> testData = new ArrayList<>();
        testData.add('a');
        testData.add('a');
        testData.add('b');
        testData.add('b');
        testData.add('c');
        testData.add('a');

        Iterable<Character> actual = IterableProcessor.filter(testData, character -> character == 'a');

        assertEquals(expected, actual);
    }

    @Test
    void filter_double() {
        List<Double> expected = new ArrayList<>();
        expected.add(3.3);
        expected.add(4.8);
        List<Double> testData = new ArrayList<>();
        testData.add(3.3);
        testData.add(4.8);
        testData.add(5.1);

        Iterable<Double> actual = IterableProcessor.filter(testData, doublePrecision -> doublePrecision < 5);

        assertEquals(expected, actual);
    }

    @Test
    void transform_integer() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(6);
        List<Integer> testData = new ArrayList<>();
        testData.add(1);
        testData.add(2);
        testData.add(3);

        Iterable<Integer> actual = IterableProcessor.transform(testData, integer -> integer * 2);

        assertEquals(expected, actual);
    }

    @Test
    void transform_string() {
        List<String> expected = new ArrayList<>();
        expected.add("aa");
        expected.add("bbbbbb");
        expected.add("cccccccc");
        List<String> testData = new ArrayList<>();
        testData.add("aaa");
        testData.add("bbbbbbb");
        testData.add("ccccccccc");

        Iterable<String> actual = IterableProcessor.transform(testData, string -> string.substring(1));

        assertEquals(expected, actual);
    }

    @Test
    void transform_character() {
        List<Character> expected = new ArrayList<>();
        expected.add('*');
        expected.add('*');
        expected.add('b');
        expected.add('b');
        expected.add('c');
        expected.add('*');
        List<Character> testData = new ArrayList<>();
        testData.add('a');
        testData.add('a');
        testData.add('b');
        testData.add('b');
        testData.add('c');
        testData.add('a');

        Iterable<Character> actual = IterableProcessor.transform(testData, character -> {
            if (character == 'a') {
                return '*';
            }
            return character;
        });

        assertEquals(expected, actual);
    }

    @Test
    void transform_double() {
        List<Double> expected = new ArrayList<>();
        expected.add(1.7);
        expected.add(2.4);
        expected.add(2.5);
        List<Double> testData = new ArrayList<>();
        testData.add(3.4);
        testData.add(4.8);
        testData.add(5.0);

        Iterable<Double> actual = IterableProcessor.transform(testData, doublePrecision -> doublePrecision / 2);

        assertEquals(expected, actual);
    }
}