package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springassignment.dao.CustomerDao;
import lk.ijse.springassignment.dto.CustomerStatus;
import lk.ijse.springassignment.dto.impl.CustomerDTO;
import lk.ijse.springassignment.entity.impl.CustomerEntity;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.exception.CustomerNotFoundException;
import lk.ijse.springassignment.service.CustomerService;
import lk.ijse.springassignment.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;
    static Logger logger=LoggerFactory.getLogger(CustomerServiceIMPL.class);
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        logger.info("Attempting to save customer With Id "+customerDTO.getCustomerId());
        CustomerEntity saveCustomer= customerDao.save(mapping.tocustomerEntity(customerDTO));
        if (saveCustomer == null) {
            throw new DataPersistException("Customer not saved");
        }else {
            logger.info("Customer Saved Successfully !!!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
      List<CustomerEntity> allCustomers=customerDao.findAll();
      return mapping.asCustomerDTOList(allCustomers);
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if (customerDao.existsById(customerId)){
            CustomerEntity selectedCustomer = customerDao.getReferenceById(customerId);
            return mapping.tocustomerDTO(selectedCustomer);
        }else {
            return new SelectedUserAndNoteErroStatus(2,"Customer with id "+ customerId + "not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> exitsCustomer = customerDao.findById(customerId);
        if (!exitsCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer with id "+ customerId + "not found");
        }else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        logger.info("Attempting to update customer with Id "+customerId);
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(customerId);
        if (tmpCustomer.isPresent()){
            tmpCustomer.get().setFirstName(customerDTO.getFirstName());
            tmpCustomer.get().setCity(customerDTO.getCity());
            tmpCustomer.get().setEmail(customerDTO.getEmail());
            tmpCustomer.get().setAddress(customerDTO.getAddress());
            logger.info("Customer Update Successfully !!! with Id "+customerId);
        }else {
            logger.warn("Customer Not Found For Update With Id "+customerId);
        }
    }
}
