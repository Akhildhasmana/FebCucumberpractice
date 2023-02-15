Feature: Mouse action techniques 
 @MouseAction
 
 Scenario: Verify User is able to perform mouse actions 
   
   Given User Went to "https://the-internet.herokuapp.com/challenging_dom#edit" homepage
    When User left clicks on the button
    Then System should display page title 
    
    
    
  @MouseDragAndDrop
  
  Scenario: Drag and drop functionality
  
  Given User Went to "https://the-internet.herokuapp.com/drag_and_drop" homepage  
  Then  User Drag and drop and element
  #And   User Drag and drop using javaScripexecutor