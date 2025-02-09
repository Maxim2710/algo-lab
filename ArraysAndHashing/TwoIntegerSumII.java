import java.util.Arrays;

public class TwoIntegerSumII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int target = 3;

        TwoIntegerSumII t = new TwoIntegerSumII();
        System.out.println(Arrays.toString(t.twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length - 1;
        int l = 0;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];

            if (curSum > target) r--;
            else if (curSum < target) l++;
            else return new int[]{l + 1, r + 1};
        }

        return new int[]{0};
    }
}
