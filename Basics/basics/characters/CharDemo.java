package basics.characters;

public class CharDemo {

//    What is char?
//    char is a primitive data type, takes 2 bytes.

    //    char c = 'A';
//✅ 2. Internal Representation
//    Each char is actually stored as an integer (Unicode code point).
//            'A' is 65, 'a' is 97, '0' is **48`.
//    char c = 'A';
//    int code = c;  // implicitly converted to int
//System.out.println(code); // 65
    public static void main(String[] args) {


        char a = 67;//possible
        System.out.println(a);//C

        a++;
        System.out.println(a);//D

        a += 10;
        System.out.println(a);//N

        int b = a;
        System.out.println(b);//78


//        char[] and String in Java
//✅ 1. String is Not a Primitive
//        String is a class in java.lang.
//                Internally, a String is a sequence of char values.
//        It is immutable — cannot be changed after creation.

        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str = new String(chars);  // Converts char[] to String
        System.out.println(str); // Hello


        String s="sumit";

      char []arrCh=  s.toCharArray();




        char c = 'A';
        char hindi = 'क';
        char emoji = '\uD83D'; // part of surrogate pair for 😊

        System.out.println("Char: " + c + " | Size: " + Character.BYTES + " bytes");
        System.out.println("Hindi Char: " + hindi);
        System.out.println("Unicode of A: " + (int)c);
        System.out.println("Unicode of क: " + Integer.toHexString(hindi));



    }
}
