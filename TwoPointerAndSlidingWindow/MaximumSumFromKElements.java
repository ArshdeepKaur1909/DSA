
// We have to find maximum sum of K elements from array such that they are either from starting or from last i.e. first or last element is always included

class MaximumSumFromKElements {
    
    public static int maxSumFromKElements(int [] arr, int k){
        int leftsum, rightsum, maxsum;
        leftsum = rightsum = maxsum = 0;

        for(int i = 0; i<k; i++){
          leftsum += arr[i];
        }

        maxsum = leftsum;
        
        int right = arr.length-1;
        for(int i = k-1; i>=0; i--){
          leftsum -= arr[i];
          rightsum += arr[right];
          maxsum = Math.max(maxsum, leftsum+rightsum);
          right--;
        }

        return maxsum;
    }

    public static void main(String [] args){
     int [] arr = {54, 6, 8, -9, 10};
     int k = 2;
     System.out.println("Maximum sum from k elements in array: " + maxSumFromKElements(arr, k));
   }  
}
