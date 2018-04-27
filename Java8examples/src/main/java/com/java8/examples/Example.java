package com.java8.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * @author Nikhil 
 *
 */
public class Example {
	
	
	public static void main(String[] args) {
		
	List<Integer> nums= Arrays.asList(1,2,3,65,33,2,65);
	
	nums.stream()
	.filter(Example::not33)
	.forEach(System.out::println);
	
	Set<Integer> set = new HashSet<Integer>();
	nums.forEach(set::add);
	System.out.println(set);
	
	
}

	private static boolean not33(Integer num) {
		return !num.equals(33);
	}
}
