package guicelearning.guicewebdriver;

import com.google.inject.Injector;
import com.google.inject.Guice;
//STEP 4: Use Injector in Main
public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AppModule());
        MyApplication app = injector.getInstance(MyApplication.class);
        app.openSite();
    }
}
