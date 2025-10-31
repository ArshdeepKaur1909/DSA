import java.util.*;

class hashingWithHashmap{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int [] arr = new int[size];

        System.out.println("Enter elements for array: ");
        for(int i = 0; i<size; i++){
            arr[i] = input.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<size; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("Enter how many queries you want to check frequency in array: ");
        int q = input.nextInt();

        while(q-- > 0){
            System.out.println("Enter any query: ");
            int query = input.nextInt();
            System.out.println("Frequency of " + query + " is: " + map.getOrDefault(query, 0));
        }

        input.close();
    }
}
