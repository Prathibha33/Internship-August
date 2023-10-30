Feature: Edit the legal entity

Scenario: Positive Edit the legal entity


Given Enter the username 'prathi@testleaf.com'
And Enter the password as 'Supradi3149'
When Click on the login button
Then Verify the login
When Click on toggle menu
And Click on view all
And Click on 'legal entities'
When Click on legal entities tab
Given Enter name in the search bar as 'Salesforce Automation by Prathibha'
When Click on the dropdown
And Click on edit option
And Clear the company name and enter Testleaf
And Clear the description and enter SalesForce
And Click on status dropdown
And Choose the status as Active
And Click on save button
Given Enter name in the search bar as 'Salesforce Automation by Prathibha'
When Click on first displayed legal entity
Then Verify the status as Active



