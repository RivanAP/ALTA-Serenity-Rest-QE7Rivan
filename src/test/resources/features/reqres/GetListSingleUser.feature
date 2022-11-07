Feature: Getlist Single User Feature Test

  @tugas
  Scenario Outline: Get List Single User With valid parameter
    Given Get list single user with id <id>
    When Send get list single user request
    Then Status code should be 200 OK
    And Response body page mush be <id>
    And Validate get list single user json schema
    Examples:
      | id |
      | 2  |
      | 3  |
    @tugas
    Scenario Outline: Get List Single User With Invalid parameter
      Given Get list single user with invalid id <id>
      When Send get list single user request
      Then Status code should be 404 Not Found
      Examples:
        | id |  |
        | 20 |  |

