package basics;

import org.testng.annotations.Test;

public class R8_StaticBlock_2 {

    static int count = 10;

    @Test
    public void Method1() {

        System.out.println("original count");
        System.out.println(count);

        count++;
        System.out.println("incremented count " + count);

    }

    @Test
    public void Method2() {
        count++;
        System.out.println("again incremented count " + count);

    }


    /*

    original count
10
incremented count 11
again incremented count 12
     */
}