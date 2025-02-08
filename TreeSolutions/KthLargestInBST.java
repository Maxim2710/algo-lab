public class KthLargestInBST {
    private static int cnt = 0;

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(15,
                new TreeNode(10,
                        new TreeNode(5, new TreeNode(2), new TreeNode(7)),
                        new TreeNode(12, null, new TreeNode(14))
                ),
                new TreeNode(20,
                        new TreeNode(18),
                        new TreeNode(25)
                )
        );

        int k = 3;

        TreeNode ans = kthLargestInBST(root1, k);
        System.out.println(ans.val);
    }

    private static TreeNode kthLargestInBST(TreeNode root, int k) {
        return inOrder(root, k);
    }

    private static TreeNode inOrder(TreeNode root, int k) {
        if (root == null) return null;

        TreeNode right = inOrder(root.right, k);
        if (right != null) return right;

        cnt++;
        if (cnt == k) return root;

        return inOrder(root.left, k);
    }
}
