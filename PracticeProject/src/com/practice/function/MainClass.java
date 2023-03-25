package com.practice.function;

import java.util.function.Function;

public class MainClass {
    public static void main(String[] args) {
        Function<String, Integer> func = x -> x.length();
        Integer length = func.apply("Swapnil");
        System.out.println(length);

        Function<Integer, Integer> func2 = x -> x + 1;
        System.out.println(func2.apply(10));


    }
}
/*

In Java 8, Function is a functional interface; it takes an argument (object of type T) and returns an object (object of type R). The argument and output can be a different type.
@FunctionalInterface
public interface Function<T, R> {

      R apply(T t);

}
 */