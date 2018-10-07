Feature: Logging into openweatherMap

  @Login
  Scenario Outline: Logging into openweatherMap
    Given I open <Browser>
    And I navigate to LoginURL
    And I click on signin_xpath
    And I login inside application
      | Username | thevarselvakumar@gmail.com |
      | Password | Winter123!                 |
    Then login should be <Result>
		Examples: 
      | Browser | Result  |
      | Mozilla | success |
      | chrome  | success |
      
   @Title 
   Scenario: Title
   	    Given I open chrome
   	    And I navigate to LoginURL
   	    And I verify the Title should be ?urrent weather and forecast - OpenWeatherMap
   	
      
      
  
     