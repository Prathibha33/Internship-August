Feature: Edit opportunity

Scenario: Positive Edit the legal entity

Given Initialize the driver
Given Enter the username
Given Enter the password
When Click on the login button
Then Verify the login
When Click on toggle menu
When Click on view all
When Click on sales
When Click on opportunity tab
Given Search for the opportunity
When Click on opportunity dropdown
When Choose delete option
When Click on delete
Then Verify the opportunity is deleted