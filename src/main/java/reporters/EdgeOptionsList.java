package reporters;
//
//import com.config.ConfigFactory;
//import net.datafaker.providers.entertainment.SouthPark;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public final class EdgeOptionsList {
//
//    public static EdgeOptions setlocalEdgeOptions() {
//        ArrayList<String> localOptions = (ArrayList<String>) ConfigFactory.getConfig().localedgeoptions();
//        System.out.println(localOptions);
////        if(localOptions.get(0).toLowerCase().contains("user-data-dir")){
////            //means we are using profile and we want to kill existing edge windows
////            try {
////                Runtime.getRuntime().exec("taskkill /f /im msedge.exe");
////            } catch (IOException e) {
////                System.out.println("Error while Killing msedge.exe");
////            }
//        //}
//        EdgeOptions options = new EdgeOptions();
//
//        try{
//            Map<String, Object> prefs = new LinkedHashMap<>();
//            prefs.put("user_experience_metrics.personalization_data_consent_enabled", Boolean.valueOf(true));
//            options.setExperimentalOption("prefs", prefs);
//            localOptions.forEach(opt -> options.addArguments("--" + opt.trim().trim()));
//        }
//        catch (Exception oEx){
//            System.out.println("Error while adding creating edge options. Returning default chrome options");
//        }
//        return options;
//    }
//
//
//    public static void killExistingEdgeBrowser(){
//        ArrayList<String> localOptions = (ArrayList<String>) ConfigFactory.getConfig().localedgeoptions();
//        System.out.println(localOptions);
//        if(localOptions.get(0).toLowerCase().contains("user-data-dir")){
//            //means we are using profile and we want to kill existing edge windows
//            try {
//                Runtime.getRuntime().exec("taskkill /f /im msedge.exe");
//            } catch (IOException e) {
//                System.out.println("Error while Killing msedge.exe");
//            }
//        }
//
//
//    }
//}