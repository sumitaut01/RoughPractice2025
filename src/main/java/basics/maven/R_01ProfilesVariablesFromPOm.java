package basics.maven;

public class R_01ProfilesVariablesFromPOm {


    public static void main(String[] args) {


        // if we run dreictly from here all will be null like below
        //Env: null
        //Base URL: null
        System.out.println("Env: " + System.getProperty("env"));
        System.out.println("Base URL: " + System.getProperty("baseUrl"));
        System.out.println("DB URL: " + System.getProperty("dbUrl"));


// this        mvn clean test -Puat



    }
}
