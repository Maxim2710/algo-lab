public class ClosestValueFinder {

    public static int closestValue(TreeNode root, int target) {
        TreeNode current = root;
        int closest = root.val;

        while (current != null) {
            if (Math.abs(current.val - target) < Math.abs(closest - target)) closest = current.val;

            if (target > current.val) current = current.right;
            else if (target < current.val) current = current.left;
            else break;
        }

        return closest;
    }

    // current - root
    // closest - ближайший пока что корень
    // Пока рут не будет null - мы идем по циклу
    // Делаем проверку, если текущий получился ближе - заменяем closest
    // Далее смотрим, если текущий элемент больше цели - сворачиваем на лево
    // Если текущий элемент меньше цели - сворачиваем направо

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

        int target1 = 13;
        int target2 = 9;

        System.out.println(closestValue(root1, target1));
        System.out.println(closestValue(root2, target2));
    }
}
