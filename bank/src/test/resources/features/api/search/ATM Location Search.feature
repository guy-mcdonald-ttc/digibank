@api @search
Feature: ATM Location Search (API)
  As an authenitcated user
  I want to search for local ATM locations
  so I can find a convenient ATM near me


@negative
Scenario: ATM Location Search with Invalid Zip Code
  Given Amina is authenticated into the API with email Amina0648@gmail.com
  When Amina populates the Search request with zipcode equal to '976539926568759'
  And they submit the Search request
  Then Amina verifies the return code is '500'
  And they verify they are presented with a validation error message

@negative
Scenario: ATM Location Search with Empty Zip Code
  Given Hailee is authenticated into the API with email Hailee6019@gmail.com
  When Hailee populates the Search request with zipcode equal to ''
  And they submit the Search request
  Then Hailee verifies the return code is '500'
  And they verify they are presented with a validation error message

