package basics;

public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {

        X o1 = new X(12,1000);
        X o2=(X)o1.clone();

        System.out.println(o1);
        System.out.println(o2);
        //X{name=12, salary=1000}
        //X{name=12, salary=1000}

        o2.salary=2000;
        System.out.println(o1);
        System.out.println(o2);
        //X{name=12, salary=1000}
        //X{name=12, salary=2000}

    }
}


class X implements Cloneable {
    int name;
    int salary;

    Add add;

    public X(int name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public X(int name, int salary, Add add) {
        this.name = name;
        this.salary = salary;
        this.add = add;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();   // <--- shallow copy
    }

    @Override
    public String toString() {
        return "X{" +
                "name=" + name +
                ", salary=" + salary +
                '}';
    }



}

class Add{

  int add;


    public int getAdd() {
        return add;
    }

    public void setAdd(int add) {
        this.add = add;
    }
}
