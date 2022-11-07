Feature: Post Login user Succsess Feature
  @tugas
  Scenario: Post Login user with valid json
    Given Post Login user with valid json
    When Send Post Login user request
    Then Response code should be 200
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Validate Post Login user json schema
@tugas
    Scenario: Post Login User Without Email
      Given Post Login user without email
      When Send Post Login user request
      Then Response code should be 400 Bad Request
      And Response body should contain error "Missing email or username"
@tugas
      Scenario: Post Login User Without Password
        Given Post Login user without Password
        When Send Post Login user request
        Then Response code should be 400 Bad Request
        And Responde body should contain error "Missing password"