package tests;

import io.appium.java_client.android.AndroidDriver;
import logic.Init;
import logic.pages.PageObjectMain;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends Init {
//    WebDriverWait wait = new WebDriverWait(driver, 5);
    private static By search = new By.ByXPath("//*[contains(@text, 'Search')]");


    @Test
    public void findRandomText() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(search)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.wikipedia:id/search_src_text")))
                .sendKeys("asfdasfdasfdasfasfdsadasdas");
        if (checkSearchResults())
            System.out.println("Works as expected");
        else throw new Exception("Actual and expected results do not meet");

//        PageObjectMain pom = new PageObjectMain(this.driver);
 //        WebElement skip = pom.waitForElementAndClick(
//                "id:org.wikipedia:id/fragment_onboarding_skip_button",
//                "Cannot find Skip button",
//                5
//        );

//        WebElement searchField = pom.waitForElementAndClick(
//                "id:org.wikipedia:id/search_container",
//                "Cannot find Search field",
//                5
//        );
    }


    public boolean checkSearchResults() {
        String expectedResult = "No results found";
        String actualResult = driver.findElement(By.xpath("//*[contains(@text, 'No results found')]")).getText();
        return actualResult.equals(expectedResult);

    }

}
