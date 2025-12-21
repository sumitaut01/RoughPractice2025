package basics;

import myproject.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Rough {


    @Test
    public void Rough1() {


        Implementor imp = new Implementor(12, 22);
        imp.withDraw();

        DummyAbstract r = new Implementor(22, 333);

        r.withDraw();

    }


    @Test
    public void Rough2EnvEnum() {


        System.out.println(ENV.valueOf("QA"));

        System.out.println(ENV.QA.getEnv());

    }


    @Test
    public void RoughRegex() {

        String str = "tjis12isl6ove";

        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(str);

        while (m.find()) {
            System.out.println(m.group()); //1 2 6
        }
    }


    @Test
    public void RoughArray() {


        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8}};

//1
        for (int[] a : arr) {

            for (int i : a) {

                System.out.print(i + " ");
            }
            System.out.println("");
        }


//1 2 3
//4 5 6
//7 8

        //2

        System.out.println("--Separator----");
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }



    @Test
    public void Rogh181201(){

        System.out.println("hi");

        HashMap<Character,Integer> hm=new HashMap<>();
        hm.put('c', 1);
        hm.put('h', 3);
        hm.put('x', 30);
        hm.put('d', 5);

        int maxCount=0;
        String output="";

       //Method 1//x=30
        System.out.println(hm.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).get(hm.size()-1));


        //
        System.out.println("second----");
        maxCount=0;
        String result="";
        for( Character s: hm.keySet()){
            if(hm.get(s)>maxCount){
                maxCount=hm.get(s);
                result= s+" "+maxCount;
            }
        }
        System.out.println(result); //x=30

    }


    @Test
    public void Rough(){
        TreeMap<Character,Integer> tm=new TreeMap<>();
        tm.put('c', 10);
        tm.put('f', 1);
        tm.put('a', 1);

        System.out.println(tm);//{a=1, c=10, f=1}

    }


    @Test(dataProvider = "data")
    public void DataproviderDemo(String username,String password,Integer sal){
        System.out.println(username + " "+password +" "+sal);

        //sumit pwd 12
        //Amit pwdamt 120
        //sumit pwd 12

    }


    @DataProvider(name="data")
    public Object[][] supply(){

        Object[][] data=
                {
                        {"sumit","pwd",12},
                        {"Amit","pwdamt",120},
                        {"sumit","pwd",12}

                };

        return  data;
    }







 //

    public void RoughStreams(){

     List<Integer> lst=new ArrayList<>();

     lst.add(10);
        lst.add(2);
        lst.add(43);
        lst.add(4000);

        System.out.println(lst);
        Collections.sort(lst);
        System.out.println(lst);
    }


}


abstract class DummyAbstract {

    int age;
    static int salary;

    public abstract void withDraw();

    public void nonAbstract() {

        System.out.println("this is non abstract");
    }

    public DummyAbstract(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }

}

class Implementor extends DummyAbstract {


    public Implementor(int age, int salary) {
        super(age, salary);
    }

    @Override
    public void withDraw() {
        System.out.println("implemented");
    }
}


//Chater 2

class Runner {


    //DriverManager
}


class DriverManager {


    public static WebDriver getDriverInstance(BrowserType browserType) {

        if (browserType == BrowserType.CHROME) {
            return new ChromeDriver().getDriver();
        } else if (browserType == BrowserType.FIREFOX) {
            return new FireFoxDriver().getDriver();
        } else {

            return new ChromeDriver().getDriver();

        }

    }


}


enum BrowSerType {
    CHROME,
    FIREFOX
}

class ChromeDriver implements IDriver {
    @Override
    public WebDriver getDriver() {
        return (WebDriver) new ChromeDriver();
    }
}

class FireFoxDriver implements IDriver {
    @Override
    public WebDriver getDriver() {
        return (WebDriver) new FirefoxDriver();
    }
}

interface IDriver {
    public WebDriver getDriver();

}

//chapter env
enum ENV {
    QA("qa.com"),
    UAT("uat.com");
    private String env;

    ENV(String data) {
        this.env = data;
    }

    String getEnv() {
        return this.env;
    }

}





