Feature: I as an user, want to register into the platform to can buy

    Background:
        Given 

    Scenario Outline: Sucessful registration
        Given I am in the Signup page
        When I enter the signup information:
            | firstName           | <firstName>           |
            | lastName            | <lastName>            | 
            | password            | <password>            |
            | gender              | <gender>              |
            | dateOfBirth         | <dateOfBirth>         |
        Then I can see an user account created message
        And I am logged in

        Examples: 
            | firstName | lastName | password       | gender | dateOfBirth | 
            | Katerin   | Montoya  | kate&you1485!  |   F    | 2005-11-04  |
            | Andres    | Correa   | grand_Pass84$  |   M    | 2000-06-17  |
            | Emily     | Gonzalez | 3m1lyPassword# |   F    | 2006-07-20  |
            | Camilo    | Torres   | ki3npass?-me   |   M    | 2004-09-15  | 

    Scenario: Failed registration due to the email already exists
        Given I am in the Signup page
        When I enter an existing email address
        Then I see a message that such email is already registered
    
    Scenario: Failed registration due to unfilled fields
        Given I am in the Signup page
        When I enter incomplete sigunp information
        Then I can see a warning in the first empty field