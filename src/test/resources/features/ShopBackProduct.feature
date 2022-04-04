Feature: ShopBack Website for Product Search

  Scenario Outline: Validate the e2e flow where user logged in and then choose a product from category and subcategory
  and then apply filter and sort and visit next page

    Given click on LoginSignup button
    When click on Login button
    And click on Use Email Address button
    Then enter the username '<email>'
    And click on next button
    Then enter the password '<password>'
    And click on next button
    And dismiss the popup from home page
    Then user can see "Log out" option now
    When user select Categories as '<Category>' and subcategory as '<SubCategory>'
    Then user should be on '<SubCategory>' page
    Given apply filter on category '<categoryFilter>' and brand '<brandFilter>' and cashback store '<cashbackStoreFilter>'
    And enter min and max price '<minPrice>' and '<maxPrice>'
    And click on done button
    And apply sort '<sort>'
    Then scroll down to the page
    And click on next page
    Then user should be on '<pageNumber>' page

    Examples:
      |email                    |password  |Category         |SubCategory|categoryFilter|brandFilter |cashbackStoreFilter|minPrice|maxPrice|sort             |pageNumber|
      |qaassignment@shopback.com|Shopback22|Mobiles & Tablets|Smartphone |              |Samsung     |Lazada             |100     |1000    |Price Low to High|p=2       |