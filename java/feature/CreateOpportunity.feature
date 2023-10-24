Feature: Create an opportunity

Scenario: Positive Create an opportunity

Given Initialize the driver
Given Enter the username
Given Enter the password
When Click on the login button
Then Verify the login
When Click on toggle menu
When Click on view all
When Click on sales
When Click on opportunity tab
When Click on new
Given Enter name and get text and store it
When Choose close date as today
When Select stage as need analysis
When Click on save
Then Verify opportunity is created 