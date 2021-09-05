Feature: Login page

Background: 
    Given I am on the M2 Homepage
    When I go to M2 sign in page
    
  @SmokeTest  
  Scenario Outline: Login with correct email and password
  
    When I enter email as <email>
    And I enter password for login as <password>
    And I click on Sign In
    Then I see the Home page with name displayed as <fullName>
 
 Examples: 
      | email  | password | fullName  |
      | m2test2@mailinator.com | dmvn@123 | Vu Nguyen |
 
 
  @SmokeTest  
  Scenario Outline: Login with incorrect email or password

    When I enter email as <email>
    And I enter password for login as <password>
    And I click on Sign In
    Then I see an error message as <errorMessage>

    Examples: 
      | email  | password | errorMessage  |
      | nonExistEmail@gmail.com |     dmvn@123 | EMAIL_NOT_FOUND    |
      | m2test2@mailinator.com |     incorrectPass | INVALID_PASSWORD |

   
    @SmokeTest    
    Scenario Outline: Sign out 
  
    When I enter email as <email>
    And I enter password for login as <password>
    And I click on Sign In
    Then I see the Home page with name displayed as <fullName>
    When I click on Sign out
    Then I see signed-out page
    And I see home page after 5s
 
 Examples: 
      | email  | password |  fullName  |
      | m2test2@mailinator.com |     dmvn@123 | Vu Nguyen |
 
