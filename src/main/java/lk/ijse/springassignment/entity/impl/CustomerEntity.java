package lk.ijse.springassignment.entity.impl;

import jakarta.persistence.*;
import lk.ijse.springassignment.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String firstName;
    private String city;
    private String email;
    private String address;
    //@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    

}
