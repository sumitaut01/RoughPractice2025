package basics;

public class R16_Overloading_Promotion_3 {
//    Now What About byte, short, char?
//    These types are automatically promoted to int if there's no exact match.
    public static void main(String[] args) {

        R16_Overloading_Promotion_3 ol=new R16_Overloading_Promotion_3();

        byte b=1;
        short s=2;
        char c='C';

        ol.sum(c);//int version
        ol.sum(b);//byte version

    }

    public void sum(int x){
        System.out.println("int version");
    }

    public void sum(byte x){
        System.out.println("byte version");
    }

}



//🔸 Summary: Widening Order in Overloading
//        Type	Widening Promotion Order
//        byte	→ short → int → long → float → double
//        short	→ int → long → float → double
//        char	→ int → long → float → double
//        int	→ long → float → double
//        long	→ float → double
//        float	→ double