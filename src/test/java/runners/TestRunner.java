package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@wip",
        dryRun = false
)

public class TestRunner {
    /*
    *************************"
    once feature da benden istenenleri yazarım
    bu feature in ustune "@wip" tagını eklerim
    buradaki tags ismini de yukarıdaki ile aynı yaparım
    bana eksik olan adımları gostermesi için dryRun ı true yaparim.
    eksikleri bulduktan sonra tekrar dryRun ı false yaparak işlemden çıkarım

    *******************
    daha sonra buraya gelir dryRun i true yaparım
    Bir framework'de bir tek Runner class'i yeterli olabilir
    Runner class'inda class body'sinde hic bir sey olmaz
    Runner class'imizi onemli yapan 2 adet annotaion vardir
    @RunWith(Cucumber.class) notasyonu Runner class'ina calisma ozelligi katar
    Bu notasyon oldugu icin Cucumber framework'umuzde JUnit kullanmayi tercih ediyoruz

    features : Runner dosyasinin feature dosyalarini nereden bulacagini tarif eder
    glue : step definitions dosyalarini nerede bulacagimizi gosterir
    tags : o an hangi tag'i calistirmak istiyorsak onu belli eder

   dryRun : iki secenek var

   dryRun=true; yazdigimizda Testimizi calistirmadan sadece eksik adimlari bize verir
                testi çalıştırmadan eksik adım yoksa test pass yazar
                yani dryRun true demek eksik adim yok demektir.

   dryRun=false yazdigimizda testlerimizi calistirir
                eksik adım varsa ilk eksik adımda çalışmayı durdurdu ve eksik adımları
                bize verir.

     */
}
