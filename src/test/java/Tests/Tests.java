package Tests;

import org.testng.annotations.Test;

public class Tests extends TestBase {





    @Test
    public void firstTest(){
        app.amazonHelper().searchElement();
        app.amazonHelper().changeDepartment();
        app.amazonHelper().verifyIfBookWasFound();
        app.amazonHelper().verifyResultForBook();
        app.amazonHelper().verifyResultOfEnglishBooks();
        app.amazonHelper().findLongestNameBook();
    }

}
