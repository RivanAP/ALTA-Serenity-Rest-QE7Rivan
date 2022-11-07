Feature: Post Register Feature
  @tugas
  Scenario: Post Register user with vaild json
    Given Post Register user with valid json
    When Send Post Register user request
    Then Response code should be 200
    And Responde body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Validate Register user json schema

    @tugas
    Scenario: Post Register user without email
      Given Post Register user without email json
      When  Send Post Register user request
      Then Response code should be 400 Bad Request
      And Responde body should contain error "Missing email or username"

      @tugas
      Scenario: Post Register user without Password
        Given Post Regiter user without Password json
        When Send Post Register user request
        Then Response code should be 400 Bad Request
        And Response body should contain error "Missing password"

