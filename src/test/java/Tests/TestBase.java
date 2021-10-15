package Tests;

import AppData.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        app.start();
        app.amazonHelper().preConditions();


    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //app.end();
    }

}
