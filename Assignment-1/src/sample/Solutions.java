package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Solutions {
	
	//fetching employee details in each department
	public Set<Map.Entry<Integer,ArrayList<Employee>>> EmployeeDetailsByDeptId(ArrayList<Employee> list) {
		HashMap<Integer,ArrayList<Employee>> employeeDetailsByDeptId=new HashMap<>();
		
		list.stream().forEach((employee)->{
			if(employeeDetailsByDeptId.get(employee.getDepId())==null) {
				ArrayList<Employee> l=new ArrayList<Employee>();
				l.add(employee);
				employeeDetailsByDeptId.put(employee.getDepId(),l);
			}
			else {
				ArrayList<Employee> ll=employeeDetailsByDeptId.get(employee.getDepId());
				ll.add(employee);
				employeeDetailsByDeptId.put(employee.getDepId(),ll);
			}
				
		});
		
		return employeeDetailsByDeptId.entrySet();
		
	}
	
	
	//employees count working in each department
	public void EmployeeCountinEachDepartment(ArrayList<Employee> list) {
		Set<Map.Entry<Integer,ArrayList<Employee>>> employeeDetailsByDeptIdSet= EmployeeDetailsByDeptId(list);
		employeeDetailsByDeptIdSet.stream().forEach((employees)->{
			System.out.print("department:"+employees.getKey()+" has "); System.out.print(employees.getValue().size()+" employees\n");
		});
	}
	
	
	
	//print active and inactive employees in the given collection
	public void EmployeeActiveandInactive(ArrayList<Employee> list) {
		ArrayList<Employee> activeEmployees=new ArrayList<>();
		System.out.println("List of inactive Employees");
		list.stream().filter((employee)->{
			
			if(Character.compare(Character.toLowerCase(employee.getStatus().charAt(0)),'i')==0)
				return true;
			else {
				activeEmployees.add(employee);
				return false;
			}
		}).collect(Collectors.toSet()).stream().forEach(System.out::println);
		
		System.out.println("List of Active Employees");
		activeEmployees.stream().forEach(System.out::println);
	}
	
	
	//Max/Min Salary from the given collection
	public Double MaxiSalaryfromCollection(ArrayList<Employee> list) {
		Optional<Employee> o=list.stream().max((e1,e2)->{
			int a=Double.valueOf(e1.getSalary()).compareTo(Double.valueOf(e2.getSalary()));
			
			if(a>0)
				return 1;
			else if(a<0)
				return -1;
			else
				return 0;
		});
		
		if(o.isPresent())
			return Double.valueOf(o.get().getSalary());
		else
			return null;
	}
	
	
	//max salary of an employee from each department
	public void MaxSalaryEmployeeFromEachDept(ArrayList<Employee> list) {
		Set<Map.Entry<Integer,ArrayList<Employee>>> employeeDetailsByDeptIdSet= EmployeeDetailsByDeptId(list);
		for(Map.Entry<Integer,ArrayList<Employee>> employeesEntry:employeeDetailsByDeptIdSet) {
			ArrayList<Employee> employees=employeesEntry.getValue();
			Double maxSalary=MaxiSalaryfromCollection(employees);
			System.out.println("Department "+employeesEntry.getKey()+" has max salary of :"+maxSalary);
		}
	}
}












