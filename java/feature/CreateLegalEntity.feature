Feature: Create A Legal Entity

Scenario: Positive Create a legal entity

Given Initialize the driver
Given Enter the username
Given Enter the password
When Click on the login button
Then Verify the login
When Click on toggle menu
When Click on view all
When Click on legal entities
When Click on dropdown
When Click on new legal entity
Given Enter name
When Click on save
Then Verify legal entity is created 