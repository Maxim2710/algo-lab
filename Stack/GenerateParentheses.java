import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 2;

        GenerateParentheses g = new GenerateParentheses();

        System.out.println(g.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        recursion(0, 0, n, res, stack);

        return res;
    }

    private void recursion(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            recursion(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
            // ((

            // ((
            // (

            // ()(
        }

        if (closedN < openN) {
            stack.append(')');
            recursion(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
            // ))
            // res -> (())
            // (()
            // ((

            // ()

            //()()
        }
    }
}
