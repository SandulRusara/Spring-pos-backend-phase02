package lk.ijse.springassignment.dto.impl;

import lk.ijse.springassignment.dto.OrderStatus;
import lk.ijse.springassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderStatus {
}
