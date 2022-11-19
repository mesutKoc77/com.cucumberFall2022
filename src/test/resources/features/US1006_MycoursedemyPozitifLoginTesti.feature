
Feature: US1006 Dogru kullanici adi ve password ile pozitif login testi

  Scenario: TC12 Kullanici mycoursedemy sitesine giris yapabilmeli

    Given Kullanici "myUrl" anasayfaya gider
    And myCourse cookies i tiklar
    Then myCourse anasayfa login linkine tiklar
    And myCourse kullanici adi olarak "myGecerliEmail" girer
    And myCourse password olarak "myGecerliPassword" girer
    And myCourse login butonu tiklanabilir olana kadar bekler
    And myCourse login butonuna basar
    Then myCourse giris yapabildigini test eder
    And Sayfayi kapatir