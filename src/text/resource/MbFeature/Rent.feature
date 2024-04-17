Feature: To test Find an Agent functionality 
Background:
Given User is on MagicBricks homepage


@City
Scenario: Validate Agent list with applied city filter
Given User is on Agent SRP webpage
And User opens city filter drop down list
And select the city Mumbai
Then It should display Agent list for that city


@HelpInvalid
Scenario Outline: Validate Help Search Functionality with invalid input.
When User is on Help Center webpage
And User provides invalid input "<input>" in search bar
And click on search icon
Then It should display an error message

Examples: 
|input|
|lll|

@HelpValid
Scenario: Validate Help Search Functionality with invalid input
When User is on Help Center webpage1
And User provides valid input in search bar
|login|
Then It should display drop down list relevant to search keyword

@ContactAgent
Scenario Outline: Validate user receives OTP for verification
When Agent List according to the city filter is displayed
And User clicks on Contact Agent button
And provide details "<name>", "<email>", "<phoneno>" in the one time contact form to get details on email
Then user should be able to provide OTP received on registered number.

Examples:
|name|email|phoneno|
|Gauri Vyas|gaurivyas111@gmail.com|8080342627|


@CallBack
Scenario: Validate Service Center CallBack functionality
When User is on Sales Enquiry Webpage
And Click on Request Callback button
And submit the callback form without entering phone number
Then It should give an error message

