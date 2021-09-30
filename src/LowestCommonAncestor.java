import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {
    private Map<TreeNode, TreeNode> parentsMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        walkNodes(root);
        TreeNode pParent = p;
        TreeNode qParent = q;
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(pParent);
        qStack.push(qParent);

        while ((pParent = parentsMap.get(pParent)) != null) {
            pStack.push(pParent);
        }
        while ((qParent = parentsMap.get(qParent)) != null) {
            qStack.push(qParent);
        }



        TreeNode res = null;
        while ((!pStack.isEmpty()) && (!qStack.isEmpty())) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();
            if (pNode.val== qNode.val) {
                res = pNode;
            } else {
                return res;
            }
        }
        return res;


    }


    public void walkNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    parentsMap.put(node.left, node);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    parentsMap.put(node.right, node);
                }
            }

        }

    }
}