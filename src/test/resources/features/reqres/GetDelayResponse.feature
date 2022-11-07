Feature: Get Delay Response Feature
  @tugas
  Scenario Outline: Get Delay Response with valid json
    Given Get Delay with parameter page <page>
    When Send Get Delay user Request
    Then Status code should be 200 Created
    And Response body Page Should be <page>
    And Validate Delay Response json schema
    Examples:
      | page |
      | 1    |
