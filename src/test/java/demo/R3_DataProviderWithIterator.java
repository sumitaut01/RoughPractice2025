package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

//🔑 Important Notes
//DataProvider returns	Test method signature
//Iterator<Map<...>>	(Map<...> param)
//Iterator<Object[]>	(Object... params) or specific parameters
//Object[][]	Similar to above
//
//So your implementation is valid, as long as the test uses the correct argument type.

public class R3_DataProviderWithIterator {

    @Test(dataProvider = "custom")
    public void Test(Map<String, String> map) {
        System.out.println(map);
        //{0=0}
        //{1=1}
    }


    @DataProvider(name="custom")
    public Iterator<Map<String, String>> myMethod() {

        HashMap<String,String> hm=null;
        List<Map<String,String>> lHm=new ArrayList<>();
        for(int i=0;i<2;i++){
          hm=new HashMap<>();
          hm.put(""+i,""+i);
          lHm.add( hm);
        }


        return lHm.iterator();
    }

}
