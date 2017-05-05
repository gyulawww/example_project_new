Feature: Login Action

Scenario: Successful Login with Valid Credentials
     Given user is on Home Page 'http://www.store.demoqa.com' 
	When User Navigate to LogIn Page
	 And User enters UserName 'ethsig' and Password
	Then Message displayed Login Successfully
	
Scenario: Forward backward
     When User navigate to Sample Page
     Then Navigate to back	
     And User enters UserName 'ethsig' and Password

Scenario: Successful LogOut
	When User LogOut from the Application
	Then Message displayed LogOut Successfully






 
