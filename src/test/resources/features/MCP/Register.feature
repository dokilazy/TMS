

Feature: Register new account 


Background: 
    Given I am on the M2 Homepage
    When I go to M2 sign in page
    When I click Create an account in Sign in page
    Then I see the Registry page displayed
  
  @SmokeTest  
  Scenario: Registry a new account
  
  And I enter random first name and lastname
  And I enter random email
  And I enter password and confirm password
  And I enter orginazation Name
  And I click Create an account in Registry page
  Then I see a message for asking active account
  
  When I active account in mail box by open mail subject as "Verify your email for"
  Then I should see mail has been verified success message
  Then I can login by the registry account
  And I see correct account information in my profile
  
    
	@CreateData  
  Scenario: Registry multiple accounts
  
  When I Registy multi Users 2