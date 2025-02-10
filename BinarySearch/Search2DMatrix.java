public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        int target = 10;

        Search2DMatrix s = new Search2DMatrix();

        System.out.println(s.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 2x4 -> matrix[4][2] / matrix[1][2]
        int l = 0;
        int r = row * col - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int curEl = matrix[m / col][m % col];
            // Мы считаем строку, например, если m = 6 -> 6/2 -> это третья строка
            // Мы считаем столбец, например, m = 6 -> 6 % 4 -> третий столбец

            if (curEl < target) l = m + 1;
            else if (curEl > target) r = m - 1;
            else return true;
        }

        return false;
    }
}
