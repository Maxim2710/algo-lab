import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = new int[]{3, 4, 5, 6};
        int target2 = 10;
        int[] nums2 = new int[]{4, 5, 6};

        TwoSum tS = new TwoSum();

        System.out.println(Arrays.toString(tS.twoSum(nums1, target1)));
        System.out.println(Arrays.toString(tS.twoSum(nums2, target2)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ost = target - nums[i];
            if (map.containsKey(ost)) {
                return new int[]{map.get(ost), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
