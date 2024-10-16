package lk.ijse.springassignment.dto.impl;

import lk.ijse.springassignment.dto.OrderStatus;
import lk.ijse.springassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sound.sampled.Line;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderStatus {
    private String orderId;
    private String date;
    private double discountRate;
    private double discount;
    private double subTotal;
    private double balance;
    private CustomerDTO customerId;
    private List<OrderDetailsDTO> orderDetailsDTO;
}
