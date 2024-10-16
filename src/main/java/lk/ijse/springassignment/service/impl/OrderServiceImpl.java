package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.dao.OrderDao;
import lk.ijse.springassignment.dto.OrderStatus;
import lk.ijse.springassignment.dto.impl.OrderDTO;
import lk.ijse.springassignment.entity.impl.OrderEntity;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.OrderService;
import lk.ijse.springassignment.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity order = orderDao.save(mapping.toOrderentity(orderDTO));
        if (order==null){
            throw new DataPersistException("Order not saved");
        }
    }

    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {
        Optional<OrderEntity> tmorder=orderDao.findById(orderId);
        if (tmorder.isPresent()){
            tmorder.get().setDate(orderDTO.getDate());
            tmorder.get().setDiscountRate(orderDTO.getDiscountRate());
            tmorder.get().setDiscount(orderDTO.getDiscount());
            tmorder.get().setSubTotal(orderDTO.getSubTotal());
            tmorder.get().setBalance(orderDTO.getBalance());
            tmorder.get().setCustomer(mapping.tocustomerEntity(orderDTO.getCustomerId()));
        }
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
        List<OrderDTO> orders=mapping.toOrderList(orderDao.findAll());
       return orders;
    }
}
