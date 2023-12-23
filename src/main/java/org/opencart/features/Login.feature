Feature: Login Feature Test Suite

  Scenario Outline: An error message is displayed when login is performed with invalid data
    Given the "url" is accessed
    And the following fields from "LoginPage" are populated with data
      | emailInput    | vlada.lungu@gmail.com |
      | passwordInput | ThePassword           |
    When "loginButton" from "LoginPage" is clicked
    Then the following errorMessages are displayed
      | Warning: No match for E-mail Address and/or Password. |
    Examples:
      | Attribute | email             | password  |
      | email     | invalid@gmail.com | nevermind |
      | password  | andrei@gmail.com  | fdsvds    |



  Scenario Outline: A valid user is able to log into the system
    Given the "url" is accessed
    And the following fields from "LoginPage" are populated with data
      | emailInput    | vlada.lungu@gmail.com |
      | passwordInput | ThePassword           |

    When "loginButton" from "LoginPage" is clicked
    Then the current url contains the following keyword: "account "
    Examples:
      | email            | password  |
      | andrei@gmail.com | nevermind |