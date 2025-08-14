package basicsold.datastructure;

import java.util.Stack;

//Common Stack Methods
//        Method	Description
//        push(E)	Adds an element to the top
//        pop()	Removes and returns top element
//        peek()	Returns top without removing
//        isEmpty()	Checks if stack is empty
//        search(E)	Position from top (1-based)

//A stack is a Last In, First Out (LIFO) data structure.
//
//        Think of:
//        A pile of books → you add and remove only from the top
//
//        Push = add to top, Pop = remove from top


public class R_Stack {



    public static void main(String[] args) {

        Stack<String> my =new Stack<>();
        my.push("A");
        my.push("B");
        my.push("C");

        System.out.println(my);//[A, B, C]

        System.out.println(my.peek());//C last entred element
        System.out.println(my.pop());//C last entred element removed and printed
        System.out.println(my);//[A, B]
        my.push("D");
        System.out.println(my);//[A, B, D]


        int x = 10;

        System.out.println(x++);  // prints 10, x becomes 11
        System.out.println(++x);  // x becomes 12, then prints 12

        System.out.println(x--);  // prints 12, x becomes 11
        System.out.println(--x);  // x becomes 10, then prints 10


//        Summary
//        Form	Order	Example Outcome
//        x++	Use → Then Increment	int b = x++; → b = x, x++
//                ++x	Increment → Then Use	int b = ++x; → x++, b = x
//        x--	Use → Then Decrement	Same idea as above
//        --x	Decrement → Then Use	Same idea as above


    }
}