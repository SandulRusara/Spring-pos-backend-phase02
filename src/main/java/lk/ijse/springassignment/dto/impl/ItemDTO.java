package lk.ijse.springassignment.dto.impl;

import lk.ijse.springassignment.dto.ItemStatus;
import lk.ijse.springassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemStatus {
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
}
