package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class R3_DataProvider {

    @Test(dataProvider = "custom")
    public void Test(String col1,String col2,String col3) {
        System.out.println(col1 +"==>"+col2+"=>"+col3);

        //01firstpapra,==>01secondparam=>02thirdparam
      //11firstpapra,==>11secondparam=>12thirdparam

    }


    @DataProvider(name="custom")
    public Object[][] myMethod() {

        Object data[][] = new Object[2][3];// 2 rows 3 columns. Columns point to paramter
        data[0][0] = "01firstpapra,";
        data[0][1] = "01secondparam";
        data[0][2] = "02thirdparam";
        data[1][0] = "11firstpapra,";
        data[1][1] = "11secondparam";
        data[1][2] = "12thirdparam";
        return data;
    }
}
