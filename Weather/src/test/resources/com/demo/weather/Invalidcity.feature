Feature: Invalid city search

  @Invalidcity
  Scenario: Searching InValid city
    Given I open Mozilla
    And I navigate to LoginURL
    And I type mumbaiNavi in city_xpath field
    And I click on searchbutton_xpath
    And I verify the invalidweather_xpath
      
  
      
      
  
     