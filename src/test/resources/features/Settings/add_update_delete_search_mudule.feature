#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: As an admin
  I want to add, update, delete and search modules at the settings page

  Scenario: Add a new core module
  
 	Given I am on the Settings page
  #  When I am on the Settings page
  When I go to the module page
  Then I see the module page
  When I click add new module
  When I select module name 
  When I enter SKU
  
  #
  #@tag1
  #Scenario: Add a new HEM module

  
  