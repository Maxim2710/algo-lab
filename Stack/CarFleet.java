import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        int target = 10;
        int[] pos = new int[]{1, 4};
        int[] speed = new int[]{3, 2};

        CarFleet c = new CarFleet();

        System.out.println(c.carFleet(target, pos, speed));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] p : pairs) {
            double curTime = (double) (target - p[0]) / p[1];
            stack.push(curTime);

            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) stack.pop();
        }

        return stack.size();
    }
}


/*
Создаем массив пар, в котором храним: позицию на прямой и скорость.
!!! Отсортируем массив по убыванию позиции - это надо для того, чтобы в случае,
если машина сзади догнала первую, то она не может сохранять скорость - скорость догнавшей сбрасывается до той,
которую догнали.
Создадим стек для хранения времени, через которое машины прибудут на финиш.

Проверяем, если в стеке 2 и более элементов и при этом верхний элемент стека доезжает до финиша
за меньший промежуток времени - мы можем выбросить тот, что лежит на верхушке.
(Потому что он все равно не сможет доехать быстрее машины перед ним, он сольется с идущей перед ним и образует автопарк
 */