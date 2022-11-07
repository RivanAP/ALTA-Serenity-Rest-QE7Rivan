Feature: Getlist User Resource Feature
  @tugas
  Scenario Outline: : GetList User Resource with valid parameter
    Given GetList user Resource with valid <page>
    When Send Get List user Resource Request
    Then Status code should be 200 ok
   And Response body page Should be <page>
    And Validate Get list resource user json schema

Examples:
  | page |  |
  | 1    |  |


