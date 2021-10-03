Feature: Search And Product in Cart
 @test
  Scenario: Validate Searching of Prodcut and Adding in Cart
    Given I open Flipkart Website
    And Click on X Button  
    Then Click and Search in Top Search Box
    | Java Programming Books |
    When Click Item from the Searched Result
    | Java - The Complete Reference |
   And Switch Another Window 
   And Click Add to Cart Button
   Then Validate Item added in Cart Succesfully