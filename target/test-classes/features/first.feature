@tag1

  Feature: Test Login functionality of AutomationExercise

    Scenario: Test the Valid Login
      Given user is on login page
      When user enters valid id and password
      And click on login button
      Then user should land on home page