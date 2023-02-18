package sel_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ama_sotr_01
{
    public static void main(String[] arg)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        WebElement mobiles = driver.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']"));
        mobiles.click();

        WebElement brand = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[5]/ul/li[1]/span/a/span"));
        brand.click();

        List<WebElement> list=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        int count=1;
        if(list.size()!=0)
        {
         for(int i=0;i< list.size();i++)
         {
             WebElement element=list.get(i);
             String amount=element.getText();

             int a1=Integer.parseInt(amount.replaceAll("[^0-9]","").toString());
             //System.out.println(a1);

             if(a1<500)
             {
                 String title=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();

                 System.out.println("title:"+title);
                 count++;
             }
         }

        }







    }

}
//    List<String>  store_value=new ArrayList<String>();
//        for (WebElement p1:price)
//                {
//                store_value.add(p1.getText());
//                String price1=p1.getText();
//                System.out.println(price1);
//                }