package basics.enums;

public class Rough {

    public static void main(String[] args) {

        String curr="pass";

        TEST currEnum=TEST.valueOf(curr.trim().toUpperCase());

        switch (currEnum){
            case PASS -> System.out.println("passed");
            case FAIL -> System.out.println("fail");
            default -> System.out.println("general");
        }


    }
}


enum TEST{
 PASS,
    FAIL,
    SKIP
}
