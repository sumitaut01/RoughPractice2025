package basics.javapgms;

//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class RX_LowestPriceStocks {

    public static void main(String[] args) {

        int [] prices = {7, 1, 5, 3, 6, 4,9};

        int min_price= 100000;
        int max_profit=0;

        int itr=0;
        for(int i:prices) {
            min_price=Math.min(min_price, i);
            max_profit=Math.max(max_profit, i - min_price);

            System.out.print(min_price+" ");
            System.out.print(max_profit);
            System.out.println("counter "+(++itr));

        }
        System.out.println("--------------------");


    }
}
