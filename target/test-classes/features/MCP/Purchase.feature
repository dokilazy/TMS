@tag
Feature: Title of your feature
  I want to use this template for my feature file

Background:
Given I am on the M2 Homepage

  @SmokeTest
  Scenario: Buy new an AlertFlow product
  When I sign in the page by email as "m2test2@mailinator.com" and password as "dmvn@123"
  When I add to cart the AlerFlow product
  Then I see the Add to cart page
  When I click on Custommize button
  Then I see Customization area
  When I click on Add to Cart 
  Then I see the product added to shopping cart
  When I click on Proceed to Checkout
  
  @RegresionTest
  Scenario: Buy AlertFlow without Login
  When I add to cart the AlerFlow product
  Then I see the Add to cart page
  When I click on Custommize button
  Then I see Customization area
  When I click on Add to Cart 
  Then I see the product added to shopping cart
  When I click on Proceed to Checkout
  
  
#  Scenario: Buy more license for AlertFlow
  
  Scenario: Buy new an AIM product
  
  
  
  
  
  
  
  
  
  
  
  
  
 # Scenario: Buy more license for AIM

  
  
  
  