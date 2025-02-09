import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"1","2","+","3","*","4","-"};

        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();

        System.out.println(e.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> pairs = new Stack<>();

        for (String c : tokens) {
            switch (c) {
                case "*" -> {
                    int b = pairs.pop();
                    int a = pairs.pop();
                    pairs.push(a * b);
                }
                case "+" -> {
                    int b = pairs.pop();
                    int a = pairs.pop();
                    pairs.push(a + b);
                }
                case "-" -> {
                    int b = pairs.pop();
                    int a = pairs.pop();
                    pairs.push(a - b);
                }
                case "/" -> {
                    int b = pairs.pop();
                    int a = pairs.pop();
                    pairs.push(a / b);
                }
                default -> pairs.push(Integer.valueOf(c));
            }
        }

        return pairs.pop();
    }
}
