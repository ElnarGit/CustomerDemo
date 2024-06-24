package net.elnar.CustomerDemo.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.elnar.CustomerDemo.model.Customer;
import net.elnar.CustomerDemo.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerRestControllerV1 {
	private final CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
		if(id == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Customer customer = customerService.getById(id);
		
		if(customer == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer){
		HttpHeaders httpHeaders = new HttpHeaders();
		
		if(customer == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		customerService.save(customer);
		
		return new ResponseEntity<>(customer, httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer){
		HttpHeaders httpHeaders = new HttpHeaders();
		
		if(customer == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		customerService.save(customer);
		
		return new ResponseEntity<>(customer, httpHeaders, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
		Customer customer = customerService.getById(id);
		
		if(customer == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		customerService.delete(id);
		
		return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping()
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAll();
		
		if(customers.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
