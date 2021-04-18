Feature: Search Test

  @search @positive @regression
  Scenario Outline: Search a query which returns results
    Given User navigates to Global page with EN locale
    When User searches for <searchQuery>
    Then A <searchQuery> is displayed in the <nbOfResultsToSearch> results
    Examples:
      | searchQuery | nbOfResultsToSearch |
      | mortgage    | 3                   |
      | Poland      | 12                  |

  @search @negative @regression
  Scenario Outline: Search a query which returns no results
    Given User navigates to Global page with EN locale
    When User searches for <searchQuery>
    Then No results found message is displayed for <searchQuery>
    Examples:
      | searchQuery |
      | 12345       |