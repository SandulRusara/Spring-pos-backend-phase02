package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springassignment.dao.OrderDao;
import lk.ijse.springassignment.dto.OrderStatus;
import lk.ijse.springassignment.dto.impl.OrderDTO;
import lk.ijse.springassignment.dto.impl.OrderDetailsDTO;
import lk.ijse.springassignment.entity.impl.OrderDetailsEntity;
import lk.ijse.springassignment.entity.impl.OrderEntity;
import lk.ijse.springassignment.exception.CustomerNotFoundException;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.OrderDetailsService;
import lk.ijse.springassignment.service.OrderService;
import lk.ijse.springassignment.util.AppUtil;
import lk.ijse.springassignment.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Autowired
    private OrderDetailsService orderDetailsService;
    private static final Logger logger= LoggerFactory.getLogger(OrderDetailsEntity.class);
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        logger.info("Attempting to save order with Id ",orderDTO.getOrderId());
        OrderEntity order = orderDao.save(mapping.toOrderentity(orderDTO));
        if (order==null){
            throw new DataPersistException("Order not saved");
        }else {
            logger.info("Saved Successfully !!!");
            for (OrderDetailsDTO orderDetailsDTO:orderDTO.getOrderDetailsDTO()){
               orderDetailsDTO.setId(AppUtil.OrderDetailsId());
               orderDetailsDTO.setOrder(orderDTO);
               orderDetailsService.saveOrderDetails(new OrderDetailsDTO(
                       orderDetailsDTO.getId(),
                       orderDetailsDTO.getDate(),
                       orderDetailsDTO.getCustomerId(),
                       orderDetailsDTO.getCustomerName(),
                       orderDetailsDTO.getCustomerCity(),
                       orderDetailsDTO.getCustomerTel(),
                       orderDetailsDTO.getItemName(),
                       orderDetailsDTO.getOrderQty(),
                       orderDetailsDTO.getUnitPrice(),
                       orderDetailsDTO.getItem(),
                       orderDetailsDTO.getOrder()
               ));
               logger.info("Order detail for order Id saved successfully ",orderDTO.getOrderId());
            }
        }
    }

    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {
        logger.info("Attempting to update order with Id ",orderId);
        Optional<OrderEntity> tmorder=orderDao.findById(orderId);
        if (tmorder.isPresent()){
            tmorder.get().setDate(orderDTO.getDate());
            tmorder.get().setDiscountRate(orderDTO.getDiscountRate());
            tmorder.get().setDiscount(orderDTO.getDiscount());
            tmorder.get().setSubTotal(orderDTO.getSubTotal());
            tmorder.get().setBalance(orderDTO.getBalance());
            tmorder.get().setCustomer(mapping.tocustomerEntity(orderDTO.getCustomerId()));
            tmorder.get().setOrderDetailsList(mapping.toOrderEntityDetailsList(orderDTO.getOrderDetailsDTO()));
            logger.info("Update Successfully with Id "+orderId);
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        logger.info("Attempting to delete order with Id ",orderId);
        Optional<OrderEntity> tmorder=orderDao.findById(orderId);
        if (!tmorder.isPresent()){
            logger.error("Not Found ",orderId);
            throw new CustomerNotFoundException("order "+orderId+"Not Found ");
        }else {
            logger.info("Delete Successfully !!! "+orderId);
            orderDao.deleteById(orderId);
        }
    }

    @Override
    public OrderStatus getOrder(String orderId) {
        if (orderDao.existsById(orderId)){
            return mapping.toOrderDTO(orderDao.getReferenceById(orderId));
        }else {
            return new SelectedUserAndNoteErroStatus(2,"Order Not Found");
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<OrderDTO> orders=mapping.toOrderList(orderDao.findAll());
       return orders;
    }
}
