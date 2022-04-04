Feature: Verify category and subcategory options

  Background:
    Given user is already logged in
      |email                	|password  |
      |qaassignment@shopback.com|Shopback22|

  Scenario Outline: Go to categories and select the product item
    Given user select Categories as '<Category>' and subcategory as '<SubCategory>'
    Then user should be on '<SubCategory>' page

    Examples:
    |Category                 |SubCategory|
    |Mobiles & Tablets        |Smartphone |
    |Computers & Laptops      |Extender   |
    |Fashion                  |Tops       |