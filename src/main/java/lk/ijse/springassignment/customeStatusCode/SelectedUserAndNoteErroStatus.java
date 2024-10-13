package lk.ijse.springassignment.customeStatusCode;

import lk.ijse.springassignment.dto.CustomerStatus;
import lk.ijse.springassignment.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErroStatus implements CustomerStatus, ItemStatus {
    private int statusCode;
    private String statusMessage;
}
