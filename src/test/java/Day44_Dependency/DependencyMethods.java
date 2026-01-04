package Day44_Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
    @Test(priority = 1)
    void openApp(){
        Assert.assertTrue(true);
    }
    @Test(priority = 2, dependsOnMethods = {"openApp"})// if the openApp method is passed only this
    // method will execute if it fails this method will skip. This saves lot of time for testNG.
    void login(){
      Assert.assertTrue(true);
    }
    @Test(priority = 3, dependsOnMethods = {"login"})
    void search(){
        Assert.assertTrue(true);
    }
    @Test(priority = 4, dependsOnMethods = {"login","search"})
    void advSearch(){
        Assert.assertTrue(true);
        //Assert.assertTrue(false); use this in login to see Adv search feature.
        // keeping all true except login this will be skipped and executes logout.
    }
    @Test(priority = 5, dependsOnMethods = {"login"})
    void logout(){
        Assert.assertTrue(true);
    }

}
