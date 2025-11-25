import java.util.*;

public class MergeTwoArraysWithoutSpace {
    
    // Better Force Approach => Time Complexity = O(2(m+n)) and Space Complexity = O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;

        while(i >= 0 && j >= 0){
            if(nums1[i] <  nums2[j]){
                nums1[k--] = nums2[j--];
            }
            else if(nums1[i] == nums2[j]){
                nums1[k--] = nums2[j--];
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums1[i--];
            }
        }

        while(i >= 0){
            nums1[k--] = nums1[i--];
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    // Brute Force Approach => Time Complexity = O(m+n) Space Complexity = O(m+n)
    /* public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] merge = new int[m+n];

        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(nums1[i] <  nums2[j]){
                merge[k++] = nums1[i++];
            }
            else if(nums1[i] == nums2[j]){
                merge[k++] = nums1[i++];
                merge[k++] = nums2[j++];
            }
            else{
                merge[k++] = nums2[j++];
            }
        }

        while(i < m){
            merge[k++] = nums1[i++];
        }

        while(j < n){
            merge[k++] = nums2[j++];
        }

        for(int l = 0; l<(m+n); l++){
            nums1[l] = merge[l];
        }
    } */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter size for 1st array: ");
        int size1 = input.nextInt();

        System.out.println("Enter size for 2nd array: ");
        int size2 = input.nextInt();

        int [] nums1 = new int[size1 + size2];
        int [] nums2 = new int[size2];

        System.out.println("Enter " + size1 + " elements for 1st array rest zero: ");
        for(int i = 0; i< (size1+size2); i++){
            nums1[i] = input.nextInt();
        }
        System.out.println("Enter " + size2 + " elements for 2nd array: ");
        for(int i = 0; i< size2; i++){
            nums2[i] = input.nextInt();
        }

        merge(nums1, size1, nums2, size2);
        System.out.println("First Array after merging: " + Arrays.toString(nums1));

        input.close();
    }
}
