@ui @search
Feature: ATM Location Search (UI)
  As an authenitcated user
  I want to search for local ATM locations
  so I can find a convenient ATM near me


@negative
Scenario: ATM Location Search with Invalid Zip Code
  Given Pentheus is logged into the application with Pentheus6237@gmail.com
  When Pentheus navigates to the Search page
  And they enter '680083148655' into the Zip Code field
  Then Pentheus verifies they are presented with a validation error message

@negative
Scenario: ATM Location Search with Empty Zip Code
  Given Dominica is logged into the application with Dominica96840@gmail.com
  When Dominica navigates to the Search page
  And they enter '' into the Zip Code field
  Then Dominica verifies they are presented with a validation error message
