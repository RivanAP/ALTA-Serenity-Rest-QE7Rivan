Feature: Reqres Features test
  @latihan
  Scenario Outline: Get list user with valid parameter
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 ok
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |
Scenario: Post create new user with valid json
  Given Post create user with valid json
  When Send post create user request
  Then Status code should be 201 Created
  And Response body should contain "Rivan" and "QA Engineer"
  And Validate create list user json schema

  @latihan
    Scenario Outline: Put update user with valid json
      Given Put update user with valid json with id <id>
      When Send put update user request
      Then Status code should be 200 ok
      And Request body should contain name "Rivan Update" and job "QA Update"
      Examples:
        | id |
        | 1  |
        | 2  |
  @latihan
      Scenario Outline: Delete user with valid id
        Given Delete user with id <id>
        When Send delete user request
        Then Status code should be 204 No Content
    Examples:
      | id |  |
      | 2  |  |