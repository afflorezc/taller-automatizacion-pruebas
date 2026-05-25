Feature: I as an user, want to buy products

    Scenario: Sucessful registration-purchase complete flow
        Given I am a user that creates a new account in the platform
        When I add products in the cart 
        And place the order
        Then I can see an order placed confirmation message