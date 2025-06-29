package basics.stringbuilderbuffer;


//not thread safe
//mutable
//faster thab s buffer as not thred safe

//StringBuilder is a mutable class in java.lang used to modify strings without creating new objects each time.


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
    }
}
