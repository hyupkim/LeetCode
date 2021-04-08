/*
Comment
Using Brute force results O(n^2)
HashMap reduces the time complexity into O(n)
*/

import java.util.Map;
import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
            
        }
        
        throw new IllegalArgumentException();
        
    }
    public static void main(String[] args) {
        twoSum(new int[]{1,2,3}, 5); 
    }

}