Feature: I as an user, want to add products to the cart to can buy

    Background:
        Given I am a registed user

    Scenario Outline: Add various products
        Given I am in the products page
        When I add <quantity> different products to cart
        Then I can see the <quantity> different products in the cart

    Examples:
        |quantity|
        |1       |
        |3       |
        |5       |

    Scenario Outline: Modify the quantity for a product
        Given I have selected a product
        When I change the quantity of a product to <quantity>
        And add the product to cart
        Then I see the product <quantity> times in the cart

    Examples:
        |quantity|
        |2       |
        |4       |
        |6       |

    
    Scenario Outline: Add multiple times the same product
        Given I am in the products page
        When I add a product to cart <quantity> times
        Then I can see the product and correct quantity in the cart

    Examples:
        |quantity|
        |2       |
        |4       |
        |6       |