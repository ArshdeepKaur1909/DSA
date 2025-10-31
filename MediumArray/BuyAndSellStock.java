import java.util.*;

public class BuyAndSellStock{

    // Optimal Approach2 => Time Complexity => O(n) Space Complexity => O(1)
    public static int StockMaxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
        if (price < minPrice) {
            minPrice = price;  // Update the lowest price seen so far
        } else {
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
    }

      return maxProfit;
    }
    
    // Optimal Approach1 => Time Complexity => O(n) Space Complexity => O(1)
    /* public static int StockMaxProfit(int [] prices){
        int profit = 0, maxProfit = 0;

        int buy = 0, sell = buy + 1;
        while( sell < prices.length ){
           profit = prices[sell] - prices[buy];
           maxProfit = Math.max(maxProfit, profit);

           if(profit < 0){
            buy++;
            sell = buy + 1;
           }else{
            sell++;
           }
        }
        return maxProfit;
    } */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array only 0, 1 and 2: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        int result = StockMaxProfit(nums);
        System.out.println("Maximum Profit that can be generated is: " + result);

        input.close();
    }
}