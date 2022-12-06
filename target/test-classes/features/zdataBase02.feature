Feature: Kullanici tablo adi ile sorgulama yapabilmeli
  @sali3
  Scenario: Kullanıcının email sutununu doldurarak sorgulama yapabilmeli

    Given Kullanici JDBC ile database'e baglanir
    Then id si 10 olan kisinin "email" degerinin "jsnepp9@ihg.com" oldugunu test eder