package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MycoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class MyCoursedemyStepdefinitions {
    MycoursedemyPage mycoursedemyPage = new MycoursedemyPage();
    WebDriverWait wait = new WebDriverWait(Driver.getdriver(), Duration.ofSeconds(10));


    @Then("myCourse anasayfa login linkine tiklar")
    public void my_course_anasayfa_login_linkine_tiklar() {
        mycoursedemyPage.loginLinki.click();
    }

    @Then("myCourse kullanici adi olarak {string} girer")

    public void my_course_kullanici_adi_olarak_girer(String verilenEmail) {

        mycoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty(verilenEmail));

    }

    @Then("myCourse password olarak {string} girer")
    public void my_course_password_olarak_girer(String verilenPassword) {

        mycoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty(verilenPassword));

    }

    @Then("myCourse login butonuna basar")
    public void my_course_login_butonuna_basar() {
        mycoursedemyPage.loginButonu.click();

    }

    @Then("myCourse giris yapabildigini test eder")
    public void my_course_giris_yapabildigini_test_eder() {
        Assert.assertTrue(mycoursedemyPage.coursesLinki.isDisplayed());

    }

    @And("myCourse cookies i tiklar")
    public void mycourseCookiesITiklar() {
        mycoursedemyPage.cookies.click();
    }

    @And("myCourse login butonu tiklanabilir olana kadar bekler")
    public void mycourseLoginButonuTiklanabilirOlanaKadarBekler() {

        wait.until(ExpectedConditions.elementToBeClickable(mycoursedemyPage.loginButonu));

    }

    @And("biraz bekler")
    public void birazBekler() throws InterruptedException {
        wait.wait(2000);
    }

    @Then("myCourse giris yapilamadigini test eder")
    public void mycourseGirisYapilamadiginiTestEder() {
        Assert.assertTrue(mycoursedemyPage.loginLinki.isDisplayed());
    }


}
