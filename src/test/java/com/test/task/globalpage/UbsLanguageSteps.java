package com.test.task.globalpage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class UbsLanguageSteps {


    private UbsGlobalPage ubsGlobalPage;

    public UbsLanguageSteps() {
        this.ubsGlobalPage = new UbsGlobalPage();
    }

    @Given("User navigates to Global page with {} locale")
    public void userNavigatesToGlobalPage(String language) {
        ubsGlobalPage.goToGlobalPage(language);
    }

    @When("User changes page language")
    public void userClicksLanguageButton() {
        ubsGlobalPage.clickLanguageButton();
    }

    @Then("Header title is {}")
    public void headerTitleIs(String headerTitle) {
        assertEquals("Header title is wrong!", ubsGlobalPage.getHeaderTitle(), headerTitle);
    }

    @When("User searches for {}")
    public void userSearchesFor(String searchValue) {
        ubsGlobalPage.searchFor(searchValue);
    }


    @When("User selects region {}")
    public void userSelectsContinent(String region) {
        ubsGlobalPage.clickDomicileButton();
        ubsGlobalPage.selectDomicileRegion(region);
    }

    @And("User selects country {}")
    public void userSelectsCountry(String country) {
        ubsGlobalPage.selectDomicileCountry(country);
    }

    @And("Promotion bar is displayed")
    public void promotionBarIsDisplayed() {
        ubsGlobalPage.checkPromotionBarDisplayed();
    }

    @And("About Us article is displayed")
    public void aboutUsArticleDisplayed() {
        ubsGlobalPage.checkAboutUsArticleDisplayed();
    }

    @And("Footer links are displayed")
    public void footerLinksDisplayed() {
        ubsGlobalPage.checkFooterLinksDisplayed();
    }

    @And("Footer disclaimer is displayed")
    public void footerDisclaimerDisplayed() {
        ubsGlobalPage.checkFooterDisclaimerDisplayed();
    }
}
