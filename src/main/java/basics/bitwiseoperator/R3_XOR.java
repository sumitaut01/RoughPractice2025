package basics.bitwiseoperator;


/**
 * this is test
 */

//if bits are different then 1
//same bits then 0
//        3   0000000000000011
//        6   0000000000000110
//---------------------------------
// 0101

/**
 * ssssss
 */
public class R3_XOR {
    public static void main(String[] args) {
        System.out.println(3 ^ 6);//5==>0101

        // XOR  ^ on same number will give you 0
        System.out.println(3 ^ 3);//0


        /*

        🔑 XOR properties

a ^ a = 0

a ^ 0 = a

XOR is commutative & associative (order doesn’t matter)
         */





    }


}
