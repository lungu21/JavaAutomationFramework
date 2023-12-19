Feature: Register Flow Feature File

@Regression @Smoke
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


    @Regression
  Scenario: User remains on Register Page when privacyToogle is not enabled during the register flow
    Given home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And continueButton is clicked
    Then the new page url contains "register" keyword