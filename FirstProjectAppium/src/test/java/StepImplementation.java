import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest {


    @Step("<time> saniye bekle")
    public void waitForseconds(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }
    @Step("<id> id'li elemente tıkla")
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "Elemente tıklandı");
    }
    @Step("<Key> xpath'li elemente tıkla")
    public void clickElementByxpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println(xpath + "Elemente tıklandı");
    }

    @Step("<id> id'li elementi bul ve <text> değerini yaz")
    public void sendkeysByid(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }
    @Step("Android klavyeyi kapat")
    public void closeKeyboardonAndroid(){
        appiumDriver.hideKeyboard();
    }

    @Step("sayfa boyunca kaydır")
    public void ScrollRandomPos() {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction(appiumDriver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
    }

    @Step("<Key> xpath'te bulunan sayfadaki bütün ürünleri bul ve rastgele birini seç")
    public void findAllProducts(String Key){
        List<MobileElement> productList = appiumDriver.findElementsByXPath(Key);
        int size = productList.size();
        Random rnd = new Random();
        int randNum = rnd.nextInt(size);
        productList.get(randNum).click();
    }

    @Step("Sayfayı sola kaydır")
    public void swipeLeft(){
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }
    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreacontrol(String id,String text){
        Assert.assertTrue("Element text değerini içermiyor",appiumDriver.findElement(By.id(id)).getText().contains(text));
    }

    @Step("Android klavyeden arama tuşuna bas")
    public void clickSearchbuttonOnadnroidKeyboard(){
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String xpath){
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
    }
}
