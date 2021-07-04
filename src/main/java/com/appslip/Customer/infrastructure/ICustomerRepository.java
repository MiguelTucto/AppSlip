package com.appslip.Customer.infrastructure;

import com.appslip.Customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByEmail(String email);
    public List<Customer> findByPhone(String phone);

    public List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
