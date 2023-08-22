@All
  Feature: Login

    @Test1 @Positive @Login
    Scenario: Login Successfully
      Given I am on login page
      When I fill username 'tomsmith' in username inputText
      And I fill password 'SuperSecretPassword!' in password inputText
      And I click login button
      Then I successfully login
      And I quit website


    @Test2 @Negative @Login
    Scenario: Login Error
      Given I am on login page
      When I fill wrong username 'ruben' in username inputText
      And I fill password 'SuperSecretPassword!' in password inputText
      And I click login button
      Then I get error message
      And I quit website