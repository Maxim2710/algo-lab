
import java.util.Arrays;

public class BalancedBST {


    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 3, 6, 9, 5, 8};
        TreeNode root = arrayToBalancedBST(nums);
        inorderTraversal(root);
    }

    private static TreeNode arrayToBalancedBST(int[] nums) {
        Arrays.sort(nums);
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (Math.abs(start - end) / 2);

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
