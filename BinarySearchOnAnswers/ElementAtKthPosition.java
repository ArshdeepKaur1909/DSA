import java.util.*;

public class ElementAtKthPosition{

    // Time Complexity: O(size1 + size2) and Space Complexity: O(1)
    public static int elementAtKthPosition(int [] nums1, int [] nums2, int k){
        int count = 0;
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                if(count == k) return nums1[i];
                count++;
                i++;
            }else{
                if(count == k) return nums2[j];
                count++;
                j++;
            }
        }

        while(i < nums1.length){
            if(count == k) return nums1[i];
            count++;
            i++;
        }

        while(j < nums2.length){
            if(count == k) return nums2[j];
            count++;
            j++;
        }

        return -1;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter size for array 1:");
       int size1 = input.nextInt();

       System.out.println("Enter size for array 2:");
       int size2 = input.nextInt();

       int [] array1 = new int[size1];
       int [] array2 = new int[size2];

       System.out.println("Enter elements for 1st array in sorted order: ");
       for(int i = 0; i<size1; i++){
           array1[i] = input.nextInt();
       }

       System.out.println("Enter elements for 2nd array in sorted order: ");
       for(int i = 0; i<size2; i++){
           array2[i] = input.nextInt();
       }

       System.out.println("Enter index at which you need element in merged sorted array: ");
       int k = input.nextInt();

       System.out.println("Element at inputed index in merged sorted array: " + elementAtKthPosition(array1, array2, k));

       input.close();
    }
}