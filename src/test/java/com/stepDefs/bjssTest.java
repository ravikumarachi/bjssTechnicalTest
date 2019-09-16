package com.stepDefs;

import com.pages.bjssPage;
import com.webDriverClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class bjssTest extends webDriverClass {
    public bjssPage bjssPage = PageFactory.initElements(driver, com.pages.bjssPage.class);




    @Given("^I goto URL \"([^\"]*)\"$")
    public void iGotoURL(String URL) {
        bjssPage.GotoURL(URL);
    }


    @When("^I click \"([^\"]*)\" link$")
    public void iClickLink(String link){
        bjssPage.clickExamplesLink(link);
    }

    @Then("^I verify label has been changed after clicking Red button$")
    public void iVerifyLabelHasBeenChangedAfterClickingRedButton() {
        bjssPage.verifyLabelAfterClick();




    }

    @And("^I click on Start button$")
    public void iClickOnStartButton() {
        bjssPage.clickStartButton();
    }

    @Then("^I should see \"([^\"]*)\" text after loading bar disappears$")
    public void iShouldSeeTextAfterLoadingBarDisappears(String expectedMessage) {
        bjssPage.verifyMessage(expectedMessage);
    }
}
