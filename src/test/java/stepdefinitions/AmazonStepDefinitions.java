
package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();

    @Given("Kullanici amazon anasayfaya gider")
    public void kullanici_amazon_anasayfaya_gider() {
        Driver.getdriver().get(ConfigReader.getProperty("amazonUrl"));


    }


    @When("Arama cubuguna Nutella yazip aratir")
    public void arama_cubuguna_nutella_yazip_aratir() {
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


    }

    @Then("Arama sonuclarinin Nutella icerdigini test eder")
    public void arama_sonuclarinin_nutella_icerdigini_test_eder() {
        String sonucElementiText = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "Nutella";
        Assert.assertTrue(sonucElementiText.contains(expectedKelime));
    }

    @Then("Sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();

    }


    @Then("arama kutusuna Java yazip aratir")
    public void aramaKutusunaJavaYazipAratir() {
        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
    }

    @Then("arama sonuclarının Java içerdigini test eder")
    public void arama_sonuclarinin_java_icerdigini_test_eder() {
        String sonucElementiText = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "Java";
        Assert.assertTrue(sonucElementiText.contains(expectedKelime));

    }

    @Then("arama kutusuna Apple yazip aratir")
    public void arama_kutusuna_apple_yazip_aratir() {
        amazonPage.aramaKutusu.sendKeys("Apple" + Keys.ENTER);

    }


    @Then("sonuclarin Apple içerdiigni test eder")
    public void sonuclarin_apple_icerdigini_test_eder() {
        String sonucElementiText = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "Apple";
        Assert.assertTrue(sonucElementiText.contains(expectedKelime));

    }





    @Given("Kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String istenenUrl) {

        Driver.getdriver().get(ConfigReader.getProperty(istenenUrl));
    }

    @Then("url'in {string} icerdigini test eder")
    public void urlInIcerdiginiTestEder(String istenenKelime) {
        String actualUrl = Driver.getdriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
    }


    @Then("arama kutusuna laptop yazip aratir")
    public void aramaKutusunaLaptopYazipAratir() {
        amazonPage.aramaKutusu.sendKeys("laptop" + Keys.ENTER);
    }


    @Then("sonuclarin laptop icerdigini test eder")
    public void sonuclarinLaptopIcerdiginiTestEder() {

        String sonucElementiText = amazonPage.aramaSonucElementi.getText();
        String expectedKelime = "laptop";
        Assert.assertTrue(sonucElementiText.contains(expectedKelime));

    }


    @Then("Arama Cubuguna Tiklar")
    public void aramaCubugunaTiklar() {
        amazonPage.aramaKutusu.click();
    }


    @And("Arama sonuclarinin {string} icerdigini test eder")
    public void aramaSonuclarininIcerdiginiTestEder(String testEdilecekUrunAdi) {
        String aramaSonucumuz = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(aramaSonucumuz.contains(testEdilecekUrunAdi));


    }


    @Then("Arama cubuguna {string} yazip aratir")
    public void aramaCubugunaYazipAratir(String istenenKelime) {

        amazonPage.aramaKutusu.sendKeys(istenenKelime + Keys.ENTER);


    }

    @Given("Kullanici {string} aratir")
    public void kullaniciAratir(String kelime) {
        amazonPage.aramaKutusu.sendKeys(kelime+Keys.ENTER);

    }



}

