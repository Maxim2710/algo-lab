import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku v = new ValidSudoku();

        boolean isValid = v.isValidSudoku(board);

        System.out.println(isValid);
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];

                if (cur != '.') {
                    if (rows[i].contains(cur)) {
                        return false;
                    }

                    rows[i].add(cur);

                    if (cols[j].contains(cur)) {
                        return false;
                    }

                    cols[j].add(cur);

                    // i = 5 / 3 * 3, j = 3 / 3 -> 3+1=4
                    int customInd = (i / 3) * 3 + (j / 3);
                    if (boxes[customInd].contains(board[i][j])) {
                        return false;
                    }

                    boxes[customInd].add(board[i][j]);
                }
            }
        }

        return true;
    }
}
