public class RangeInTree {
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
        //    1   4 7   10
        //   / \    \
        //  0   2    5

        TreeNode root2 = new TreeNode(6,
                new TreeNode(3,
                        new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                        new TreeNode(4, null, new TreeNode(5))
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(10)
                )
        );

        boolean provOnConditionFirstTree = provRange(root1);
        boolean provOnConditionSecondTree = provRange(root2);

        System.out.println(provOnConditionFirstTree);
        System.out.println(provOnConditionSecondTree);
    }



    private static boolean provRange(TreeNode root) {
        int maxVal = 22;
        int minVal = 0;

        if (root == null) {
            return true;
        }

        int left = minInorder(root);
        int right = maxInorder(root);

        return left >= minVal && right <= maxVal;
    }

    private static int maxInorder(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.val;
    }

    private static int minInorder(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}
