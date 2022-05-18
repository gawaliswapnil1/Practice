package com.epam.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaExpression {

	public static void main(String[] args) {

		List<LamdaExpression> generateDefaultList = Arrays.asList(new LamdaExpression());
		/*
		 * Optional<Person> findFirst =
		 * generateDefaultList.stream().sorted((e1,e2)->(e1.getNameLength().compareTo(e2
		 * .getNameLength()))).findFirst(); if(findFirst.isPresent()) {
		 * System.out.println(findFirst.get().getName()); }
		 */
		
		List<Person> generateDefaultList2 = Person.generateDefaultList();
		
	generateDefaultList2.parallelStream().forEach(System.out::println);
		
	int[] numbers = {123, 456, 789, 246, 135, 802, 791};

	int sum = Arrays.stream(numbers).reduce(1, (x, y) -> (x + y));
	System.out.println("sum = " + sum);
	
	String a1[]
            = new String[] { "A", "B", "C", "D" };

        // Getting the list view of Array
        List<String> list1 = Arrays.asList(a1);
        
        Integer a2[] = new Integer[] { 10, 20, 30, 40 };
        
        // Getting the list view of Array
        List<Integer> list2 = Arrays.asList(a2);
        List<String> joinedList3  = new ArrayList<>();
        
        
        List<String> concatLists = concatLists();
        System.out.println(concatLists);
        
	}

	private static List<String> concatLists() {
		List<String> list1 = Arrays.asList("a", "b", "c", "d");
		List<String> list2 = Arrays.asList("1", "2", "3", "4");
		return list1.stream().map(x -> x + list2.stream().findAny().get()).collect(Collectors.toList());

		}
	public static void method1() {
		System.out.println("This is my static method");
	}
	

	public  void method2() {
		System.out.println("This is my objective method");
	}

	
	
        
       
	
	
}
