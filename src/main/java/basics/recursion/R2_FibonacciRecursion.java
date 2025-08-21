package basics.recursion;


/*
0     3rd
0 1 1 2 3 5 8
3rd number(n)= (n-1)+(n-2)

f(0),f(1) is f(n) itself--> 0 ,1 Base Condition

f(3)=f(2)+f(1)

(f2)+f(1)

2 1 0  +1


 */

//finding nth number in fibonacci series using recursion
public class R2_FibonacciRecursion {
    public static void main(String[] args) {
        System.out.println(fibo(5));
    }
    static int fibo(int n){
        if(n<2) return n;
        return fibo(n-1)+fibo(n-2);
    }



}
