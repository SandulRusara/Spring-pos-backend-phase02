package lk.ijse.springassignment.repository;

import lk.ijse.springassignment.entity.impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {
}
