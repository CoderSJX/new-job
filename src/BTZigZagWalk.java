import java.util.*;

public class BTZigZagWalk {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean initial = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> cur = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (initial) {
                    cur.addLast(node.val);
                } else {
                    cur.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            initial = !initial;
            res.add(new ArrayList<>(cur));
        }
        return res;


    }
}
