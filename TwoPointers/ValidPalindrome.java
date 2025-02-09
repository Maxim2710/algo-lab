public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }

        return sb.toString().contentEquals(sb.reverse());
    }

    public static void main(String[] args) {
        String s1 = "Was it a car or a cat I saw?";
        String s2 = "tab a cat";

        ValidPalindrome v = new ValidPalindrome();

        System.out.println(v.isPalindrome(s1));
        System.out.println(v.isPalindrome(s2));
    }
}
