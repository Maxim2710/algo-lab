import java.util.Arrays;

public class ProductsOfArrayExceptSelf {
    

    public static void main(String[] args) {
        ProductsOfArrayExceptSelf p = new ProductsOfArrayExceptSelf();
        int[] nums1 = {1, 2, 4, 6};
        int[] result1 = p.productExceptSelf(nums1);
        System.out.println(Arrays.toString(result1));

        int[] nums2 = {-1, 0, 1, 2, 3};
        int[] result2 = p.productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2));
    }

    private int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixMul = new int[n];

        prefixMul[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixMul[i] = prefixMul[i - 1] * nums[i - 1];
        }
        // 1, 2, 4, 6 -> 1 1 2 8
        // -1, 0, 1, 2, 3 -> 1 -1 0 0 0

        int rPointer = 1;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = rPointer * prefixMul[i];
            rPointer *= nums[i];
        }

        return ans;
    }
}

/*
1. Создаем массив, который будет той же длины, что и изначальный. В нем будем хранить
элементы без текущей суммы. Т.е.: для i-го будем хранить произведение всех, что были до него,
а именно: i-1 с массива префиксных произведений и i-1 с массива nums.
2. Заведем поинтер, который отвечает за подсчет произведения справа (всех чисел, кроме текущего)
Предварительно каждый раз обновляем его - умножая на исходный массив.
 */