public class BinarySearch {
    public static void main(String[] args) {
        int target = 4;
        int[] nums = new int[]{-1,0,2,4,6,8};

        BinarySearch b = new BinarySearch();

        System.out.println(b.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (target > nums[m]) l = m + 1;
            else if (target < nums[m]) r = m - 1;
            else return m;
        }

        return -1;
    }
}
