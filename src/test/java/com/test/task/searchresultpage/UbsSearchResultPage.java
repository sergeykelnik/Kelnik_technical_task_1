package com.test.task.searchresultpage;

import com.test.task.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.cssSelector;

public class UbsSearchResultPage extends BasePage {

    private By resultsSummary = cssSelector("p.summary");
    private By noResultsTitle = cssSelector("h2.no-results-title");

    private WebDriver driver;

    UbsSearchResultPage() {
        this.driver = super.driver;
    }

    boolean isInResults(String expectedTitle, int nbOfResultsToSearch) {
        wait.forPresenceOfElements(ofSeconds(5), resultsSummary, "Search results");
        return IntStream.range(0, min(driver.findElements(resultsSummary).size(), nbOfResultsToSearch))
                .anyMatch(index -> driver.findElements(resultsSummary).get(index).getText().contains(expectedTitle));
    }

    String getNoResultsHeader() {
        wait.forPresenceOfElements(ofSeconds(5), noResultsTitle, "No results found title");
        return driver.findElement(noResultsTitle).getText();
    }
}

