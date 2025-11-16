import java.util.*;

public class MajorityElement2 {
    // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    
    // Time Complexity: O(n) Space Complexity: O(n)
    public static List<Integer> majorityElement(int [] nums){
        List<Integer> list = new Vector<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key) > nums.length/3){
                list.add(key);
            }
        }

        return list;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = input.nextInt();

        int [] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("List of majority elements in entered array is: " + majorityElement(arr));


        input.close();
    }
}
