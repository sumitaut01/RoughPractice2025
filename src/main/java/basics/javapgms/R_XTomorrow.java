package basics.javapgms;

import org.testng.annotations.Test;

public class R_XTomorrow {

    public static void main(String[] args) {


        String str="tomorrow";
        String out="";
        int count=0;

        for(int i=0;i<str.length();i++){
            if(String.valueOf(str.charAt(i)).equalsIgnoreCase("o")){
                count++;
                int j=0;
                while(j<count){
                    System.out.print(out+"#");
                    j++;
                }
        }
            else{
                System.out.print(out+str.charAt(i));
            }

        }
        //t#m##rr###w


    }



    @Test
    public void ansChatGPT(){
        String str = "tomorrow";
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'o' || ch == 'O') {
                count++;
                for (int j = 0; j < count; j++) {
                    result.append("#");
                }
            } else {
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }
}
