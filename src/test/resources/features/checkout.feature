Feature: I as an user want to pay the products added to cart
    
    Scenario Outline: Sucessful checkout
        Given I am a logged user
        When I add some products to cart
        And I enter the card information:
            | cardNumber      | <cardNumber>      |
            | cvcCode         | <cvcCode>         |
            | expirationMonth | <expirationMonth> |
            | expirationYear | <expirationYear>  |
        Then I can see an order placed confirmation message

        Examples:
            | cardNumber          | cvcCode | expirationMonth | expirationYear |
            | 0231 1252 1223 2548 | 123     | 10              | 2026           |
            #| 1243 5648 7910 1115 | 249     |  8              | 2028           |
            #| 5484 2745 1685 0152 | 354     |  6              | 2027           |

    Scenario: Failed checkout due to user is not logged in
        Given I am a not logged user
        When I add some products to cart
        And I try to checkout
        Then I see a message asking for login to can buy
    
    Scenario: Empty cart
        Given I have not added any products to the cart
        When I select the cart
        Then I see a message of cart empty

    Scenario: Failed Payment due to empty card fields
        Given I am a logged user
        When I add some products to cart
        And I enter incomplete card information:
            | nameOnCard      | <nameOnCard>      |
            | cardNumber      | <cardNumber>      |
            | cvcCode         | <cvcCode>         |
            | expirationMonth | <expirationMonth> |
            | <expirationYear | <expirationYear>  |
        Then I can see a warning for the empty field

        Examples:
            | nameOnCard | cardNumber          | cvcCode | expirationMonth | expirationYear |
            |            | 0231 1252 1223 2548 | 123     | 10              | 2026           |
            #| CARLOS A   |                     | 249     |  8              | 2028           |
            #| FELIPE V   | 5484 2745 1685 0152 |         |  6              | 2027           |
            #| JUAN   Z   | 7423 1245 1253 0454 | 351     |                 | 2027           |
            #| JUANA  C   | 1480 2874 3680 9542 | 615     |  11             |                |
