package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	private static List<Employee> list=Arrays.asList(new Employee("1","hii",1,"Active","10000"),
													 new Employee("2","bye",1,"InActive","1000"),
													 new Employee("3","hii frnds",2,"Active","10"),
													 new Employee("4","hello",3,"InActive","3000"),
													 new Employee("5","Hey",4,"Active","10000.01"));
	private static ArrayList<Employee> testList=new ArrayList<>(list);
			
	public static void main(String[] args) {
		
		Solutions s=new Solutions();
		
		//fetching employee details in each department
//		Set<Map.Entry<Integer,ArrayList<Employee>>> employeeDetailsByDeptId=s.EmployeeDetailsByDeptId(testList);
//		employeeDetailsByDeptId.forEach(System.out::println);
		
		//employees count working in each department
//		s.EmployeeCountinEachDepartment(testList);
		
		//print active and inactive employees in the given collection
//		s.EmployeeActiveandInactive(testList);
		
		//Max/Min Salary from the given collection
//		Double d=s.MaxiSalaryfromCollection(testList);
//		System.out.println("maximum salary in employees collection is :"+d);
		
		//max salary of an employee from each department
//		s.MaxSalaryEmployeeFromEachDept(testList);
		
		
	}
}
