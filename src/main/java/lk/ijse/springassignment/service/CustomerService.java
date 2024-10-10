package lk.ijse.springassignment.service;

import lk.ijse.springassignment.dto.CustomerStatus;
import lk.ijse.springassignment.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO>getAllCustomers();
    CustomerStatus getCustomer(String customerId);
    void deleteCustomer(String customerId);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
}
