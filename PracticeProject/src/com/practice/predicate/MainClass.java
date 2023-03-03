package com.practice.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {

    //predicates
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Example 1 not greater than 5
        Predicate<Integer> notGreaterThanFive = x -> x < 5;

        List<Integer> collect = list.stream().filter(notGreaterThanFive).collect(Collectors.toList());
        System.out.println(collect);

        //and condition in predicates

        Predicate<Integer> notLessThan3 = x -> x > 3;

        List<Integer> andFiltered = list.stream().filter(notGreaterThanFive.and(notLessThan3)).collect(Collectors.toList());
        System.out.println(andFiltered);

        // predicate with Negate
        Predicate<String> startWithA = x -> x.startsWith("A");
        List<String> charString = Arrays.asList("A", "AA", "AAA", "B", "BB");
        List<String> notACharList = charString.stream().filter(startWithA.negate()).collect(Collectors.toList());
        System.out.println(notACharList);

        //Bipredicate

        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x == y;

        boolean filter=biPredicate.test(1,2);
        System.out.println(filter);
    }
}


//predicates
/*
    In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean. Usually, it used to apply in a filter for a collection of objects.
    @FunctionalInterface
    public interface Predicate<T> {
      boolean test(T t);
    }

    In Java 8, BiPredicate is a functional interface, which accepts two arguments and returns a boolean, basically this BiPredicate is same with the Predicate, instead, it takes 2 arguments for the test.

    @FunctionalInterface
    public interface BiPredicate<T, U> {
        boolean test(T t, U u);
    }

 */