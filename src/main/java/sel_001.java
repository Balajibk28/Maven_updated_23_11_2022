import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class sel_001
{
    public static void main(String[] arg)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
        System.out.println("lanched");
        WebElement c1=driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']"));
       for(int i=1;i<5;i++)
       {
           c1.click();
           System.out.println("clicked");

       }
               //*[@id="container"]/div[1]/table/tbody/tr/td/div[1]/a

    }
}
