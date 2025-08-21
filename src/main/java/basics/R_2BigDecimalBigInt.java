package basics;

import java.math.BigDecimal;

public class R_2BigDecimalBigInt {


    public static void main(String[] args) {

        double a=0.1;
        double b=0.2;

        System.out.println(a+b);//0.30000000000000004 //This happens due to binary floating-point approximation.


        BigDecimal aa = new BigDecimal(0.1);
        BigDecimal bb = new BigDecimal(0.2);
        BigDecimal sum = aa.add(bb);
        System.out.println(sum); // 0.3000000000000000166533453693773481063544750213623046875//still same

        //notice the values in string
        BigDecimal ee = new BigDecimal("0.1");
        BigDecimal ff = new BigDecimal("0.2");
        BigDecimal sum2 = ee.add(ff);

        System.out.println(sum2); // prints 0.3


        //Similarlly there is big int
    }
}
