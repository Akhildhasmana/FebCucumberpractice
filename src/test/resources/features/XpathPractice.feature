

Feature: Xpath Finding techniques 
 @xpathPractice 
 Scenario: Xpath practice
    Given  User Went to "https://www.hyrtutorials.com/p/add-padding-to-containers.html" homepage
    When User Enter Email address 
    And User Enter Firstname and last name 
    And User Enter password 
    Then User validates entered password 
    And  User Selects a contact from the table
    Then Get the table data 
    And  User Clicks on the Register button 

 