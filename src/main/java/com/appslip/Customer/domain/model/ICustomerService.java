package com.appslip.Customer.domain.model;

import com.appslip.Customer.domain.model.Customer;
import com.appslip.util.CrudService;

import java.util.List;

public interface ICustomerService extends CrudService<Customer> {
    public List<Customer> findByFirstName(String firstName) throws Exception;
    public List<Customer> findByLastName(String lastName) throws Exception;
    public List<Customer> findByEmail(String email) throws Exception;
    public List<Customer> findByPhone(String phone) throws Exception;

    public List<Customer> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) throws Exception;
}
