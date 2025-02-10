import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temp = new int[]{30,38,30,36,35,40,28};

        DailyTemperatures d = new DailyTemperatures();

        System.out.println(Arrays.toString(d.dailyTemperatures(temp)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}

/*
Смотрим, если стек не пуст и на его вершине лежит элемент меньше, чем текущая температура,
извлекаем этот элемент, берем у него индекс и записываем в массив результатов расстояние до тех пор,
пока в стеке на вершине элемент < текущая температура
 */

// Input: temperatures = [30,38,30,36,35,40,28]
// Output: [1,4,1,2,1,0,0]
