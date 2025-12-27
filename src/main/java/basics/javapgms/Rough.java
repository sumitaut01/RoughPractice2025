package basics.javapgms;

import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rough {


    @Test
    public void Reverse() {
        int num = 54678;
        System.out.println(num);
        int rev = Integer.MIN_VALUE;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num = num / 10;
        }
        System.out.println(rev);
    }

    @Test
    public void charFreq() {
        String str = "this is sparta";
        Map<Character, Integer> hm = new HashMap<>();
        for (Character c : str.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        System.out.println(hm);//{ =2, p=1, a=2, r=1, s=3, t=2, h=1, i=2}
    }

    @Test
    public void twosum() {

        int arr[] = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        int target = 9;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int toFind = target - arr[i];

            if (hm.containsKey(toFind)) {
                System.out.println(arr[i] + " " + toFind);
            } else {
                hm.put(arr[i], i);
            }
        }
    }


    @Test
    public void stringRev() {

        String st = "this is done";
        String[] stArr = st.split(" ");
        for (int i = stArr.length - 1; i >= 0; i--) {
            System.out.println(stArr[i]);
        }

    }


    @Test
    public void maskCard() {

        String card = "1234432112349999";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < card.length(); i++) {
            if (i < 12) {
                sb.append("*");
                if ((i + 1) % 4 == 0) {
                    sb.append("-");
                }
            } else {
                sb.append(card.charAt(i));
            }
        }
        System.out.println(sb);


    }

    @Test
    public void sortMApBasedOnValues() {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("A", 2);
        hm.put("X", 1);
        hm.put("V", 5);
        hm.put("D", 7);
        Map<String, Integer> sortedMap =
                hm.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(
                                LinkedHashMap::new,
                                (m, e) -> m.put(e.getKey(), e.getValue()),
                                LinkedHashMap::putAll
                        );

        System.out.println(sortedMap);
    }

    @Test
    public void listtoMap() {


    }

    @Test
    public void MergeArray() {

        int a[] = {1, 2, 3, 4};
        int b[] = {5, 6, 7};


        int l1 = a.length;
        int l2 = b.length;

        int l3 = l1 + l2;

        int c[] = new int[l1 + l2];

        int i = 0;
        int j = 0;

        int k = 0;
        while ((i < l1) && (j < l2)) {

            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }

        }
        while (i < l1) {
            c[k++] = a[i++];
        }
        while (j < l2) {
            c[k++] = b[j++];
        }


        System.out.println(Arrays.toString(c));//[1, 2, 3, 4, 5, 6, 7]
    }


    @Test
    public void binarySearch() {

        int arr[] = {1,2,3,4,5,6,7,8,9,10};

        int s = 0;
        int e = arr.length - 1;
        int toFind = 10;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (toFind == arr[mid]) {
                System.out.println("found at " + mid);
                return;
            }

            if (toFind > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println("not found");
    }

}