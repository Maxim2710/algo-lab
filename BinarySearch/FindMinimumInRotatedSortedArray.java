public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,1,2};

        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();

        System.out.println(f.findMin(nums));
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] <= nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }
}
