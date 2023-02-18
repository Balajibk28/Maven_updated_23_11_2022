package sel_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ama_page_02
{
    public static void main(String [] arg) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        driver.get("https://www.amazon.in/");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        //Step1- click mobile
        WebElement mobiles = driver.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']"));
        mobiles.click();


        WebElement brand = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[5]/ul/li[1]/span/a/span"));
        brand.click();

        js1.executeScript("window.scrollBy(0,3000)");

        //next button click
        while (true)
        {
            WebElement next = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
            next.click();
            Thread.sleep(5000);
            js1.executeScript("window.scrollBy(0,2500)");

            List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            List<String> products = new ArrayList<String>();
            for (WebElement names : list)
            {
                products.add(names.getText());
                String prd = names.getText();
                System.out.println(prd);


            }
            try
            {
                next = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));

            } catch (Exception e) {
                System.out.println("no more products");
                break;
            }


        }
        while(true)
        {
            Thread.sleep(5000);
            js1.executeScript("window.scroll(0,0)");
            Thread.sleep(5000);
            js1.executeScript("window.scrollBy(0,2500)");

            WebElement previous = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-previous s-pagination-button s-pagination-separator']"));
            js1.executeScript("arguments[0].scrollIntoView(true);", previous);
            previous.click();
            Thread.sleep(3000);

            try
            {
                previous = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-previous s-pagination-button s-pagination-separator']"));

            } catch (Exception e) {
                System.out.println("no more page");
                break;
            }

        }
    }
}













//            try
//            {
//                previous = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-previous s-pagination-button s-pagination-separator']"));
//
//            } catch (Exception e) {
//                System.out.println("no more page");
//                break;
//            }
