import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PagesControl extends BaseTest{

    @Step("Açılış Sayfasını Kontrol Et")
    public void open() {
        String alisveriseBaslaBtn = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).getText();
    }

    @Step("Alışveriş Sayfasını Kontrol Et")
    public void checkAlisverisSayfasi(){
        String textCheck = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayStore")).getAttribute("resource-id");
    }

    @Step("Kategori Sayfasını Kontrol Et")
    public void checkKategoriSayfasi(){
        String textCheck = appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']")).getAttribute("content-desc");
    }

    @Step("Urun Detay Sayfasını Kontrol Et")
    public void checkUrunDetaySayfasi(){
        boolean checkUrunDetaySayfasi = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/imgCart")).isDisplayed();
    }

    @Step("Login Sayfasını Kontrol Et")
    public void checkLogin(){
        boolean loginButtonVisible = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/btnLogin")).isDisplayed();
    }

}


