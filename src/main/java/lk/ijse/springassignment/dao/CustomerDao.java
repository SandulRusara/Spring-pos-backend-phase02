package lk.ijse.springassignment.dao;

import lk.ijse.springassignment.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
