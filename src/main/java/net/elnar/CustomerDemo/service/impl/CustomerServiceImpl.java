package net.elnar.CustomerDemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.elnar.CustomerDemo.model.Customer;
import net.elnar.CustomerDemo.repository.CustomerRepository;
import net.elnar.CustomerDemo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
	
	@Override
	public Customer getById(Long id) {
		log.info("IN CustomerServiceImpl getById {}", id);
		return customerRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(Customer customer) {
		log.info("IN CustomerServiceImpl save {}", customer);
		customerRepository.save(customer);
	}
	
	@Override
	public void delete(Long id) {
		log.info("IN CustomerServiceImpl delete {}", id);
		customerRepository.deleteById(id);
	}
	
	@Override
	public List<Customer> getAll() {
		log.info("IN CustomerServiceImpl getAll");
		return customerRepository.findAll();
	}
}
