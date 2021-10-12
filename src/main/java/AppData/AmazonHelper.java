package AppData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonHelper extends HelperMethods {


    public AmazonHelper(WebDriver wd) {
        super(wd);
    }

    public void searchElement() {
        type(By.id("twotabsearchtextbox"), "Harry Potter and the Order of the Phoenix");
        click(By.id("nav-search-submit-button"));

    }

    public void changeDepartment() {
        click(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Books']"));
    }

    public void verifyIfBookWasFound() {
        WebElement element = wd.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String text = element.getText();
        Assert.assertEquals(text, "\"Harry Potter and the Order of the Phoenix\"");
    }

    public void verifyResultForBook() {
        WebElement element = wd.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String result = element.getText().split(" ")[2];
        System.out.println("The number of Books found is:  -> " + result);
        pause();
    }

    public void verifyResultOfEnglishBooks() {
        wd.findElement(By.linkText("English")).click();
        WebElement element = wd.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String result = element.getText().split(" ")[2];
        System.out.println("The number of English books found is: " + result);
    }

    public void findLongestNameBook() {
        List<WebElement> list = wd.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<String> books = new ArrayList<>();
        for (WebElement web : list) {
            books.add(web.getText());
        }
        int i = 0;
        String element = null;
        for (String book : books) {
            if (book.length() > i) {
                element = book;
                i = element.length();
            }
        }
        System.out.println(element);
    }
}
