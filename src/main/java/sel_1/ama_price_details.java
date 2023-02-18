package sel_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ama_price_details
{
    public static void main(String[] arg) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        driver.get("https://www.amazon.in/");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        //click mobiles
        WebElement mobile=driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_mobiles']"));
        mobile.click();

        WebElement brand=driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[5]/ul/li[1]/span/a/span"));
        brand.click();
        while (true)
        {

            WebElement next = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
            next.click();
            Thread.sleep(5000);
            js1.executeScript("window.scrollBy(0,2500)");

            List<WebElement> mobile_list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            List<WebElement> mobile_price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
            System.out.println("details & prices:");
            if (mobile_list.size() != 0 && mobile_price.size()!=0) {
                for (int i = 1; i < mobile_list.size(); i++)
                {
                    for (int j=1;j<mobile_price.size();j++)
                    {
                        WebElement details = mobile_list.get(i);
                        String mobile_details = details.getText();

                        WebElement price=mobile_price.get(j);
                        String p1=price.getText();

                        System.out.println(mobile_details+" : "+p1);

                    }

                }

            }
            try
            {
                next = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
            }
            catch (Exception e)
            {
                System.out.println("no more products");
                break;
            }


        }


    }
}

