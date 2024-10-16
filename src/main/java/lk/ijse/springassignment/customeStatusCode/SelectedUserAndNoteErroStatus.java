package lk.ijse.springassignment.customeStatusCode;

import lk.ijse.springassignment.dto.CustomerStatus;
import lk.ijse.springassignment.dto.ItemStatus;
import lk.ijse.springassignment.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErroStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private int statusCode;
    private String statusMessage;
}
