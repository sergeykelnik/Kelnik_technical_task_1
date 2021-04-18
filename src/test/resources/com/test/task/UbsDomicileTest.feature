Feature: Global page Test


  @domicile @regression
  Scenario Outline: Check page display for different domiciles
    Given User navigates to Global page with EN locale
    When User selects region <region>
    And User selects country <country>
    Then Header title is <headerTitle>
    And Promotion bar is displayed
    And About Us article is displayed
    And Footer links are displayed
    And Footer disclaimer is displayed

    Examples:
      | region | country       | headerTitle              |
      | EU     | Switzerland   | Switzerland              |
      | NA     | United States | United States of America |
      | AS     | Japan         | Japan                    |
      | AF     | Saudi Arabia  | Saudi Arabia             |
      | SA     | Brazil        | Brazil                   |