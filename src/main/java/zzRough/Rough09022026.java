package zzRough;


import org.apache.poi.poifs.filesystem.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.*;

public class Rough09022026 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in");
        By links = By.xpath("//a");

        List<WebElement> all = driver.findElements(links);
        for (WebElement qa : all) {
            if (qa.getText().trim().length() > 0)
                System.out.println(qa.getText());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Browserxxx val = Browserxxx.valueOf("CHROME");
        System.out.println(val);


        driver.quit();

    }

    @Test
    public void run(){

        Map<String,String> hm=new HashMap<>();

        hm.put("name", "Sumit");
        hm.put("college", "KITS");
        System.out.println(hm);

       Set<String> ks=hm.keySet();
       for(String s:ks){
           System.out.println(s+ " "+hm.get(s));
       }

       //sout
        System.out.println("Separator---");
       ks.forEach(k-> System.out.println(k +hm.get(k)));



       //map

        Map<String,String> hm1=new HashMap<>();
        Map<String,String> hm2=new LinkedHashMap<>();










        //set
        Set<String> hs=new HashSet<>();
        Set<String> lhs=new LinkedHashSet<>();




        //list


        List<String> ls=new ArrayList<>();

        ls.add("sumit");
        ls.add("neha");
        System.out.println(ls);


        //String s


        String s1="neha";
        String s2="neha";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        String s3=new String("Sumit");
        System.out.println(System.identityHashCode(s3));//30578394


        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());



    }




}


enum Browserxxx{
    CHROME,
    MOZILLA
}


