package Day46;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;// UI of the report.
    public ExtentReports extent;//populate common info on the report.
    public ExtentTest test;// create test case entries in the report and update status of test methods.

    public void onStart(ITestContext context) {
        sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/newReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);// combain UI with the report
        extent.setSystemInfo("Computer name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Tester name", "Charishma");
        extent.setSystemInfo("OS", "macOS");
    }
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());//create a new entry in the report.
        test.log(Status.PASS, "Test case passed is " + result.getName());

    }
public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case failed is " + result.getName());
    test.log(Status.FAIL, "Test case failed is " + result.getThrowable());
    //result.getThrowable()// will get error message

}
public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped is " + result.getName());
}

public void onFinish(ITestContext context) {
        extent.flush();// writes test info from the started reports to the output view.

}

}
