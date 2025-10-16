package basics.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringBufferBuilder {

    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder("Sumit");
        sb.append("R");
        System.out.println(sb);//SumitR

        System.out.println(sb.insert(0 ,"A"));
        System.out.println(sb);//ASumitR
        System.out.println(sb.indexOf("Z"));//-1
       // System.out.println(sb.charAt(15));//Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Index 15 out of bounds for length 7


        System.out.println(sb.delete(0, 2));//umitR    Orginal:ASumitR

        System.out.println(sb.reverse());//Rtimu



        //NEither stringbuffer or stringbuilder impleent comparable
        //this is true in open jdk
        //public final class StringBuilder extends Object implements Serializable, CharSequence



//however one we are using corrto has  diffrent
        //public final class StringBuilder
        //extends AbstractStringBuilder
        //implements Appendable,
        //           java.io.Serializable,
        //           Comparable<StringBuilder>,
        //           CharSequence
        List<StringBuilder> lstSv=new ArrayList<>();

        lstSv.add(new StringBuilder("Sumit"));
        lstSv.add(new StringBuilder("Raut"));
        lstSv.add(new StringBuilder("Asmi"));


        System.out.println(lstSv);

        Collections.sort(lstSv);
        System.out.println(lstSv);

//[Sumit, Raut, Asmi]
//[Asmi, Raut, Sumit]




        StringBuffer stringBuffer=new StringBuffer();

        stringBuffer.append(1); //if interger used ,automatically converts to string
        stringBuffer.insert(0, 0);

        System.out.println(stringBuffer);

        System.out.println(stringBuffer.indexOf("z"));

        System.out.println(stringBuffer.charAt(0));
       // System.out.println(stringBuffer.charAt(999)); //StringIndexOutOfBoundsException: Index 999 out of bounds for length 2
        System.out.println(stringBuffer.deleteCharAt(0));
        System.out.println(stringBuffer.reverse());

        System.out.println(stringBuffer.delete(0,2));

        System.out.println(stringBuffer);
        System.out.println("");





    }

}