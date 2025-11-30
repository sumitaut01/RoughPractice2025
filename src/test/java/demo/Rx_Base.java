package demo;

import org.testng.annotations.*;

public class Rx_Base {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("From Rx_Base  @BeforeSuite" );

    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("From Rx_Base  @AfterSuite" );
    }


    @BeforeGroups
    public void BeforeGroups(){
        System.out.println("From Rx_Base  @BeforeGroups" );
    }


    @AfterGroups
    public void AfterGroups(){
        System.out.println("From Rx_Base  @AfterGroups" );

    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("From Rx_Base  @beforeTest" );
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("From Rx_Base  @AfterTest" );
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("From Rx_Base  @beforeClass" );
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("From Rx_Base  @AfterClass" );
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("From Rx_Base  @BeforeMethod" );
    }

}
