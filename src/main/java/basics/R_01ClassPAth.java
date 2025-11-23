package basics;

public class R_01ClassPAth {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        System.out.println("Current classpath: " + classpath);


    }
}

//What is classpath in Java?
//
//Classpath is the path that tells the Java compiler and JVM where to find the .class files and libraries required to run the program.
//
//Java needs .class files (compiled code), not .java files.
//The classpath tells Java where those compiled files are located.
//
//💡 Why is classpath useful?
//
//Classpath is useful because it allows Java to:
//
//Locate your project’s compiled classes (e.g., target/classes)
//
//Locate external libraries (e.g., Selenium, RestAssured, TestNG JARs)
//
//Run the program without copying all dependencies into the same folder
//
//Without classpath, the JVM wouldn’t know where your code or external libraries are, and the program would fail.
//
//📌 One-line version (for interview or explanation)
//
//Classpath is like a search path for the JVM — it tells Java where to find the compiled .class files and required JAR libraries when running a program.
//
//🚀 Small example to make it crystal clear
//
//If your project uses Selenium, Jackson, JDBC drivers etc., Java does not automatically know where they are — classpath tells Java:
//
//Your project's class files → target/classes
//All dependency JARs → ~/.m2/repository/.../jar files
//
//
//Then Java can successfully load and run your code.
//
//⭐ Simple analogy
//
//Classpath is like the contacts list in your phone — if the contact (class) is not in the list (classpath), your phone (JVM) cannot find it or call it.
