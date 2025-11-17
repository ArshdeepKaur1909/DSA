import java.util.*;

public class MajorityElement2 {
    // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. Note = None can have more than 2 such elements.
    
    // Optimal Approach Time Complexity: O(2n) Space Complexity: O(1)
    public static List<Integer> majorityElement(int [] nums){
        List<Integer> list = new Vector<>();

        int count1 = 0, count2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(count1 == 0 && nums[i] != ele2){
                ele1 = nums[i];
                count1++;
            }
            else if(count2 == 0 && nums[i] != ele1){
                ele2 = nums[i];
                count2++;
            }
            else if(nums[i] == ele1){
                count1++;
            }
            else if(nums[i] == ele2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }


        count1 = 0; count2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == ele1) count1++;
            else if(nums[i] == ele2) count2++;
        }

        if(count1 > nums.length/3) list.add(ele1);
        if(count2 > nums.length/3) list.add(ele2);
        
        return list;
    }
            
    
    // Better Force Approach Time Complexity: O(2n) Space Complexity: O(n)
    /* public static List<Integer> majorityElement(int [] nums){
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
    } */
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
