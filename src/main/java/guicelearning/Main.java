package guicelearning;

import com.google.inject.Guice;
import com.google.inject.Injector;

//STEP 4: Create Injector manually (No TestNG)
public class Main {
    public static void main(String[] args) {
        
        Injector injector = Guice.createInjector(new AppModule());
        MyApplication app = injector.getInstance(MyApplication.class);
        app.run();
    }
}


//What Guice does here:
//
//Looks at AppModule
//Sees that you bound HelloService
//
//Creates HelloService
//Creates MyApplication
//
//Injects HelloService into MyApplication constructor
//
//Runs app.run()
