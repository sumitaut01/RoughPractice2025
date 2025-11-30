package guicelearning;

import com.google.inject.Inject;
//STEP 2: Create a class that needs HelloService
public class MyApplication {

    private final HelloService helloService;

    @Inject   // ← Tells Guice: "Give me HelloService"
    public MyApplication(HelloService helloService) {
        this.helloService = helloService;
    }

    public void run() {
        helloService.sayHello();
    }
}


//Key point:
//You are NOT writing:
//new HelloService()
//
//Guice will provide it.