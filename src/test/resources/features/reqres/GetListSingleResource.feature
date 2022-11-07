Feature: Get list Single Resource Feature
  @tugas
  Scenario Outline: Get list Single Resource with valid id
    Given GetList Single Resource with valid <page>
    When Send Get List Single Resource Request
    Then Status code should be 200 ok
    Then Response body page by <page>
    And Validate Get list Single resource json schema
    Examples:
      | page |
      | 2 |

  @tugas
    Scenario Outline: Get list Single Resource Not Found
      Given  Get List Single Resource with invalid <page>
      When Send Get List Single Resource Request
      Then Status code should be 404 Not Found
      And Validate get list single Resorce Not Found json schema
      Examples:
        | page |  |
        | 23   |  |

