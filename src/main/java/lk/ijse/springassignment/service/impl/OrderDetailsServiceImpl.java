package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.dto.impl.OrderDetailsDTO;
import lk.ijse.springassignment.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private
    @Override
    public void saveOrderDetails(OrderDetailsDTO orderDetailsDTO) {

    }
}
