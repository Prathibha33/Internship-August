Feature: Edit opportunity

Scenario: Positive Edit the legal entity


Given Enter the username 'prathi@testleaf.com'
And Enter the password as 'Supradi3149'
When Click on the login button
Then Verify the login
When Click on toggle menu
And Click on view all
And Click on sales
And Click on opportunity tab
Given Enter name in the search bar as 'Salesforce Automation by Prathibha'
When Click on the dropdown
And Choose delete option
And Click on delete
Then Verify the toaster message is 'deleted' for 'opportunity'