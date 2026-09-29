package basics.javapgms.citi_preparation;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first num: ");
        int num1=sc.nextInt();


        System.out.println("Enter second num: ");
        int num2=sc.nextInt();

        System.out.println("Result is: ");
        System.out.println(num1+num2);
    }
}
