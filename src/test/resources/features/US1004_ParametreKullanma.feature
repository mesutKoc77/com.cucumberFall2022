Feature: US1004 Parametre Kullanma

  Scenario: TC08 Kullanici parametre ile verilen kelimeyi amazonda aratabilmeli

    Given Kullanici amazon anasayfaya gider

    Then Arama cubuguna "sony" yazip aratir

    And Arama sonuclarinin "sony" icerdigini test eder

    And Sayfayi kapatir



