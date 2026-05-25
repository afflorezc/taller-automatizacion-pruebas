Feature: I as an user, want to register into the platform to can buy

    Scenario: Sucessful registration
        Given I am in the Signup page
        When I enter the signup information
        Then I can see a welcome message

    Scenario: Failed registration due to the email already exists
        Given I am in the Signup page
        When I enter an existing email address
        Then I see a message that such email is already registered
    
    Scenario: Failed registration due to unfilled fields
        Given I am in the Signup page
        When I enter incomplete sigunp information
        Then I can see a warning in the first empty field