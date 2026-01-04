package Day44_Dependency;

import org.testng.annotations.Test;

public class PaymentTests {
    @Test(priority = 1, groups = {"sanity","regression","functional"})
    void paymentinRupees(){
        System.out.println("Payment in Ruppes");
    }
    @Test(priority = 2,groups = {"sanity","regression","functional"})
    void paymentindollars(){
        System.out.println("Payment in dollars");
    }
}
