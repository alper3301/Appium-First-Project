import com.thoughtworks.gauge.Step;
import jdk.internal.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;

public class SepeteEkle extends StepImplementation {
    @Step("Sepete ekle")
    public void addToBasket(){
        boolean sizeGroupDisplayed = appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ozdilek.ozdilekteyim:id/tvInSizeItem']")).isDisplayed();
        boolean standartDisplayed = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvInSizeItem")).isDisplayed();
        boolean gelinceHaberVer = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Gelince Haber Ver']")).isDisplayed();
        if(sizeGroupDisplayed) {
            clickByid("//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout[@index=0]");
            if (gelinceHaberVer) {
                clickByid("//android.widget.TextView[@text='Gelince Haber Ver']");
            }
            clickByid("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");
        }else if(standartDisplayed){
            clickByid("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");
        }
    }
}
