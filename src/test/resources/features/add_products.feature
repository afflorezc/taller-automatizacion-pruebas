Feature: I as an user, want to add products to the cart to can buy

    Background
        Given I am a logged user

    Scenario: Add various products
        Given I am in the products page
        When I add various products to cart
        Then I can see all the products in the cart 

    Scenario: Modify the quantity for a product
        Given I have selected a product
        When I change the quantity of the product
        And add the product to cart
        Then I see the product and correct quantity in the cart
    
    Scenario: Add multiple times the same product
        Given I am in the products page
        When I add the same product to cart multiple times
        Then I can see the product and correct quantity in the cart