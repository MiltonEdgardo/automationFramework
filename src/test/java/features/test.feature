Feature: Validate some new feature for some new scenario
  Scenario Outline: Validate something
    Given a user that go to page
    When the user is in the home page and do click on the country <country>
    Then should return the next title <title>

    Examples:
    |country    | title |
    | Argentina | Mercado Libre - Envíos Gratis en el día           |