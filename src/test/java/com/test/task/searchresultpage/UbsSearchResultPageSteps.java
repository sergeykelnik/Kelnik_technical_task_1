package com.test.task.searchresultpage;

import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UbsSearchResultPageSteps {

    private UbsSearchResultPage searchResultPage;

    public UbsSearchResultPageSteps() {
        this.searchResultPage = new UbsSearchResultPage();
    }

    @Then("A {} is displayed in the {} results")
    public void isDisplayedInTheFirstResults(String expectedResult, int nbOfResultsToSearch) {
        assertTrue(expectedResult + " wasn't found in the first " + nbOfResultsToSearch + " results.",
                searchResultPage.isInResults(expectedResult, nbOfResultsToSearch));
    }

    @Then("No results found message is displayed for {}")
    public void noResultsMessageAppears(String query) {
        assertEquals("Incorrect message appears", "Ooops, we didn't find any results for " + query,
                searchResultPage.getNoResultsHeader());
    }

}
