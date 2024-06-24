package net.elnar.CustomerDemo.repository;

import net.elnar.CustomerDemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
