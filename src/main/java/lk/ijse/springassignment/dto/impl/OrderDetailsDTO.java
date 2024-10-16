package lk.ijse.springassignment.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO {
    private String id;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private String customerCity;
    private String customerTel;
    private String itemName;
    private int orderQty;
    private double unitPrice;
    private ItemDTO item;
    private OrderDTO order;


}
