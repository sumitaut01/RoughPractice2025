package basics.javapgms;

public class RemoveSpaces {
    public static void main(String[] args) {
        String s = "  Java   Selenium   API  ";
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray())
            if (c != ' ') sb.append(c);

        System.out.println(sb.toString());
    }
}