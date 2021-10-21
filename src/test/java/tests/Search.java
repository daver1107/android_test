package tests;

import io.appium.java_client.android.AndroidDriver;
import logic.Init;
import logic.pages.PageObjectMain;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class Search extends Init {

    @Test
    public void findRandomText() throws Exception {
        PageObjectMain pom = new PageObjectMain(this.driver);

//        WebElement skip = pom.waitForElementAndClick(
//                "id:org.wikipedia:id/fragment_onboarding_skip_button",
//                "Cannot find Skip button",
//                5
//        );
        driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button")).click();
        driver.findElement(By.id("org.wikipedia:id/search_container")).click();

//        WebElement searchField = pom.waitForElementAndClick(
//                "id:org.wikipedia:id/search_container",
//                "Cannot find Search field",
//                5
//        );

        driver.findElement(By.xpath("//*[contains(@text, 'Search')]"))
                .sendKeys("asfdasfdasfdasfasfdsadasdas");
        if (checkSearchResults())
            System.out.println("Works as expected");
        else throw new Exception("Actual and expected results do not meet");
    }

    public boolean checkSearchResults() {
        String actualResult = driver.findElement(By.xpath("//*[contains(@text, 'No results')]")).getText();
        return actualResult.equals("No results");

    }

}
