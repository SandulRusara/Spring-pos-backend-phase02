package lk.ijse.springassignment.service;

import lk.ijse.springassignment.dto.ItemStatus;
import lk.ijse.springassignment.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String itemId,ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemStatus getItem(String itemId);
    List<ItemDTO>getAllItem();
}
