import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,20,4,10,3,4,5};
        int[] nums2 = new int[]{0,3,2,5,4,6,1,1};

        LongestConsecutiveSequence l = new LongestConsecutiveSequence();

        System.out.println(l.longestConsecutive(nums1));
        System.out.println(l.longestConsecutive(nums2));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestSeq = 0;

        for (int num : nums) {

            if (!set.contains(num - 1)) {
                int length = 0;

                while (set.contains(num + length)) {
                    length++;
                }

                longestSeq = Math.max(length, longestSeq);
            }
        }

        return longestSeq;
    }
}

/*
1. Создадим сет, в котором будем хранить все значения из nums
2. Проитерируемся по массиву и смотрим:
    - если это начало последовательности: (num - 1) не существует - создаем локальную переменную и
    увеличиваем ее до того, пока последовательность не кончится
    - в противном случае - ничего не делаем

(Все потому, что:
- Начало определяется в любом случае, т.к. мы пройдем по всему массиву в любом случае
- Если это не начало - мы просто не трогаем это число и идем далее
)
 */