package com.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Nikhil
 *
 */
public class MapperExample {

	public static void main(String[] args) {
		List <String> names=Arrays.asList("Mohan","Sagar","Rony","Jockey","Roger");
		System.out.println("Mapped data Print style");
		names.stream()
				.filter(MapperExample::notJockey)
				.map(name->new User(name))
				.forEach(user->System.out.println(user));
		
		System.out.println("Mapped data Collect style");
		List<User> userlist=names.stream()
			.filter(name->!name.equals("Jockey"))
		//	.map(User::new)
		//	.map(name->new User(name))
			.map(new Function<String,User>() {public User apply(String name){
				
				return new User(name);
			}
			})
			.collect(Collectors.toList());
		System.out.println(userlist);
		
		System.out.println("Mapped to int");
		int userCount = (int)userlist.stream()
			.mapToInt(user->user.getAge())
			.count();
		System.out.println(userCount);

	}
	private static boolean notJockey(String name) {
		return !name.equals("Jockey");
	}
	static class User{
		private String name;
		private Integer age=25;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public User(String name) {
			this.name = name;
			
		}
		@Override
		public String toString() {
			return "Name:"+name+",Age"+age;
		}
		
		
	}
	

}
