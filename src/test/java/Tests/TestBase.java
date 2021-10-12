package Tests;

import AppData.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass
    public void setUp(){
        app.start();

    }
    @AfterClass
    public void tearDown(){
        //app.end();
    }

}
