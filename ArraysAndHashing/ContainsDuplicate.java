import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) throws IOException {
        int[] nums = new int[]{1,2,3,4};
        int[] nums1 = new int[]{1,2,2,3};

        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.hasDuplicate(nums);
        boolean result1 = containsDuplicate.hasDuplicate(nums1);

        System.out.println(result);
        System.out.println(result1);
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
