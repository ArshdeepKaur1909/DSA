import java.util.*;

public class MedianOfTwoSortedArrays {

    // Time Complexity: O(n1 + n2) and Space Complexity: O(n1 + n2)
    /* public static int Median(int [] nums1, int [] nums2){
        int [] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while(i < nums1.length && j < nums2.length){
           if(nums1[i] < nums2[j]){
            merge[k++] = nums1[i++];
           }else{
            merge[k++] = nums2[j];
           }
        }

        while(i < nums1.length){
           merge[k++] = nums1[i++];
        }

        while(j < nums2.length){
           merge[k++] = nums2[j++];
        }

        if(merge.length%2 == 0){
           return (merge[merge.length/2] + merge[(merge.length/2)-1])/2;
        }

        return merge[merge.length/2];
    } */
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter size for first array: ");
       int size1 = input.nextInt();

       System.out.println("Enter size for second array: ");
       int size2 = input.nextInt();

       int [] arr1 = new int[size1];
       int [] arr2 = new int[size2];

       System.out.println("Enter elements for first array: ");
       for(int i = 0; i<arr1.length; i++){
           arr1[i] = input.nextInt();
       }

       System.out.println("Enter elements for second array: ");
       for(int j = 0; j<arr2.length; j++){
           arr2[j] = input.nextInt(); 
       }

       System.out.println("The median of merging both arrays but in sorted fashion: " + Median(arr1, arr2));

       input.close();
    }
}