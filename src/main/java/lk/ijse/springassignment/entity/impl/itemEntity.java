package lk.ijse.springassignment.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.springassignment.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class itemEntity implements SuperEntity {
    @Id
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
}
