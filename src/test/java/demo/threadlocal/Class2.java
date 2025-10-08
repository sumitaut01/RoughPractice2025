package demo.threadlocal;

import org.testng.annotations.Test;

public class Class2 {
    @Test
    public void run(){
        for (int i=0;i<5;i++){
            Parent.setCommon("Neha"+i);
            System.out.println(Parent.getCommon());
        }
    }

}
