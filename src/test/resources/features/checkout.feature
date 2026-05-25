Feature: I as an user want to pay the products added to cart
    
    Scenario: Sucessful checkout
        Given I am a logged user in the cart page
        When I enter the card information
        Then I can see an order placed confirmation message

    Scenario: Failed checkout due to user is not logged in
        Given I am a not logged user in the cart page
        When I try to checkout
        Then I see a message asking for login to can buy
    
    Scenario: Empty cart
        Given I have not added any products to the cart
        When I select the cart
        Then I see a message of cart empty