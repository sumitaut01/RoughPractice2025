package reporters;


import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public final class ChromeOptionsList {

    public static ChromeOptions setlocalChromeOptions() {
       // ArrayList<String> localOptions = (ArrayList<String>) ConfigFactory.getConfig().localchromeoptions();
        ChromeOptions options = new ChromeOptions();
        try{
       // localOptions.forEach(opt -> options.addArguments("--" + opt.trim().trim()));
        //options.addArguments("--");
        }
        catch (Exception oEx){
            System.out.println("Error while adding creating chrome options. Returning default chrome options");
        }
        return options;
    }
}
