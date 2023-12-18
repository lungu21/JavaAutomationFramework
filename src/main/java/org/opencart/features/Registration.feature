Feature: Register Flow Feature File

  Scenario: Access the Account Page after successful registration
    Given home Page is accessed
    And RegisterPage is accessed from HomePage menu
   When the registration form is completed with valid random data
    And the privacyToogle is enabled
    And continueButton is clicked
    Then the new page url contains "success" keyword

    Scenario: User remains on Register Page when continue button is not clicked during tge register flow
      Given home Page is accessed
      And RegisterPage is accessed from HomePage menu
      When the registration form is completed with valid random data
      And the privacyToogle is enabled
      Then the new page url contains "register" keyword