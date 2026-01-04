package Day42_TestNG;

import org.testng.annotations.Test;

public class FirstTestCase {
    @Test(priority = 1)
    void openApp() {
        System.out.println("opening App");
    }
    @Test(priority = 2)
    void login() {
        System.out.println("login");
    }
    @Test(priority = 3)
    void logout() {
        System.out.println("logout");
    }

}
