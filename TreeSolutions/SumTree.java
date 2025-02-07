import java.util.List;

public class SumTree {
    public static void main(String[] args) {

        //         6
        //       /   \
        //      3     8
        //     / \   /  \
        //    1   4 7   10
        //   / \    \
        //  0   2    5

        TreeNode root = new TreeNode(6,
                new TreeNode(3,
                        new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                        new TreeNode(4, null, new TreeNode(5))
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(10)
                )
        );

        int resultSum = countSum(root);

        System.out.println(resultSum);
    }

    private static int countSum(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return 0;
        }

        sum += root.val + countSum(root.left) + countSum(root.right);

        return sum;
    }
}
