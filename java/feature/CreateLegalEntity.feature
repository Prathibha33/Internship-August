Feature: Create A Legal Entity

Scenario: Positive Create a legal entity


Given Enter the username as 'prathi@testleaf.com'
And Enter the password as 'Supradi3149'
When Click on the login button
Then Verify the login
When Click on toggle menu
And Click on view all
And Click on 'legal entities'
And Click on dropdown
And Click on new legal entity
Given Enter 'name' as 'Salesforce Automation by Prathibha'
When Click on save
Then Verify the toaster message is 'created' for 'legal entity'