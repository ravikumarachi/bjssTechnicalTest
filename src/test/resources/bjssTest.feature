Feature: Technical Test

  @Test1
  Scenario: Confirm that the red button label changes after it's clicked
    Given I goto URL "https://the-internet.herokuapp.com/"
    When I click "Challenging DOM" link
    Then I verify label has been changed after clicking Red button

    @Test2
    Scenario: Confirm 'Hello World!' is rendered after the loading bar disappears
      Given I goto URL "https://the-internet.herokuapp.com/"
      When I click "Dynamic Loading" link
      And I click "Example 2: Element rendered after the fact" link
      And I click on Start button
      Then I should see "Hello World!" text after loading bar disappears


