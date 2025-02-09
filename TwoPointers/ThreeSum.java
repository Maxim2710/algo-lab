import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,0,1,2,-1,-4};
        int[] nums2 = new int[]{0,0,0};
        int[] nums3 = new int[]{-2, -2, 0, 0, 2, 2};

        ThreeSum t = new ThreeSum();

        System.out.println(t.threeSum(nums1));
        System.out.println(t.threeSum(nums2));
        System.out.println(t.threeSum(nums3));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i -1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];

                if (curSum < 0) l++;
                else if (curSum > 0) r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    // Мы уже достигаем уникальности путем сдвига левого указателя, поэтому на правом поинте может быть повторение
                }
            }
        }

        return res;
    }

}


/*
1. Отсортируем массив, чтобы можно было отслеживать повторы
2. Запустим цикл и будем делать проверки:
    - Если текущий элемент больше 0 - мы уже никак не сможем сделать сумму равную 0 - break
    - Если текущий элемент равен предыдущему - пропускаем итерацию, чтобы не попасть на дубль
    - Заведем указатели l и r
    - По стандартным правилам будем сдвигать их, как для twoSum
    - Если комбинация найдена - перемещаем указатели, добавляем элементы и проверяем на дубликаты левый поинтер
 */