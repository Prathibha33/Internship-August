Feature: Edit the legal entity

Scenario: Positive Edit the legal entity

Given Initialize the driver
Given Enter the username
Given Enter the password
When Click on the login button
Then Verify the login
When Click on toggle menu
When Click on view all
When Click on legal entities
When Click on legal entities tab
Given Search for the legal entity
When Click on legal entity dropdown
When Click on edit option
When Clear the company name and enter Testleaf
When Clear the description and enter SalesForce
When Click on status dropdown
When Choose the status as Active
When Click on save button
Given search for the legal entity
When Click on first displayed legal entity
Then Verify the status as Active



