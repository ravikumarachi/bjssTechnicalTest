package com.pages;

import com.webDriverClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bjssPage extends webDriverClass {
    @FindBy(xpath = "//div[@id='content']/div/div/div/div/a[2]")
    private WebElement redButton;

    @FindBy(css = "button")
    private WebElement startButton;

    @FindBy(id="loading")
    private WebElement loadingBar;

    @FindBy(id="finish")
    private WebElement message;




    public void GotoURL(String URL) {
        driver.get(URL);
    }


    public void clickExamplesLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public void verifyLabelAfterClick() {
        String redButtonTextBeforeClick = redButton.getText();
        redButton.click();
        String redButtonTextAfterClick = redButton.getText();

        Assert.assertNotEquals("Button label/text should not be same before and after click:",redButtonTextBeforeClick,redButtonTextAfterClick);
    }

    public void clickStartButton() {
        startButton.click();
    }

    public void verifyMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));

        String actualMessage = message.getText();
        Assert.assertEquals("Incorrect Message:",expectedMessage,actualMessage);
    }
}
