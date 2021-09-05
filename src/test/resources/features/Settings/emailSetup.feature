Feature: Update Email server information


Background: 

		Given I am on the Settings page of TMS
    When I go to the system page
    Then I see the system page
    
  @RegressionTest
  Scenario Outline: Fill the mail server infomation and check connection with message as <messageContent>
    
    When I enter host as <hostname>
    And I enter email password as "Tms_test@123"
    And I enter port as "587"
    And I enter SSL Trust as "mail.davnos.com"
    And I enter user as "tms_test@davnos.com"
    When I click Save
    Then I should see success saving popup having text as "System has been updated successfully."
    When I click on Check Connection button
    Then I should see a popup having text as <messageContent>
   
   Examples: 
      | hostname  				| messageContent |
      | mail.davnos.commm | Unable to connect this Mail server|
      | mail.davnos.com   | Mail server has been NOT connected successfully.    | 
    


