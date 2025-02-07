import java.util.ArrayList;
import java.util.List;

public class InorderTraversalTree {
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

        List<Integer> list = inorderTravel(root);

        System.out.println(list);
    }

    private static List<Integer> inorderTravel(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(inorderTravel(root.left));
        result.add(root.val);
        result.addAll(inorderTravel(root.right));

        return result;
    }


}
