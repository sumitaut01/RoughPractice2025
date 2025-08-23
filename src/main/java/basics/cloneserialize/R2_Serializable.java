package basics.cloneserialize;

import java.io.*;

public class R2_Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyClass obj1=new MyClass(12,1200);

        System.out.println(obj1.toString());//MyClass{batch=12, collegeCode=1200}
        //below line possible only because MyClass implements Serializable
        // //Deserialize
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("MyClass.ser"));
        objectOutputStream.writeObject(obj1);
        objectOutputStream.close();


        //Deserialize
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("MyClass.ser"));
        MyClass obj2= (MyClass) objectInputStream.readObject();
        System.out.println(obj2.toString());//MyClass{batch=12, collegeCode=1200}



    }
}



class MyClass implements Serializable {
    int batch;
    int collegeCode;
    public MyClass(int batch, int collegeCode) {
        this.batch = batch;
        this.collegeCode = collegeCode;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "batch=" + batch +
                ", collegeCode=" + collegeCode +
                '}';
    }
}
