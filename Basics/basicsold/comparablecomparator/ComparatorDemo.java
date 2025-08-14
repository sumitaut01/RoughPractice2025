package basicsold.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//we have created separate compator classes below
//with lambdas we can create in one line and muultiple in same class
public class ComparatorDemo {

    public static void main(String[] args) {

        List<StudentDemo> st=new ArrayList<>();
        st.add(new StudentDemo(12,"Sumit"));
        st.add(new StudentDemo(5,"Amit"));
        st.add(new StudentDemo(11,"Neha"));


        System.out.println(st);//[Student{age=12, name='Sumit'}, Student{age=5, name='Amit'}, Student{age=11, name='Neha'}]

        Collections.sort(st,new AgeComparaor());
        System.out.println(st);//[Student{age=5, name='Amit'}, Student{age=11, name='Neha'}, Student{age=12, name='Sumit'}]

        Collections.sort(st,new NameComparaor());
        System.out.println(st);//[Student{age=5, name='Amit'}, Student{age=11, name='Neha'}, Student{age=12, name='Sumit'}]


        //Comparator by Lambda
        Comparator<StudentDemo> byAgeSort = (s1, s2) ->  Integer.compare(s1.age,s2.age);
        Comparator<StudentDemo> byNameSort = (s1, s2) -> s1.name.compareTo(s2.name);




    }
}



class StudentDemo  {
    int age;
    String name;


    StudentDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

//separate class
class AgeComparaor implements Comparator<StudentDemo>{
    @Override
    public int compare(StudentDemo o1, StudentDemo o2) {
        // return o1.age.compareTo(o2.age);//wont work with int
        return  Integer.compare(o1.age,o2.age);
    }
}

class NameComparaor implements Comparator<StudentDemo>{
    @Override
    public int compare(StudentDemo o1, StudentDemo o2) {
        return o1.name.compareTo(o2.name);
    }
}
