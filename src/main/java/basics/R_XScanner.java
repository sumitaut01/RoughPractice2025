package basics;

import java.util.Scanner;

public class R_XScanner {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter name= >");
        String name=sc.nextLine();
        System.out.println("name is "+name);

        System.out.println("Enter Age");
        int Age=sc.nextInt();
        System.out.println("Age is "+Age);

        System.out.println("Enter Salary");
        double sal=sc.nextDouble();
        System.out.println("Salary is "+sal);







    }
}
