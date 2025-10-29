package basics.bddinfo.hooks;

/*
Scenario Hooks execute before and after every scenario.
In the above example, executed two times for two scenarios.
Note we can have multiple before after and the can give then int value to decide which executes first or later
 */

import com.github.tomakehurst.wiremock.stubbing.Scenario;

public class Hooks {
	
//	@Before
    public void beforeScenario(Scenario scenario){
        System.out.println("This will run before the Scenario");
    }	
	
	//@After
    public void afterScenario(Scenario scenario){
        System.out.println("This will run after the Scenario");
    }
}