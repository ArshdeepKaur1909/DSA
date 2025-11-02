import java.util.*;

public class Leaders {
    
    public static Vector<Integer> findLeaders(int [] nums){
        Vector<Integer> Leaders = new Vector<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        Leaders.add(nums[nums.length - 1]);

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i+1] && map.get(nums[i+1]) == null){
                Leaders.add(nums[i]);
            }else if(nums[i] > nums[i+1] && map.get(nums[i+1]) != null ){
                if(nums[i] > map.get(nums[i+1])){
                    Leaders.add(nums[i]);
                }else{
                    map.put(nums[i], map.get(nums[i+1]));
                }
            }else{
                map.put(nums[i], nums[i+1]);
            }
        }

        return Leaders;

    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        System.out.println("Leaders in the array are: ");
        Vector<Integer> result = findLeaders(nums);
        for(int leader : result){
            System.out.print(leader + " ");
        }

        input.close();

    }
}
