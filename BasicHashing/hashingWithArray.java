import java.util.*;

// We have to tell each inputed element's frequency from given array of elements 
public class hashingWithArray {
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);
        
      System.out.println("Enter size of array: ");
      int size = input.nextInt();

      int [] array = new int[size];
      System.out.println("Enter elements of array: ");
      for(int i = 0; i<size; i++){
        array[i] = input.nextInt();
      }
      
      //creating a hash array storing frequency of number from 0 to 12 as per inputed array
      int [] hash = new int[13];
      for(int i = 0; i<size; i++){
        hash[array[i]]++;
      }

      System.out.println("Enter how many queries need to enter to check their frequency: ");
      int query = input.nextInt();

      while(query-- > 0){
        System.out.println("Enter Queries: ");
        int num = input.nextInt();

        System.out.println("Frequency of " + num + " is: " + hash[num]);
      }

      input.close();
    }
}