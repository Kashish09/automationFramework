@tag1

  Feature: Test Login functionality of AutomationExercise
    Scenario: Login into AutomationExercise, Search tshirts, remove one from cart and proceed to checkout, Enter the Card details, pay and download the invoice
      Given user is on login page
      When user enters valid id and password
        | qwerty123@example.com | qwerty123 |
      And click on login button
      Then user should land on home page


      When user go to Product Page
      And search tshirts
        | tshirts |
      And add two tshirts to cart
      Then user is able to remove one tshirt
      And user is able to proceed to checkout and place the order


      When user is redirected to Payments page after placing order
      Then user is able to fill the card details
      And user is able to click the Pay and Confirm button
      And user downloads the invoice


