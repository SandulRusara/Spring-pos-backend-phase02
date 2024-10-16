package lk.ijse.springassignment.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean customerIdMatcher(String customerId) {
        String regexForCustomerID = "^CUSTOMER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForCustomerID);
        return regexPattern.matcher(customerId).matches();
    }
    public static Matcher itemValidation(String itemCode){
        return Pattern.compile("^I\\d{2}-\\d{3,}$").matcher(itemCode);
    }
    public static Matcher orderIdValidation(String orderId){
        return Pattern.compile("/^\\d+$/").matcher(orderId);
    }
}
