

Feature: User registration
  

  @Registration
  Scenario: Title of your scenario
    Given User Went to "https://codenboxautomationlab.com/registration-form/" homepage
    When  User Enters Following user details with coloums
    |Firstname|Lastname|Email|Phone|
    |Akhil|Dhasmana|Akhildhasmana@yopmail.com|7417759723|
    |Rajesh|Pathak|Rajeshpathak@yopmail.com|7417759721|
    |Bhupendra|Mall|Bhupendramall@yopmail.com|7417759722|
    And Select the Course you would like to book 
    And Select the Month of the Batch you would like to join
    And How do you know about us ? 
    Then User clicks on the Register button 

  
