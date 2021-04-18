package com.test.task.globalpage;

import com.test.task.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;

public class UbsGlobalPage extends BasePage {

    private static String HOME_PAGE_URL = getProperty("baseUrl");
    private static final String EN_URL = "/global/en.html";
    private static final String DE_URL = "/global/de.html";

    private WebDriver driver;

    private By languageBtn = cssSelector("a[class*='languageButton']");
    private By headerTitle = cssSelector(".header__title .header__hlTitle");
    private By searchButton = cssSelector("button[aria-label=\"Search\"]");
    private By searchInputField = cssSelector("input#searchbox.searchbox");

    private By domicileButtonCommon = cssSelector("button#domicileButton");
    private By domicileRegion = cssSelector(".metaNav__list--domicile button.domicileSelection__select--region");
    private String domicileRegionSub = ".metaNav__list--domicile .domicileSelection__regionButton[data-region='%s']";
    private By domicileCountry = cssSelector(".metaNav__list--domicile button.domicileSelection__select--domicile");
    private String domicileCountrySub = "//ul[contains(@class, 'metaNav__list--domicile')]//a[@class='domicileSelection__countryLink' and contains(text(), '%s')]";


    private By promotion = cssSelector("div.promotion__wrapper");
    private By aboutUs = cssSelector("article.aboutUs__article");
    private By footerLinks = cssSelector("div.footerLinks");
    private By footerDisclaimer = cssSelector("div.footer__disclaimer");

    UbsGlobalPage() {
        this.driver = super.driver;
    }

    void goToGlobalPage(String country) {
        if (HOME_PAGE_URL == null) {
            HOME_PAGE_URL = "https://www.ubs.com/";
        }
        switch (country) {
            case "EN":
                driver.get(HOME_PAGE_URL + EN_URL);
                wait.forLoading(ofSeconds(5));
                break;
            case "DE":
                driver.get(HOME_PAGE_URL + DE_URL);
                wait.forLoading(ofSeconds(5));
                break;
            default:
                throw new IllegalArgumentException("This locale \"" + country + "\" is not supported.");
        }
    }

    void clickDomicileButton() {
        driver.findElement(domicileButtonCommon).click();
        wait.forElementToBeClickable(ofSeconds(5), driver.findElement(domicileRegion), "Region selector");
    }

    void selectDomicileRegion(String region) {
        driver.findElement(domicileRegion).click();
        WebElement element = driver.findElement(cssSelector(format(domicileRegionSub, region)));
        wait.forElementToBeClickable(ofSeconds(5), element, "Region list");
        element.click();
    }

    void selectDomicileCountry(String country) {
        driver.findElement(domicileCountry).click();
        WebElement element = driver.findElement(xpath(format(domicileCountrySub, country)));
        wait.forElementToBeClickable(ofSeconds(5), element, "Country list");
        element.click();
    }

    void clickLanguageButton() {
        driver.findElement(languageBtn).click();
    }

    String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    void checkPromotionBarDisplayed() {
        wait.forElementToBeDisplayed(ofSeconds(5), driver.findElement(promotion), "Promotion banner");
    }

    void checkAboutUsArticleDisplayed() {
        wait.forElementToBeDisplayed(ofSeconds(5), driver.findElement(aboutUs), "About Us article");
    }

    void checkFooterLinksDisplayed() {
        wait.forElementToBeDisplayed(ofSeconds(5), driver.findElement(footerLinks), "Footer links");
    }

    void checkFooterDisclaimerDisplayed() {
        wait.forElementToBeDisplayed(ofSeconds(5), driver.findElement(footerDisclaimer), "Footer disclaimer");
    }

    void searchFor(String searchValue) {
        driver.findElement(searchButton).click();
        WebElement element = driver.findElement(searchInputField);
        wait.forElementToBeDisplayed(ofSeconds(5), element, "Search input field");
        element.sendKeys(searchValue);
        element.sendKeys(ENTER);
    }
}
