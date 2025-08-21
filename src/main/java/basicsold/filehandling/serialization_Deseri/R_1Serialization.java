package basicsold.filehandling.serialization_Deseri;

import java.io.*;

public class R_1Serialization {

//    Summary
//    Task	Class Used
//    Serialize object	ObjectOutputStream
//    Deserialize object	ObjectInputStream
//    Mark class	Implements Serializable
//            Skip fields	Mark them transient

    public static void main(String[] args) throws IOException {

        Student s = new Student( 25,"sumit");
        FileOutputStream fos = new FileOutputStream("student.ser");
ObjectOutputStream objectOutputStream=new ObjectOutputStream(fos);

        objectOutputStream.writeObject(s);
        System.out.println("Object serialized to student.ser");

    }



}

class Student implements Serializable {

    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
