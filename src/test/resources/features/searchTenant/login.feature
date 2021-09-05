Feature: As a TMS admin user I should be able to login and logout with valid credentials

Scenario: Login into the application with valid credentials
  	Given I am on the Login page
    Then I should see Sign In of TMS Page
    When I enter username of TMS admin
    And I enter password of TMS admin
    And I click on login button
    Then I am logged in TMS
#    And I Click on Sign out
#	Then I got log out from the application and land on sign in page
	
	