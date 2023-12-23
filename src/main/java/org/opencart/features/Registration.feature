Feature: Register Flow Feature File

  @Regression @Smoke
  Scenario: Access the Account Page after successful registration
    Given home Page is accessed
    And "accountIcon" from "HomePage" is clicked
    And "registerBtn" from "HomePage" is clicked
    When the registration form is completed with valid random data
    And "privacyToogle" from "RegisterPage" is clicked
    And "continueBtn" from "RegisterPage" is clicked
    Then the current url contains the following keyword: "register "

  Scenario: User remains on Register Page when continue button is not clicked during tge register flow
    Given home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And "privacyToogle" from "RegisterPage" is clicked
    Then  the current url contains the following keyword: "register "


  @Regression
  Scenario: User remains on Register Page when privacyToogle is not enabled during the register flow
    Given home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And "continueBtn" from "RegisterPage" is clicked
    Then  the current url contains the following keyword: "register "


  @run
  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> date
    Given home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form is completed with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | random      |
      | password  | random      |
    When "continueBtn" from "RegisterPage" is clicked
    Then  the following errorMessages are displayed
      | Warning: You must agree to the Privacy Policy   |
      | <attribute> must be between 1 and 32 characters |
    Examples:
      | attribute  | firstName                            | lastName                             |
      | First Name | dsfdskjcsjdhdfjhdhdshdsdsijdsidudsjc | random                               |
      | Last Name  | random                               | dsfdskjcsjdhdfjhdhdshdsdsijdsidudsjc |

    @execution
  Scenario : Error messages are displayed when trying to register with invalid <attribute> date
    Given home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the following fields from "RegisterPage" are populated with data
      | firstNameInput | Vlada                 |
      | lastNameInput  | Lungu                 |
      | emailInput     | vlada.lungu@gmail.com |
      | passwordInput  | ThePasspwrd           |
    When "continueBtn" from "RegisterPage" is clicked
    Then  the following errorMessages are displayed
      | Warning: You must agree to the Privacy Policy   |
      | <attribute> must be between 1 and 32 characters |
