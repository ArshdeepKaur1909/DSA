import java.util.*;
// For two sorted arrays we have to return their union such that union does not include duplicates and have all elements sorted

public class union{
    
    // Optimal Approach => Time Complexity = O(nums1.length + nums2.length) and Space complexity = O(nums1.length + nums2.length)
    // We have to avoid using vector's contains method as it will increase Time Complexity
    public static Vector<Integer> Union(int[] nums1, int[] nums2) {
    Vector<Integer> union = new Vector<>();
    int i = 0, j = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
            if (union.isEmpty() || union.lastElement() != nums1[i])
                union.add(nums1[i]);
            i++;
            j++;
        } else if (nums1[i] < nums2[j]) {
            if (union.isEmpty() || union.lastElement() != nums1[i])
                union.add(nums1[i]);
            i++;
        } else {
            if (union.isEmpty() || union.lastElement() != nums2[j])
                union.add(nums2[j]);
            j++;
        }
    }

    while (i < nums1.length) {
        if (union.isEmpty() || union.lastElement() != nums1[i])
            union.add(nums1[i]);
        i++;
    }

    while (j < nums2.length) {
        if (union.isEmpty() || union.lastElement() != nums2[j])
            union.add(nums2[j]);
        j++;
    }

    return union;
}

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for 1st array: ");
        int size1 = input.nextInt();
        
        int [] nums1 = new int[size1];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size1; i++){ 
           nums1[i] = input.nextInt();
        }

        System.out.println("Enter size for 2nd array: ");
        int size2 = input.nextInt();
        
        int [] nums2 = new int[size2];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size2; i++){ 
           nums2[i] = input.nextInt();
        }
        
        input.close();

        System.out.println("Union of these 2 sorted arrays: " + Union(nums1, nums2));
    } 
}
