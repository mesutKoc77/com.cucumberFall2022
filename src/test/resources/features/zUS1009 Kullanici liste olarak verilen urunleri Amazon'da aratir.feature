Feature: Kullanici verilen Urunleri amazon'da aratir

  Scenario Outline: Kullanici liste olarak verilenleri ilgili sitede aratir
    Given Kullanici "amazonUrl" anasayfaya gider
    Given Kullanici "<aranacakIfadeler>" aratir
    Then Arama sonuclarinin "<aranacakIfadeler>" icerdigini test eder
    And Sayfayi kapatir
    
    Examples: 
    |aranacakIfadeler      |
    |     Laptop            |
    |      Mouse          |
    |      Klavye         |
    |      Pencil         |
    |      Lego            |

