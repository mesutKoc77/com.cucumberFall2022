package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class Driver {
    private Driver () {
        /*
        singleton pattern konsepti ile driver class ından obje oluşturmayı engellmeke için bu
        constructor ı oluşturduk.
         */
    }
    static WebDriver driver;
    public static WebDriver getdriver(){

        if (driver==null)//method ilk agrıldıgında driver a deger atnamdıgından yeni bir chrome penceresi açılacak ama
        //sonrakiler tabii k i yeni pencere açamayacak.
        {
            String valueOfBrowser=ConfigReader.getProperty("browser");
            switch (valueOfBrowser){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
                    break;
                case "penceresiz chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("window-size=1400,600");
                    options.addArguments("headless");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "penceresiz firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options2=new FirefoxOptions();
                    options2.addArguments("window-size=1400,600");
                    options2.addArguments("headless");
                    driver = new FirefoxDriver(options2);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
 public static void closeDriver(){
       if (driver!=null){

           driver.close();
           driver=null;
       }
 }
}
