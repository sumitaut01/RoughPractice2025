package basics.comparablecomparable.rough;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo {


    public static void main(String[] args) {


        Comparator<Work> xx = (a,b)->a.worker.compareTo(b.worker);


        List<Work> nlst=new ArrayList<>();
        nlst.add(new Work("Sumit",20));
        nlst.add(new Work("Amit",320));
        nlst.add(new Work("Dabar",120));

        System.out.println(nlst);//[Work{worker='Sumit', salary=20}, Work{worker='Amit', salary=320}, Work{worker='Dabar', salary=120}]


    }

}



class Work{
 String worker;
 Integer salary;


    public Work(String worker, Integer salary) {
        this.worker = worker;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Work{" +
                "worker='" + worker + '\'' +
                ", salary=" + salary +
                '}';
    }
}



