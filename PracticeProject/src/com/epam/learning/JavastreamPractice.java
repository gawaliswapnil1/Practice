package com.epam.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavastreamPractice {

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		//How many male and female employees are there in the organization?
		Map<String, Long> GenderCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		//How many male and female employees list
		Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(p->p.getGender().contains("Male")));
		
		/*
		 * List<Employee> list = collect.get(true); for(Employee e:list) {
		 * System.out.println(e); }
		 */
		
		// Print the name of all departments in the organization?
		List<String> distDepartment = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		/*
		 * for(String s:distDepartment) { System.out.println(s); }
		 */
		
		//What is the average age of male and female employees?
		
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
			//System.out.println(avgAgeOfMaleAndFemaleEmployees);
			
		//Get the details of highest paid employee in the organization?
			Optional<Employee> maxSalary = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
			
			//System.out.println(maxSalary.get());
			
			
		//Get the names of all employees who have joined after 2015?
			List<Employee> youngEmployee = employeeList.stream().filter(p->p.getYearOfJoining()>2015).collect(Collectors.toList());
			
			//System.out.println(youngEmployee);
			
		//Count the number of employees in each department?
			
			Map<String, Long> deptEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
			
			//System.out.println(deptEmployee);
			
		//What is the average salary of each department?
			Map<String, Double> avgSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
			
			//System.out.println(avgSalaryByDept);
			
		//Get the details of youngest male employee in the product development department?
			
			Optional<Employee> youngEMployee = employeeList.stream().filter(p->p.getDepartment().contains("Product Development")).collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
			
			//System.out.println(youngEMployee.get());
			
		//Who has the most working experience in the organization?
			Optional<Employee> mostExperienced = employeeList.stream().max(Comparator.comparingInt(Employee::getYearOfJoining).reversed());
			
			//System.out.println(mostExperienced.get());
			
		//How many male and female employees are there in the sales and marketing team?
			Map<String, Long> deptEmployeeGenderWise = employeeList.stream().filter(e->e.getDepartment().contains("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
			//System.out.println(deptEmployeeGenderWise);
			
		//What is the average salary of male and female employees?
			Map<String, Double> avgSalaryOfMaleandFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
			//System.out.println(avgSalaryOfMaleandFemale);
	
			//List down the names of all employees in each department?

			Map<String, List<Employee>> deptEmployeeList = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
			//System.out.println(deptEmployeeList);
	
			//What is the average salary and total salary of the whole organization?
			Double avgSalaryOrga = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
			//System.out.println(avgSalaryOrga);
			
			//Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
			Map<Boolean, List<Employee>> youngVsOld = employeeList.stream().collect(Collectors.partitioningBy(p->p.getAge()>25));
			
			System.out.println(youngVsOld.get(true));
			System.out.println(youngVsOld.get(false));
			
			//Who is the oldest employee in the organization? What is his age and which department he belongs to?
			Optional<Employee> max = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
			
			//Map<Long,employee>
			
			 Map<Integer, Employee> collect2 = employeeList.stream().filter(p->p.getName().startsWith("J")).collect(Collectors.toMap(Employee::getId,Employee::getEmployee));
			
			//System.out.println(collect2);
			
			//employeeList.removeIf(null)
		
			//get all employee id list whose salary >1000
			employeeList.stream().filter(p->p.getSalary()>1000).map(p->p.getId()).collect(Collectors.toList());
			//query is from another question set we just use same context to build java8 queries
			
			//calculate the total value of all transactions & COUNT total number of txs
			DoubleSummaryStatistics collect3 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
			
			collect3.getSum();
			collect3.getCount();
			//To group the transactions by the currency of transactions in each city to get the average transaction value for that currency
			Map<String, Map<String, List<Employee>>> collect4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.groupingBy(Employee::getDepartment)));
			System.out.println(collect4);
	}
	

}
