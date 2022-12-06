Feature: JDBC kullanarak yeterli bilgil ile yeterli DataBase testi yapılabilir

  @pazar
  Scenario:JDBC01 kullanici database de sorgu yapabilmeli

    Given Kullanici JDBC ile database'e baglanir
    Then Users tablosundaki isim verilerini alir
    And İsim verilerini test eder
    And first_name sutunun sekizinci satirinin degeri Shannen oldugunu test eder

