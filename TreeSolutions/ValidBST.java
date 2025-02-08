public class ValidBST {
    public static void main(String[] args) {

        //          15
        //        /    \
        //      10      20
        //     /  \     /  \
        //    5   12   18  25
        //   / \    \
        //  2   7   14

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

        //         6
        //       /   \
        //      3     8
        //     / \   /  \
        //    1   7 7   10
        //   / \    \
        //  0   2    5

        TreeNode root2 = new TreeNode(6,
                new TreeNode(3,
                        new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                        new TreeNode(7, null, new TreeNode(5))
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(10)
                )
        );

        boolean validRoot1 = isValidBST(root1);
        boolean validRoot2 = isValidBST(root2);

        System.out.println(validRoot1);
        System.out.println(validRoot2);
    }

    private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
