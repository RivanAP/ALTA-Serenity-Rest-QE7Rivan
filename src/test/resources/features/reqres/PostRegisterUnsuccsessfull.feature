Feature: Post Register Unsuccsessfull Feature
  @tugas
  Scenario: Post Register User Unsuccsessfull
    Given Post Register user with email json
    When Send Post Register user request
    Then Response code should be 400 Bad Request
    And Responde body should contain error "Missing password"
    And Validate Post Register user json schema