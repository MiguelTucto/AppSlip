package com.appslip.Customer.Application;

import com.appslip.Customer.domain.model.Customer;
import com.appslip.Customer.domain.model.ICustomerService;
import com.appslip.Customer.infrastructure.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer save(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getById(Long Id) throws Exception {
        return customerRepository.findById(Id);
    }

    @Override
    public List<Customer> findByFirstName(String firstName) throws Exception {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Customer> findByLastName(String lastName) throws Exception {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public List<Customer> findByEmail(String email) throws Exception {
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<Customer> findByPhone(String phone) throws Exception {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public List<Customer> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
        return customerRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    @Override
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) throws Exception {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
