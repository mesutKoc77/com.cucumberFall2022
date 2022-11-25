
Feature: US1003 Background kullanarak amazon arama testi

  Background: amazon anasayfaya gitmek
    Given Kullanici amazon anasayfaya gider

  @pt1
  Scenario: TC05 Kullanici amazonda Nutella aramasi yapar
    Then Arama cubuguna Nutella yazip aratir
    Then Arama sonuclarinin Nutella icerdigini test eder
    Then Sayfayi kapatir


  Scenario: TC06 Kullanıcı amazonda Java aramasi yapar
    Then arama kutusuna Java yazip aratir
    Then arama sonuclarının Java içerdigini test eder
    And Sayfayi kapatir


  Scenario: TC07 kullanıcı amazonda Apple aramasi yapar
    Then arama kutusuna Apple yazip aratir
    Then sonuclarin Apple içerdiigni test eder
    And Sayfayi kapatir