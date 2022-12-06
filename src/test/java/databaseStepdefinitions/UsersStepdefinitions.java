package databaseStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;

public class UsersStepdefinitions {
    /*
    bir database e baglanmak ve o database deki tablolarda işlem yapabilmek için
    öncelikle sistem yoneticisiyle gorusup gerekli bilgileri almalıyız.

        Domain ve IP : sql748.main-hosting.eu ya da 82.180.174.52
        Port : 3306
        Veritabanı : u480337000_jdbc_data
        Kullanıcı Adı : u480337000_jdbc_user
        Parola : 4Ob8Y]DJU/f
        Tablo : users
        Users Tablosu Alanlar : id,first_name,last_name,email,gender,birth_date,ip_address,
                               is_customer,customer_number,status
        database turu : mySql

        1- ilk adım olarak dataBase turune uygun JDBC dependency sini pom a eklemeliyiz
        2- database turune uygun olarAK url, username ve password hazırlanmalı
        3-database baglantısı, query çalıştırma ve dönen sonucu kaydetmek için
        variable'lar oluşturulur
        4- ve test adımlarına uygun ilerlenebilir.



     */
    String url = "jdbc:mysql://sql748.main-hosting.eu:3306/u480337000_jdbc_data";
    String username = "u480337000_jdbc_user";
    String password = "4Ob8Y]DJU/f";

    Connection connection;//database'e baglantiyi saglayacak
    Statement statement;//database de istediigimiz sorgu yu yani queryleri çalıştırmamızı saglar.
    ResultSet resultSet;//statement ile yapılan sorgu sonucunu store etmek için kullanılır.


    @Given("Kullanici JDBC ile database'e baglanir")
    public void kullanici_jdbc_ile_database_e_baglanir() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //bu statement, sorguyu yapacak objedir.
    }

    @Then("Users tablosundaki isim verilerini alir")
    public void users_tablosundaki_isim_verilerini_alir() throws SQLException {
        //connection ilk adimda kuruldu...(yani database e baglandık)====connection objesi ile
        //query leri çalıştıracıgımız objesi de ilk adımda oluşturuldu. (isteklerimizi ilettik)====statement objesi ile
        //şimdi ise once String olarak sorgu hazırlayıp sonra statement objesini kullanrak query i çalıştıracagz
        /////====statement objesi ile
        //...(isteklerimizi aldik)
        //ve dönen sonucu ResultSet objesine store edecegız.
        // (ve onu bir set in içerisine kaydettik.)

        //ben burada users tablsoundaki isim fieldini istiyorum.


        String query = "SELECT first_name FROM users"; //yani users tablosundan isim field ini bana getir.
        resultSet = statement.executeQuery(query);

    }

    @Then("İsim verilerini test eder")
    public void i̇sim_verilerini_test_eder() throws SQLException {
        //ilk iki adımda gerekli java sql objelerinmi oluşturudjk
        //connection ile baglantıyı hazırladık
        //statement a connection uzerinden sorgu yapma ozellkleirini yukledık
        //statement objesini kullanrak istedigimiz database sorgusunu çalıştırıp
        //sonucları resultSet objesine store ettik

        //yani şuan da elimizde 1000 adet isim barıncırıran resultSet objesi var
        //bu objeyi kullanrak istedigimiz isim bilgilerine ulaşabailir
        //istedigimiz testleri yapabiliriz

        //ilk ismi yazdiralim

        /*
        resultSet iterator ile çalışır.
        */

        resultSet.first(); //yani ilk satirdakileri tuttu ve bana first_name sutununu getirdi.
        System.out.println("first_name =" + resultSet.getString("first_name"));

        //ikinci ve ucuncu isismleri yazdırsak?

        resultSet.next();//2.
        System.out.println("first_name =" + resultSet.getString("first_name"));

        resultSet.next();//3.
        System.out.println("first_name =" + resultSet.getString("first_name"));

        //11. satırdaki ismin traver oldugunu test edelim7


        resultSet.absolute(11);//11. satirda tuttuk

        String actual11inciIsim = resultSet.getString("first_name");//11. satirda iken first_name

        String expected11inciIsim = "Trever";

        Assert.assertEquals(expected11inciIsim, actual11inciIsim);


        //son ismin Jaime oldugunu test edelim

        resultSet.last();//son da dur. sonuncu satirin first_name bolgesinde dur

        String actualsonuncuIsim = resultSet.getString("first_name");
        String expectedSonuncuIsim = "Jaime";
        Assert.assertEquals(expectedSonuncuIsim, actualsonuncuIsim);

        //tum isim listesini yazdıralım

        System.out.println("============================");

        resultSet.absolute(0);//0. satıra aldım cunku ilk next i gordugunde bir yana kayacaktir.

       int siraNo = 1;

        while (resultSet.next())//bir yana kaydı ve ilkini gorup yazdırdı. sonra sordu, bir sonrası var mi diye
        //eger varsa yani true ise o zaman aşağıyı yazdırdı. bir sonrakisi olmayınca false olacak ve loop
        //kırılacak
        {
            System.out.println("siraNo=" + siraNo + ": " + resultSet.getString("first_name"));
           siraNo++;
        }
        resultSet.absolute(10);





    }

    @Then("id si {int} olan kisinin {string} degerinin {string} oldugunu test eder")
    public void id_si_olan_kisinin_degerinin_oldugunu_test_eder(Integer id, String sutun_adi, String ilgiliDeger) throws SQLException {

        String talebim = "SELECT " + sutun_adi + " FROM users WHERE id=" + id;
        resultSet = statement.executeQuery(talebim);
        resultSet.first();
        //buraya first tanımlanmasının nedeni; resulSet bize bir Set yani birden fazla deger dondutyormuş gibi
        //düşünüp bu degeri yani first u getir demeliyiz.
        String actualemail = resultSet.getString(sutun_adi);
        Assert.assertEquals(actualemail, ilgiliDeger);


    }

    @Then("id degeri {int} olan kisinin {string} degerini {string} yapar")
    public void idDegeriOlanKisininDegeriniYapar(int id, String fieldName, String istenenDeger) {

        String query = "UPDATE u480337000_jdbc_data.users SET " + fieldName + "='" + istenenDeger + "' WHERE id=" + id;
        System.out.println(query);
        //bu update, result set dondurmjuyor ondan dolayı try catch almalı.
        //yukarıdaki throws degil try catch ile sarmalıcazo
        try {
            statement.execute(query);
            //resultSet dondurmeyen sorgularda executeQuery yerine execute kullanılmadlırd.

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());

            System.out.println("yapılan sorgu result set dondurmuyor");
        }


    }


    @And("first_name sutunun sekizinci satirinin degeri Shannen oldugunu test eder")
    public void first_nameSutununSekizinciSatirininDegeriShannenOldugunuTestEder() throws SQLException {

        resultSet.absolute(8);
        String expectedFirstName="Shannen";
        String actualFirstName=resultSet.getString("first_name");
        Assert.assertEquals(expectedFirstName,actualFirstName);

    }
}
