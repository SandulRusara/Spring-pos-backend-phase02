package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.dao.OrderDetailsDao;
import lk.ijse.springassignment.dto.impl.OrderDetailsDTO;
import lk.ijse.springassignment.entity.impl.OrderDetailsEntity;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.OrderDetailsService;
import lk.ijse.springassignment.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private Mapping mapping;
    Logger logger= LoggerFactory.getLogger(OrderDetailsServiceImpl.class);
    @Override
    public void saveOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        logger.info("Attempting to save orderdetails with Id ",orderDetailsDTO.getId());
        OrderDetailsEntity save = orderDetailsDao.save(mapping.toOrderDetailsEntity(orderDetailsDTO));
        if (save==null){
            logger.error("Order Details not saved with Id ",orderDetailsDTO.getId());
            throw new DataPersistException("order details not saved!!!!!!!");
        }else {
            logger.info("Orderdetails saved Successfully with Id "+orderDetailsDTO.getId());
        }
    }
}
