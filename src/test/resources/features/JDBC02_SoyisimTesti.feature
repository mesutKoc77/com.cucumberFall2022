Feature: JDBC02 kullanici id ile soyisim testi yapar

  Scenario: TC02 Kullanici id girerek soyisim testi yapabilmeli

    Given Kullanici JDBC ile database'e baglanir
    Then id si 14 olan kisinin "last_name" degerinin "Pymar" oldugunu test eder
    # int lari cift tırnaga almaya gerek yok