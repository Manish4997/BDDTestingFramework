@EcommerceE2E
Feature: End to End Regression of Ecommerce Website APIs
  I want to use this feature to login,create product,create order and validate the order created 
  and then delete the product created using the Ecommerce APIs

  #@CreateProduct
  Scenario Outline: TC01_Validate User is able to login and create product successfully using API
    Given The Keword for Validate User is able to login and create product successfully using API is "<Keyword>"
    When User logins to Ecommerce Website using the Login API
    Then Validate that user is able to get the Authorization token and userId from the Response
    And User creates a product in the website using Create Product API using the "AuthorizationToken" and "UserId"
    Then User validates that the product is created successfully

    Examples: 
      | Keyword             |
      | Create_Product_TC01 |

  @CreateOrder
  Scenario Outline: TC02_Validate User is able create Order successfully using API
    Given The Keword for Validate User is able to login and create order successfully using API is "<Keyword>"
    When User logins to Ecommerce Website using the Login API
    Then Validate that user is able to get the Authorization token and userId from the Response
    And User creates a Order in the website using Create Order API using the "AuthorizationToken" and "ProductId" and "Country"
    Then User validates that the order is created successfully

    Examples: 
      | Keyword           |
      | Create_Order_TC02 |
