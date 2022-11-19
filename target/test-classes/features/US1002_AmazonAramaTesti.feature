

Feature: US1002_Amazon Arama Testi
  # Kullanıcının arama yapması için uc seneryo oluşturun.
  # Nutella, Java ve Apple için arama yapıp sonuçların aranan kelime içierdigini test edin

  Scenario: TC02 Kullanici amazonda Nutella aramasi yapar

    Given Kullanici amazon anasayfaya gider
    Then Arama cubuguna Nutella yazip aratir
    Then Arama sonuclarinin Nutella icerdigini test eder
    Then Sayfayi kapatir


  Scenario: TC03 Kullanıcı amazonda Java aramasi yapar
    Given Kullanici amazon anasayfaya gider
    Then arama kutusuna Java yazip aratir
    Then arama sonuclarının Java içerdigini test eder
    And Sayfayi kapatir

  Scenario: TC04 kullanıcı amazonda Apple aramasi yapar
    Given Kullanici amazon anasayfaya gider
    Then arama kutusuna Apple yazip aratir
    Then sonuclarin Apple içerdiigni test eder
    And Sayfayi kapatir