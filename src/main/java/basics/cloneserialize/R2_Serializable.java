package basics.cloneserialize;

import org.testng.annotations.Test;

import java.beans.Transient;
import java.io.*;

// add transient field as well which wont get serialized
public class R2_Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyClass obj1 = new MyClass(12, 1200, 15);

        System.out.println("Object Crated");
        System.out.println(obj1.toString());
        //Object Crated
        //MyClass{batch=12, collegeCode=1200 privatefiled 15}


        //below line possible only because MyClass implements Serializable
        // //Serialize- Writing Object State
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("MyClass.ser"));
        objectOutputStream.writeObject(obj1);
        objectOutputStream.close();


        //Deserialize
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("MyClass.ser"));
        MyClass obj2 = (MyClass) objectInputStream.readObject();
        System.out.println("Object Deserialized");
        System.out.println(obj2.toString());
        //Object Deserialized
        //MyClass{batch=12, collegeCode=1200 privatefiled 0}


    }


    @Test
    public void rough() throws IOException, ClassNotFoundException {

        MyClass myClass = new MyClass(10, 10, 10);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("right.ser"));
        outputStream.writeObject(myClass);


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("right.ser"));

        MyClass obj = (MyClass) inputStream.readObject();
        System.out.println(obj); //MyClass{batch=10, collegeCode=10 privatefiled 0}

    }
}




class MyClass implements Serializable {
    int batch;
    int collegeCode;

    transient int privateFiled;

    public MyClass(int batch, int collegeCode, int privateFiled) {
        this.batch = batch;
        this.collegeCode = collegeCode;
        this.privateFiled = privateFiled;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "batch=" + batch +
                ", collegeCode=" + collegeCode + " privatefiled " + privateFiled +
                '}';
    }



}
