Feature: Verify category and subcategory options

#  Background:
#    Given user is already logged in
#      |email                	|password  |
#      |qaassignment@shopback.com|Shopback22|

  Scenario: Go to categories and select the product item
    Given click on Categories "Mobiles & Tablets"
    When click on subcategory "Smartphone"
    Then url should contains "Smartphone"
    ||