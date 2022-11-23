package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
    test ng projemizde veya junit projemizde her class dan veya method dan once veya sonra
    çalışmasını ıstedigimiz bir method olsaydi
    ya içinde bulundugumuz class da bir @Before.. @After.. oluştururduk
    ya da extends ile bir class ı parent edinip o class a   @Before.. @After.. koyaabilirdik.

    cucumber da çalışacak methodlar bir class la sınırlı degildiir.
    stepdeifinştions package i altındaki tum class lardaki methodlar çalıştırılabailir.

    eger biizm butun testlerimiz için herhangi bir before ve after methoduna ihtiyacimiz varsa
    step definitioons altında herhangi bir class akoymamız yeterli olacaktır.

    Projeler kollektiv calışıldıgından ekipteki herkesin yerini bulabilmesi için
    before ve after methdları kullanılacaksa Hooks
    class ına konulması genel kullanımm olarak benimsenmiştri.
     */
    @After
    public void tearDown(Scenario scenario){

        final byte[] screenshot=((TakesScreenshot) Driver.getdriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
    }
}


