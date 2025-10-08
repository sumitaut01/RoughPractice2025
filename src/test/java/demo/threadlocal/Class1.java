package demo.threadlocal;

import org.testng.annotations.Test;

public class Class1 {

    @Test
    public void run(){

        for (int i=0;i<5;i++){
            Parent.setCommon("Sumit"+i);

            System.out.println(Parent.getCommon());
        }
    }
}
