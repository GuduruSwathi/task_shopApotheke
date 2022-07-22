Feature: Login tests
  As Customer B2B2B, I can login to ShopApotheke

  Background: Home page of ShopApotheke
  
  
  Scenario Outline: Valid Login
When user enters "<username>" and "<password>"
And user clicks on login button
And user is on home page
Examples:
	| username | password |
	| swathi0218@gmail.com  | gsr@12 |
	
	
