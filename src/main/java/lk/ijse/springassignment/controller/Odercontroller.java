package lk.ijse.springassignment.controller;

import lk.ijse.springassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springassignment.dto.OrderStatus;
import lk.ijse.springassignment.dto.impl.OrderDTO;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.OrderService;
import lk.ijse.springassignment.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin
public class Odercontroller {
    @Autowired
    private OrderService orderService;
    static Logger logger= LoggerFactory.getLogger(Odercontroller.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO){
        orderDTO.setOrderId(orderDTO.getOrderId());
        try {
            orderService.saveOrder(orderDTO);
            logger.error("Saved Order !!");
            return new  ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.error("Bad Request !!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Internal Server Erro");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateOrder(@PathVariable("orderId")String orderId,@RequestBody OrderDTO orderDTO){
        try {
            orderService.updateOrder(orderId,orderDTO);
            logger.error("Update Order !!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.error("Bad Request !!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Internal Server Erro");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
       List<OrderDTO> orderList= orderService.getAllOrder();
       try {
           if (orderList.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }else {
               logger.info("Successfully  all orders ",orderList.size());
               return new ResponseEntity<>(orderList,HttpStatus.OK);
           }
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void>deleteOrder(@PathVariable("orderId")String orderId){
        try {
            if (!RegexProcess.orderIdValidation(orderId).matches()){
                logger.error("Bad Request !!");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            orderService.deleteOrder(orderId);
            logger.error("No Content");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e ){
            logger.error("Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Internal Server Error ");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{orderId}")
    public OrderStatus getOrder(@PathVariable("orderId")String orderId){
        if (!RegexProcess.orderIdValidation(orderId).matches()){
            logger.error("Order id Not Valid");
            return new SelectedUserAndNoteErroStatus(1,"Order Id Not Valid");
        }
            logger.info("Successfully");
            return orderService.getOrder(orderId);

    }
}
