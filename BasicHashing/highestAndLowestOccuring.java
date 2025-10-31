import java.util.*;

public class highestAndLowestOccuring{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter how many elements you want to enter: ");
        int n = input.nextInt();
        
        int [] nums = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i<n; i++){
           nums[i] = input.nextInt(); 
        }

        int lowestFrequency = n;
        int highestFrequency = 1;

        int he, le;
        he = le = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > highestFrequency){
                highestFrequency = map.get(nums[i]);
                he = nums[i];
            }
        }

        for(Integer key: map.keySet()){
            if(map.get(key) < lowestFrequency){
                lowestFrequency = map.get(key);
                le = key;
            }
        }

        System.out.println("Highest Occuring Element in array: " + he);
        System.out.println("Lowest Occuring Element in array: " + le);

        input.close();
    }
}