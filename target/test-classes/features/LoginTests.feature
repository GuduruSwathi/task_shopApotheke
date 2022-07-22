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
	
	
Scenario Outline: Invalid Login
When user enters "<username>" and "<password>"
And user clicks on login button
And user gets error message
Examples:
	| username | password |
	|   | gsr@12 |
	| swathi0218@gmail.com  | gsr@12 |

Scenario Outline: Change Password
When user enters "<username>" and "<password>"
And user clicks on login button
And user is on home page
And user click on change password
And user enters new "<newpassword>" and "<password>"
And user logouts and login
And user enters "<username>" and "<newpassword>"
And user clicks on login button
And user is on home page
Examples:
	| username | password | newpassword |
	| swathi0218@gmail.com  | gsr@12 | swathi12|
	