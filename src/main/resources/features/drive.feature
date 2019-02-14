Feature: Order products
  As an owner
  I want to deducted the number of products accordingly, so that I can know how many of products are left.

  Background:
    Given a product Bread with price 28 with quantity 80 on the shelves
    And a product Jam with price 13.50 with quantity 30 on the shelves

  Scenario: Order small quantity
    When Customer buy Bread with quantity 12
    And Customer buy Jam with quantity 14
    Then a product Bread on the shelves must remain 68 left
    And a product Jam on the shelves must remain 16 left

  Scenario: Order exceed of stock
    When Customer buy Bread with quantity 500
    Then a product Bread on the shelves must remain 80 left