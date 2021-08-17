Feature: Login into Application

Scenario Outline: Position test validating login
Given Intitaliaze the browser
And Navigate to "http://www.qaclickacademy.com/" site
And Click on the login link in homepage to land on secure signin page
When User enters <username> and <password> and logs in
Then Verify that user is sccesfully logged in
And Close browser

Examples:
|username							|password		|
|test99@gmail.comm		|123456			|
|testewfew99@gmail.comm		|12346			|