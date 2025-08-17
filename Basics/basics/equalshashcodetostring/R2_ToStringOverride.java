package basics.equalshashcodetostring;

import lombok.Getter;
import lombok.Setter;

public class R2_ToStringOverride {

    public static void main(String[] args) {
        System.out.println(new Worker());//Worker{age=0, role='null'}
        System.out.println(new Worker(32,"QA"));//Worker{age=32, role='QA'}

    }
}


class Worker{
    @Getter
            @Setter
    int age;
    String role;

    public Worker(int age, String role) {
        this.age = age;
        this.role = role;
    }

    public Worker() {
    }


    @Override
    public String toString() {
        return

                "Worker{" +
                "age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
}
