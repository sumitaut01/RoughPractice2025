package basics.javapgms;

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
            }
        }

        System.out.println(sb.toString());
    }
}

//****-****-****-3456