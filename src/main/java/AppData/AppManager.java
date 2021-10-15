package AppData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {


    WebDriver wd;
    String browser;
    AmazonHelper amazonHelper;



    public AppManager(String browser){
        this.browser = browser;
    }

    public void start(){
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }

        amazonHelper = new AmazonHelper(wd);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.amazon.com/");

    }

    public void end(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.quit();
    }

    public AmazonHelper amazonHelper(){
        return amazonHelper;
    }
}
