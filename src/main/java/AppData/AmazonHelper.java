package AppData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class AmazonHelper extends HelperMethods {


    public AmazonHelper(WebDriver wd) {
        super(wd);
    }

    public void preConditions() {
        type(By.id("twotabsearchtextbox"), "Harry Potter and the Order of the Phoenix");
        click(By.id("nav-search-submit-button"));
        click(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Books']"));
    }

    public void searchBooks() {
        WebElement element = wd.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult = element.getText().split(" ")[2];
        String expectedResult = element.getText().split(" ")[2];
        Assert.assertEquals(expectedResult, actualResult, "Wrong result");
        System.out.println("The number of Books found is:  -> " + actualResult);
        pause();
    }

    public void searchEnglishBooks() {
        wd.findElement(By.linkText("English")).click();
        WebElement element2 = wd.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult = element2.getText().split(" ")[2];
        String expectedResult = element2.getText().split(" ")[2];
        Assert.assertEquals(expectedResult, actualResult, "Wrong result");
        System.out.println("The number of English books found is: " + actualResult);
    }

    public String findLongestNameBook() {
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
        assert element != null;
        int expectedRes = element.length();
        Assert.assertEquals(i, expectedRes);
        System.out.println("longest name is: " + element + "  length: " + i);
        return element;

    }

    public String findLongestNameBookFromAllPages() {
        List<WebElement> listOfBooks = wd.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<String> books = new ArrayList<>();
        for (WebElement listOfBook : listOfBooks) {
            books.add(listOfBook.getText());
        }

        WebElement nextButton = wd.findElement(By.xpath("//li[@class='a-last']"));
        while (true) {
            nextButton.click();
            listOfBooks = wd.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            pause();
            for (WebElement listOfBook : listOfBooks) {
                books.add(listOfBook.getText());
            }
            try {
                nextButton = wd.findElement(By.xpath("//li[@class='a-last']"));
            } catch (Exception e) {
                break;
            }
        }
        int i = 0;
        String element = null;
        for (String book : books) {
            if (book.length() > i) {
                element = book;
                i = element.length();
            }
        }
        assert element != null;
        int expectedRes = element.length();
        Assert.assertEquals(i, expectedRes);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Longest name from all pages: " + element + "  length: " + i);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return element;
    }
}