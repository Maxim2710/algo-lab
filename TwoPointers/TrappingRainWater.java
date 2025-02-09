public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,0,3,1,0,1,3,2,1};
        TrappingRainWater t = new TrappingRainWater();

        System.out.println(t.trap(nums));
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int leftMax = height[l];
        int rightMax = height[r];

        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }

        return res;
    }
}
