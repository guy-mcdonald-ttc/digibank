@ui @account @savings
Feature: Transfer Money (UI)
 As a DigitalBank user
 I want to transfer money between accounts
 So I can change how much is in each account


@negative
Scenario: Transfer between the same account is not possible
  Given Carleen is logged into the application with Carleen6231@gmail.com
  And they attempt to transfer money
  When Carleen selects account number '1' as the from account
  And they select account number '1' as the to account
  And they enter '11' into the amount field
  Then Carleen verifies the transfer failed
