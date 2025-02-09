import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s1 = "[(])";
        String s2 = "([{}])";

        ValidParentheses v = new ValidParentheses();

        System.out.println(v.isValid(s1));
        System.out.println(v.isValid(s2));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
