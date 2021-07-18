package double_pointer;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRain {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
