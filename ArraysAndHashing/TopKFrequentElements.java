import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,3,3,3};
        int[] nums2 = new int[]{7,7};

        int k1 = 2;
        int k2 = 1;

        TopKFrequentElements t = new TopKFrequentElements();

        System.out.println(Arrays.toString(t.topKFrequent(nums1, k1)));
        System.out.println(Arrays.toString(t.topKFrequent(nums2, k2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getValue(), entry.getKey()});

        }

        list.sort((a, b) -> b[0] - a[0]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }

        return result;
    }
}


/*
1. Создадим мапу, куда будем класть значения (число: сколько раз встречается) -> делаем цикл и заполняем мапу
2. Создадим лист, в который будем ложить пары: количество раз, которое встретилось и само значение
3. Сортируем по частоте встречаемости
4. Выводим первые K элементов из отсортированного листа
 */