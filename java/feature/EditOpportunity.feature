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
And Click on edit option
And Choose close date as tomorrow date
And Select stage as perception analysis
Given Enter the description as SalesForce
And Click on save button
Given Enter name in the search bar as 'Salesforce Automation by Prathibha'
Then Verify the stage as perception analysis