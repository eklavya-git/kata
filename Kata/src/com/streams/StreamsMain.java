package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class StreamsMain {

	public static void main(String[] args) {
		Stream<Employee> empStream = createAndReturnEmployeeStream();
		printAllNamesStartingWithSpecificLetter(empStream, "S");
	}
	
	public static Stream <Employee> createAndReturnEmployeeStream(){
		List<Employee> empList = Arrays.asList(
				new Employee ("Rahul", 32, "SSE", 18d)
				,new Employee ("Digvijay", 32, "Manager", 29d)
				,new Employee ("Suhas", 28, "SE", 12d)
				,new Employee ("Debojit", 30, "SSE", 20d)
				);
		return empList == null || empList.isEmpty() ? Stream.empty() : (Stream<Employee>) empList.stream();
	}
	
	public static void printAllNamesStartingWithSpecificLetter(Stream<Employee> emplpyeeStream, String prefix){
		emplpyeeStream
		.map(employee -> employee.getName())
		.filter(name -> name.startsWith(prefix))
		.map(String::toUpperCase)
		.forEach(System.out::println);
	}
}