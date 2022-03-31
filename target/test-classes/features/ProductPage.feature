Feature: Verify category and subcategory options
  Background:
    Given Go to url

  Scenario: Go to categories and select the product item
  Given search the product "samsung galaxy a51"
  Then click on any product from the search list
#    Given filter the phone brand
#    When enter max price "500"
#    And select the cashback store
#    And click on done button
#    And apply sort
#    Then scroll down to the page
#    And click on next page
#    Then current page is "p=2"