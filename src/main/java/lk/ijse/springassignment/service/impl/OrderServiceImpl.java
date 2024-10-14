package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.dto.OrderStatus;
import lk.ijse.springassignment.dto.impl.OrderDTO;
import lk.ijse.springassignment.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(OrderDTO orderDTO) {

    }

    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {

    }

    @Override
    public void deleteOrder(String orderId) {

    }

    @Override
    public OrderStatus getOrder(String orderId) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        return null;
    }
}
