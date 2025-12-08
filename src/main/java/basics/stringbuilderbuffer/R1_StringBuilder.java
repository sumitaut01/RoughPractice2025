package basics.stringbuilderbuffer;


//not thread safe
//mutable
//faster than s buffer as not thread safe
//StringBuilder is a mutable class in java.lang used to modify strings without creating new objects each time.

//public final class StringBuilder
//    extends AbstractStringBuilder
//    implements Appendable, java.io.Serializable, Comparable<StringBuilder>, CharSequence

//Common Methods
//        Method	What It Does
//        append()	Adds string to the end
//        insert()	Inserts at a specific index
//        delete()	Removes characters from index range
//        replace()	Replaces characters from-to
//        reverse()	Reverses the string
//        toString()	Converts to regular String
//        setLength()	Truncates or extends the buffer
//        capacity()	Shows current buffer capacity


import org.testng.annotations.Test;

class R1_StringBuilder{
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Smumit");

        System.out.println(sb);//Smumit
        sb.append("sagar");
        System.out.println(sb);////Smumitsagar


        System.out.println(sb.delete(0, 1));
        System.out.println(sb);
        //mumitsagar
        //mumitsagar

        System.out.println(sb.reverse());//ragastimum


        System.out.println(sb.indexOf("Z"));//-1


        System.out.println(sb.insert(0, "A"));//Aragastimum

        System.out.println(sb.delete(1, 100));  //deletes everything





        //rough

        System.out.println("=---Separator-------");
        StringBuilder sbx=new StringBuilder();

        sbx.append("a");//a
        System.out.println(sbx);
        sbx.insert(0,'0');//0a

        System.out.println(sbx);//0a


        System.out.println(sbx.indexOf("g"));//-1


        sbx.delete(0, 1);
        System.out.println(sbx);//a


        sbx.append("bc");

        System.out.println(sbx);//abc
        sbx.reverse();
        System.out.println(sbx);//cba


    }




}
