package basics.javapgms;

import org.apache.http.io.SessionOutputBuffer;

import java.util.Scanner;

public class R_XCountNumberOFDigits {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the num:=>");
        int num=sc.nextInt();
        int digits=0;
        while(num!=0){
            digits++;
            num=num/10;
        }
        System.out.println(digits);

        sc.close();
    }
}
