Feature: I as an user, want to buy products

    Scenario: Sucessful registration-purchase complete flow
        Given I am a user that creates a new account in the platform
        When I add products in the cart 
        And place the order
        Then I can see an order placed confirmation message
    
    Scenario: Failed view-product-purchase flow
        Given I am an unlogged user that search products
        When I add products in the cart
        And Try to place the order
        Then I see a message of registration needed to can buy

    Scenario: Sucessful view-product-registration-purchase flow
        Given I am an unlogged user that search products
        When I add products in the cart
        And Try to place the order
        And I have to register into the site
        And I place the order again
        Then I can see an order placed confirmation message