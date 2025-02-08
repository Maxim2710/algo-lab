public class KthSmallestInBST {
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
        TreeNode ans = kthSmallestInBST(root1, k);

        System.out.println(ans.val);
    }

    private static TreeNode kthSmallestInBST(TreeNode root1, int k) {
        return inOrder(root1, k);
    }

    private static TreeNode inOrder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = inOrder(root.left, k);
        if (left != null) {
            return left;
        }

        cnt++;
        if (cnt == k) {
            return root;
        }

        return inOrder(root.right, k);
    }


}

/*
проверяем не равен ли root null -> если равен, то узел был листовым, возвращаемся к нему
предварительно рекурсивно обходим левое поддерево, если значение оказалось не null - мы нашли результат
постепенно при этом прибавляем при возвращении наименьшие
после чего рекурсивно проходим по правому поддереву
 */