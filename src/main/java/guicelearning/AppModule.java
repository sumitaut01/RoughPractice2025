package guicelearning;

import com.google.inject.AbstractModule;

//STEP 3: Create a Module (brain of Guice)
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        // If someone needs HelloService, create a new HelloService object
        bind(HelloService.class).toInstance(new HelloService());
    }
}

//This tells Guice HOW to create HelloService.