package lk.ijse.springassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springassignment.customeStatusCode.SelectedUserAndNoteErroStatus;
import lk.ijse.springassignment.dao.ItemDao;
import lk.ijse.springassignment.dto.ItemStatus;
import lk.ijse.springassignment.dto.impl.ItemDTO;
import lk.ijse.springassignment.entity.impl.ItemEntity;
import lk.ijse.springassignment.exception.CustomerNotFoundException;
import lk.ijse.springassignment.exception.DataPersistException;
import lk.ijse.springassignment.service.ItemService;
import lk.ijse.springassignment.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity item=itemDao.save(mapping.toItemEntity(itemDTO));
        if (item==null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItem=itemDao.findById(itemId);
        if (tmpItem.isPresent()){
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setQtyOnHand(itemDTO.getQtyOnHand());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity>tmpItem=itemDao.findById(itemId);
        if (!tmpItem.isPresent()){
            throw new CustomerNotFoundException("item code with "+itemId+" NOt Found ");
        }else {
            itemDao.deleteById(itemId);
        }

    }

    @Override
    public ItemStatus getItem(String itemId) {
       if (itemDao.existsById(itemId)){
           return mapping.toItemDTO(itemDao.getReferenceById(itemId));
       }else {
           return new SelectedUserAndNoteErroStatus(2,"Selected item not found");
       }
    }

    @Override
    public List<ItemDTO> getAllItem() {
       return mapping.toItemList(itemDao.findAll());
    }
}
