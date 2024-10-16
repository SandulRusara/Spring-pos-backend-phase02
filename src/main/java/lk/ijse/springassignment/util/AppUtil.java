package lk.ijse.springassignment.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUSTOMER-"+UUID.randomUUID();
    }
    public static String OrderDetailsId(){
        return "ORDER_DETAIL-" + UUID.randomUUID();
    }

}
