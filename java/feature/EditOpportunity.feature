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
When Click on edit
When Choose close date as tomorrow date
When Select stage as perception analysis
Given Enter the description as SalesForce
When Click on save button
Given Search for the opportunity
Then Verify the stage as perception analysis