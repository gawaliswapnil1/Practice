package com.epam.learning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class GS {

	public static void main(String[] args) {
		
		//sort element by name and group by weight
		List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 30, new BigDecimal("29.99")),
                new Item("orange", 20, new BigDecimal("29.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")));
	
				 Map<String, Integer> collect = items.stream().collect(Collectors.groupingBy(Item::getFruitName,Collectors.summingInt(Item::getWeight)));
				 
				//sort by weight on collected map of name and weight  
				List<Entry<String, Integer>> collect3 = collect.entrySet().stream().sorted((o1,o2)->o1.getValue().compareTo(o2.getValue())).collect(Collectors.toList());
				
				for(Entry<String,Integer> e : collect3){
					
					System.out.println(e.getKey()+""+e.getValue());
					
				}
				//split list based on even and odd
				
				Set<Integer> numbers =Set.of(1, 4, 8, 40, 11, 22, 33, 99);
				Map<Boolean, List<Integer>> collect2 = numbers.stream().collect(Collectors.partitioningBy(p->p%2==0));
				
					System.out.println(collect2.get(true));
					System.out.println(collect2.get(false));
					
					
			//sort map by values in java 8
					//LinkedHashMap<String, Integer> collect4 = collect.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldvalue,newvalue)->oldvalue,LinkedHashMap::new));
					collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
					
				
	}

}
