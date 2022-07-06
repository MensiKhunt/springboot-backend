package net.java.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.java.springboot.exception.ResourceNotFoundException;
import net.java.springboot.model.Employee;
import net.java.springboot.model.Subject;
import net.java.springboot.repository.EmployeeRepository;
import net.java.springboot.repository.SubjectRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class EmployeeController {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public SubjectRepository subjectRepository;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	//create rest api for employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//get employee by id in rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).
	orElseThrow(() -> new ResourceNotFoundException("Employee Not exist")); 
		return ResponseEntity.ok(employee);
	}
	
	//update employee 
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Not exist")); 
		employee.setName(employeeDetails.getName());
		employee.setAddress(employeeDetails.getAddress());
		employee.setGender(employeeDetails.getGender());
		employee.setCars(employeeDetails.getCars());
		employee.setDoj(employeeDetails.getDoj());
		employee.setHobbies(employeeDetails.getHobbies());
		employee.setCountry(employeeDetails.getCountry());
		//employee.setSubject(employeeDetails.getSubject());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
				
	}
	
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Not exist"));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
//		delete subject
	@DeleteMapping("/subject/{subjectId}")
//	
//	public ResponseEntity<String> delete (@PathVariable("subjectId") Long subjectId) {
//		this.subjectRepository.deleteById(subjectId);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body("delete data success..");	
//	}
	
	
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("subjectId") long subjectId){
        Subject subject =subjectRepository.findById((long) subjectId)
                .orElseThrow(()->new ResourceNotFoundException("employee not exists with id"));
        subjectRepository.deleteById (subjectId);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE );
        return ResponseEntity.ok(response);


}
	
//	@DeleteMapping("/subject/{subjectId}")
//	
//    public ResponseEntity<Map<String, Boolean>> deletecustomer(@PathVariable long subjectId){    
//
//        try {
//
//        	employeeRepository.deleteById(subjectId);
//            
//
//            Map<String, Boolean> respons = new HashMap<>();
//
//            respons.put("Delete customer Id is "+subjectId, Boolean.TRUE);
//
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(respons);
//        }
//        catch (Exception e) {
//
//
//            e.getMessage();
//
//            e.printStackTrace();
//
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
	}
	
	

