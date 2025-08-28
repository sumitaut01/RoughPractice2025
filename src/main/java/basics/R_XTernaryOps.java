package basics;

public class R_XTernaryOps {

    public static void main(String[] args) {

        System.out.println(1>2?true:false);//false
        int x=10;
        String result = (x > 0) ? "positive" : (x < 0) ? "negative" : "zero";
        System.out.println(result);

        String env="qa";
         String en = env.equals("qa") ? "qa"
                : env.equals("uat") ? "uat"
                : env.equals("prod") ? "prod"
                : "unknown";

    }
}
