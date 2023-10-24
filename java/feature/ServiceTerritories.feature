Feature: Service territories

Scenario: Create service territories


Given Enter the username as 'prathi@testleaf.com'
And Enter the password as 'Supradi3149'
When Click on the login button
Then Verify the login
When Click on toggle menu
And Click on view all
And Click on service territories
And Click on new
Given Enter the name
When Click on operating hours
And Choose the first option
When Check active field
Given Enter the city
And Enter the state
And Enter the state
And Enter the country
And Enter Postal zip code
When Click on save
Then Verify service territory is created


Scenario: Edit service territories


Given Enter the username as 'prathi@testleaf.com'
And Enter the password as 'Supradi3149'
When Click on the login button
Then Verify the login
When Click on toggle menu
And Click on view all
And Click on service territories
And Click on service territory dropdown
And Choose edit
And Get the name alone from created by
And Get the name alone from modified by
And Get the text of the owner
Then Verify owner that matching created by and modified by
Given Change country name to North America
When Click on save
Then Verify last modified date
