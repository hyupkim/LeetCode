/*
Mistake that I had:
tried to think whether the current number is greater than 0.
But no matter what the number is compare it with current and curr + nums[i]
*/

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int res = curr;
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }
}
