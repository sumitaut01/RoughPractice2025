package basics.javapgms;
import java.util.HashMap;

public class R20_MajorityElement {
    public static void main(String[] args) {

        Integer[] arr = {2, 2, 1, 2, 3, 2, 2};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }


        int majorityCount = arr.length / 2;
        boolean found = false;

        for (var entry : hm.entrySet()) {
            if (entry.getValue() > majorityCount) {
                System.out.println("Majority Element: " + entry.getKey());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No Majority Element");
        }
    }
}
