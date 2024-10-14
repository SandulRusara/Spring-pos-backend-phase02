package lk.ijse.springassignment.util;
import lk.ijse.springassignment.dto.impl.CustomerDTO;
import lk.ijse.springassignment.dto.impl.ItemDTO;
import lk.ijse.springassignment.dto.impl.OrderDTO;
import lk.ijse.springassignment.entity.impl.CustomerEntity;
import lk.ijse.springassignment.entity.impl.ItemEntity;
import lk.ijse.springassignment.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity tocustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    public CustomerDTO tocustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }



    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public ItemDTO toItemDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public List<ItemDTO>toItemList(List<ItemEntity>itemList){
        return modelMapper.map(itemList,new TypeToken<List<ItemDTO>>(){}.getType());
    }


    public OrderEntity toOrderentity (OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderEntity.class);
    }
    public OrderDTO toOrderDTO(OrderEntity orderEntity){
        return modelMapper.map(orderEntity, OrderDTO.class);
    }
    public List<OrderDTO>toOrderList(List<OrderEntity>orderList){
        return modelMapper.map(orderList,new TypeToken<List<OrderDTO>>(){}.getType());
    }

}
