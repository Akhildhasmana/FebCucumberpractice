@home_page
Feature: Home Page
  write something about home page

  @ui @bookonline @smoke @sanity @regression
  Scenario: UI Elements of Home Page
    Given I am at home page
    When I click on book a vehicle icon from top bar
    Then Book online page is displayed

  @ui @bookonline @smoke @sanity @regression
  Scenario: Dealer locator icon at Home page
    Given I am at home page
    When I click on dealer locator icon from top bar
    Then Dealer locator page is displayed
    When I click on browser back button
    Then I land to home page
    When I click on browser forward button
    Then I land to Dealer locator page

  @ui @smoke @sanity @regression @alert
  Scenario: Alert at Home page
    Given I am at home page
    Then I see an alert window

  @promptalert
  Scenario: Prompt Alert
    Given I am at https://chercher.tech/practice/practice-pop-ups-selenium-webdriver web app
    When I click on Prompt Alert Box
    Then Prompt alert pops up

  @iframe
  Scenario: Practice Frames
    Given I am at https://chercher.tech/practice/frames-example-selenium-webdriver web app
    Then I enter Test text in the frame1 input box
    And I print main window title

  @windowHandle
  Scenario: Window handle practice
    Given I am at https://demoqa.com/browser-windows web app
    When I click on Open New Window button
    And I switched to new Window
    Then Basic Controls text is visible in new window

  @shop_parts
  Scenario: Shop the parts
    Given I am at home page
    When I hover on Shop tab
    And I click on Accessories
    And I select on tvs apache option from drop down

  #  Different way of achieving the same
  @shop_parts2
  Scenario: Shop the parts
    Given I am at home page
    When I selects Accessories option from Shop tab
    And I select on tvs apache option from drop down
