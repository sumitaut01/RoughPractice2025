package guicelearning.guicewebdriver;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

//STEP 2: Bind Provider in Module
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(WebDriver.class)
            .toProvider(WebDriverProvider.class);  // <-- IMPORTANT
    }
}

//Now Guice knows:
//
//“Whenever someone injects WebDriver, call WebDriverProvider.get()”