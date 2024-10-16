package lk.ijse.springassignment.controller;

import lk.ijse.springassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springassignment.dto.ItemStatus;
import lk.ijse.springassignment.dto.impl.ItemDTO;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.ItemService;
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
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;
    static Logger logger = LoggerFactory.getLogger(ItemController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveItem(@RequestBody ItemDTO itemDTO){
        itemDTO.setItemCode(itemDTO.getItemCode());
        try {
            itemService.saveItem(itemDTO);
            logger.info("Item Saved Successfully With Item Code : ",itemDTO.getItemCode());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Fail To Saved Item Bad Request > With Item Code : ",itemDTO.getItemCode());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Internal Server Erro With Item Code ",itemDTO.getItemCode());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{itemCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateItem(@PathVariable("itemCode") String itemCode,@RequestBody ItemDTO itemDTO){
        try {
            itemService.updateItem(itemCode,itemDTO);
            logger.info("Item Update Successfully ",itemCode);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Fail To Update Item> With Item Code : ",itemCode);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Internal Server Erro With Item Code ",itemCode);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void>deleteItem(@PathVariable("itemCode")String itemCode){
        try {
            if (!RegexProcess.itemValidation(itemCode).matches()){
                logger.info(" Invalid Item Code ",itemCode);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemCode);
            logger.info(" Item Delete Successfully ",itemCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            logger.warn(" Item Code Not Found ",itemCode);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error(" Internal Server Erro With Item Code ",itemCode);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>>getAllItem(){
       try {
           List<ItemDTO> itemList=itemService.getAllItem();
           if (itemList.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }else {
               logger.info("All Items Successfully "+itemList.size());
               return new ResponseEntity<>(itemList,HttpStatus.OK);
           }
       }catch (Exception e){
           logger.error("Erro Item List ",e);
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @GetMapping(value = "/{itemCode}")
    public ItemStatus getSelectedItem(@PathVariable("itemCode") String itemCode){
        if (!RegexProcess.itemValidation(itemCode).matches()){
            logger.warn("Invalid Item Code ",itemCode);
            return new SelectedUserAndNoteErroStatus(1,"Item Code is Not Valid");

        }
        return itemService.getItem(itemCode);
    }

}
