@create-account
Feature: Create Account

	Scenario: navigate to create account
		Given I navigate to "http://automationpractice.com/index.php"
		And I click the "Sign in" link
		Then I should see the "SubmitCreate" button

	Scenario Outline: create new account
		Given I enter "<email>" address into the email field
		And I click the "Create An Account" button
		Then I should be able to create a new account
		
		Examples:
		|email| 
		|newemail1@email.com|