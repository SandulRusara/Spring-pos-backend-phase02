package lk.ijse.springassignment.controller;

import lk.ijse.springassignment.dto.impl.ItemDTO;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.ItemService;
import lk.ijse.springassignment.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class itemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveItem(@RequestBody ItemDTO itemDTO){
        itemDTO.setItemCode(itemDTO.getItemCode());
        try {
            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{itemCode}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateItem(@PathVariable("itemCode") String itemCode,@RequestBody ItemDTO itemDTO){
        try {
            itemService.updateItem(itemCode,itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void>deleteItem(@PathVariable("itemCode")String itemCode){
        try {
            if (!RegexProcess.itemValidation(itemCode).matches()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.deleteItem(itemCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO>getAllItem(){
        return itemService.getAllItem();
    }

}
