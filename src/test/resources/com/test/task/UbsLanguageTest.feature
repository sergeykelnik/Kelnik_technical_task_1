Feature: Language Test

  @language @regression
  Scenario Outline: Check page localization
    Given User navigates to Global page with <language> locale
    When User changes page language
    Then Header title is <headerTitle>
    Examples:
      | language | headerTitle    |
      | EN       | Globale Themen |
      | DE       | Global         |
