package lk.ijse.springassignment.customeStatusCode;

import lk.ijse.springassignment.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErroStatus implements CustomerStatus {
    private int statusCode;
    private String statusMessage;
}
