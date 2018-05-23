#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@functionaltesting
Feature: Cyclos application
  I want to perform login and search scneario in the Cyclos application


 @testmandatory1
 Scenario Outline: validation of multiple Login page in cyclos application
    Given I want to enter valid "<username>" and "<password>"
    And click on Sign In button
    Then the login should be sucessfull

    Examples: 
      | username | password |
      | demo     |     12345 |
      | demo2    |     12345 |
      | demo3    |     1234 |

    @testmandatory
  Scenario: validation of transaction account details of the members
    Given I want to enter into the cyclos application with valid "demo" and "1234"
    When I click on member account balance field
    Then Member account transaction details page should be displayed
