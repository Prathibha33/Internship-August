Feature: Create an opportunity

Scenario: Positive Create an opportunity


Given Enter the username 'prathi@testleaf.com'
And Enter the password as 'Supradi3149'
When Click on the login button
Then Verify the login
When Click on toggle menu
And Click on view all
And Click on sales
And Click on opportunity tab
And Click on new
Given Enter 'name' as 'Salesforce Automation by Prathibha'
When Choose close date as today
And Select stage as need analysis
When Click on save
Then Verify the toaster message is 'created' for 'opportunity' 