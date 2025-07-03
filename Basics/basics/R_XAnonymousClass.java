package basics;

//What is an Anonymous Class?
//An anonymous class in Java is:
//A class without a name, declared and instantiated at the same time, usually to override methods of an interface or abstract class for one-time use.
//✅ Key Characteristics
//It’s an inner class (inside a method or block)
//It does not have a name
//Commonly used with interfaces, abstract classes, or event handlers
//Used where you need a short implementation only once

public class R_XAnonymousClass {
    public static void main(String[] args) {

        //You’re creating an unnamed subclass of Animal and overriding its method right there.
        Animalone animal=new Animalone() {
            @Override
            public void sound() {
                System.out.println("Annonyms class used");
            }
        };

        animal.sound();//Annonyms class used
    }
}


//Why Use Anonymous Classes?
//Advantage	Description
//Less code	No need to create separate class
//One-time use	You only need to override a method quickly
//Handy with listeners/events	Used in GUI or callback-based code (like Android, Swing)


interface Animalone {
    void sound();
}