Feature: US1004 Parametre Kullanma
  @pt2
  Scenario: TC08 Kullanici parametre ile verilen kelimeyi amazonda aratabilmeli

    Given Kullanici amazon anasayfaya gider
    Then Arama cubuguna "TV" yazip aratir
    And Arama sonuclarinin "TV" icerdigini test eder
    And Sayfayi kapatir

