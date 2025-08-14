package selenium;

public class R9_JavascriptDemo {

    public static void main(String[] args) {

        webdriver driver= new chrome();

        driver.get();//fine

      ((jsexecutor)driver).executeScript("ss");







    }
}







interface  jsexecutor {
    void executeScript(String script) ;
}

 class Remote implements  jsexecutor,webdriver{

     @Override
     public void executeScript(String script) {
         System.out.println( "javacsriprexecutoe implmeted");
     }

     @Override
     public void get() {
         System.out.println( "webdriver implmeted");
     }
 }



class chrome extends   Remote{

     public void getChromeDriver(){
         System.out.println("chrome invoked");

     }
}


interface  webdriver {
    void get() ;
}


