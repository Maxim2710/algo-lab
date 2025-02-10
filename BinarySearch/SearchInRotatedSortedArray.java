public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int target = 1;
        int[] nums = new int[]{3,4,5,6,1,2};

        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

        System.out.println(s.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                // Загоняем в левую часть target
                if (target >= nums[l] && nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // Загоняем в правую часть target
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
