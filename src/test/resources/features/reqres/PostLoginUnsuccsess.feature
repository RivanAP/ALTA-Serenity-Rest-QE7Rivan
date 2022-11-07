Feature: Post Login Unsuccsess feature
  @tugas
  Scenario: Post Login Unsuccsess with valid json
    Given Post Login Unsuccsess user with valid json
    When Send Post Login user request
    Then Response code should be 400 Bad Request
    And Response body should contain error "Missing password"
    And Validate Post Login Unsuccsss user json schema
