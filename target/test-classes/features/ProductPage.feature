Feature: Verify category and subcategory options

  Scenario Outline: Search product from search box
    Given search the product '<ProductName>'
#    Then '<ProductName>' should be in the search list
    And click on any product from the search list
    Examples:
    |ProductName       |
    |Samsung galaxy s10|

#  product should be in the search list

    Scenario Outline: Apply filters and sort then click on next page
      Given apply filter on category '<category>' and brand '<brand>' and cashback store '<cashbackStore>'
      And enter min and max price '<minPrice>' and '<maxPrice>'
      And click on done button
      And apply sort '<sort>'
      Then scroll down to the page
      And click on next page
      Then url should contains '<pageNumber>'
      Examples:
      |category|brand  |cashbackStore|minPrice|maxPrice|sort              |pageNumber|
      |        |Samsung|Lazada       |100     |1000     |Price Low to High|p=2       |

#      need to do all steps from home page, click on cat and subcat
#  check assert how