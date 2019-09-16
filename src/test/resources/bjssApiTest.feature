Feature: Create

  @Test3
  Scenario Outline: Create a user through api
    When I trigger "create" service with below postbody
      | name   | salary   | age   |
      | <name> | <salary> | <age> |
    Then I should see response code as 200
    And I should see response message as "OK"
    And I should see "name" as "<name>" in the response
    And I should see "salary" as "<salary>" in the response
    And I should see "age" as "<age>" in the response
    And I should see "id" is created in the response to indicate User has been created

    Examples:
      | name | salary | age |
      | test | 123    | 30  |