package lk.ijse.springassignment.dto.impl;

import lk.ijse.springassignment.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

}
