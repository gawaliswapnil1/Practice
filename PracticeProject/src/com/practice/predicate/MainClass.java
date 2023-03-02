package com.practice.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {

    //predicates
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Predicate<Integer> notGreaterThanFive = x -> x < 5;

        List<Integer> collect = list.stream().filter(notGreaterThanFive).collect(Collectors.toList());
        System.out.println(collect);

    }
}


//predicates
/*
    In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean. Usually, it used to apply in a filter for a collection of objects.
    @FunctionalInterface
    public interface Predicate<T> {
      boolean test(T t);
    }
 */