Feature: Create Account

	Scenario: navigate to create account
		Given I navigate to "http://automationpractice.com/index.php"
		And I click the "Sign in" link
		Then I should see the "Create New Account" link

	Scenario: create new account
		Given I click the "Create New Account" link
		And I have an email address
		And I am not previously registered
		Then I should be able to create a new account