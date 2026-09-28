package basics.javapgms.citi_preparation.pgms

import org.testng.annotations.Test

import java.util.stream.Collectors
import java.util.stream.Stream

class R2_Streams {

    @Test
    public void first(){


        Stream<String> st=List.of("Sumit","Neha","Hitesh","Amit").stream();
        System.out.println(st.filter(s->s.startsWith("S")).collect(Collectors.toList()));//[Sumit]

        //Remeber , after the terminal operation, stream can be sued again
        //System.out.println(st.map(s->s+"=>"+s.length()).collect(Collectors.toList()));
        //will throw below error
        //java.lang.IllegalStateException: stream has already been operated upon or closed

        Stream<String> st2=List.of("Sumit","Neha","Hitesh","Amit").stream();
        System.out.println(st2.map(s->s+"=>"+s.length()).collect(Collectors.toList()));
        //[Sumit=>5, Neha=>4, Hitesh=>6, Amit=>4]







    }
}
