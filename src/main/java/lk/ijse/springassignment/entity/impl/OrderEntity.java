package lk.ijse.springassignment.entity.impl;

import jakarta.persistence.*;
import lk.ijse.springassignment.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    private String date;
    private double discountRate;
    private double discount;
    private double subTotal;
    private double balance;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customerId",nullable = false)
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetailsEntity>orderDetailsList;




}
