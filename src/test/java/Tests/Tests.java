package Tests;

import org.testng.annotations.Test;

public class Tests extends TestBase {


    @Test
    public void firstTest(){
        app.amazonHelper().searchBooks();
        app.amazonHelper().searchEnglishBooks();
    }

    @Test
    public void secondTest(){
        app.amazonHelper().findLongestNameBook();
        app.amazonHelper().findLongestNameBookFromAllPages();
    }

}
