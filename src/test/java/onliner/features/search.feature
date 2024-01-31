Feature: Onliner Search

  Background:
    Given Onliner Main page is opened

  Scenario: Search for Samsung TVs within specified criteria
    When I click 'Каталог' in header menu on Main page
    And I select 'Электроника' in main menu, select 'Телевидение' in sub menu and select 'Телевизоры' on Catalogue page
    And I write price before 1500.0 and select filters on Product TV page
      | Samsung   | Производитель |
      | 1920x1080 | Разрешение    |
      | 40        | Диагональ     |
      | 50        | Диагональ     |
    Then I verify that price is less than 1500.0
    And I verify that product is only 'Samsung'
    And I verify that resolution is only '1920x1080'
    And I verify that  diagonal is between 40 and 50