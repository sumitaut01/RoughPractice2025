package basics.javapgms;


import org.testng.annotations.Test;

class UST_CreditCardMasking {
    public static void main(String[] args) {
        String card = "1234567890123456";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < card.length(); i++) {
            // mask first 12 digits
            if (i < 12) {
                sb.append("*");
            } else {
                sb.append(card.charAt(i));
            }

            // add dash after every 4 digits except at the end
            if ((i + 1) % 4 == 0 && i != card.length() - 1) {
                sb.append("-");

                System.out.println(sb);
            }
        }

        System.out.println(sb.toString());
    }


//****-****-****-3456



@Test
public void rough(){

    String card = "1234567890123456";

    StringBuffer sb=new StringBuffer();

    for(int i=0;i<card.length();i++){

        if(i<12){
            sb.append("*");
        }

        if((i+1)%4==0 &&i<card.length()-1){
            sb.delete(i,1+1 );
            sb.insert(i,"-");
        }
    }

    System.out.println(sb);


}
}