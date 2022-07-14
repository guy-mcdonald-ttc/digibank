@ui @account @savings
Feature: QuickSave (UI)
 As a DigitalBank user
 I want to setup regular saving with QuickSave
 So I can save up for my dream


@negative
Scenario: QuickSave can be ordered
  Given Carleen is logged into the application with Carleen6231@gmail.com
  And they attempt to open a new 'Savings Account'
    When Carleen enters 'Tangerine Savings' into the Account Name field
    And they select 'Individual' from the Ownership radio button
    And they select 'Money Market' from the Account Type radio button
    And they enter '2500' into the Money Market Initial Deposit field
    And they click the Submit button
  And they attempt to use QuickSave
  And they select account number '1' as the quick save to account
  And they enter '11' into the quick save amount field
  And they submit the quick save form
  Then Carleen verifies the order was placed
