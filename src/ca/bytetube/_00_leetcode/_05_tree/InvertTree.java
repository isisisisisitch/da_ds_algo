package ca.bytetube._00_leetcode._05_tree;

import ca.bytetube._00_leetcode.common.TreeNode;
import ca.bytetube._07_binarytree.TreeTraversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * @author dal
 */
public class InvertTree {

    public TreeNode invertTree1(TreeNode root) {//preOrder
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }


    public TreeNode invertTree2(TreeNode root) {//postOrder
        if (root == null) return root;

        invertTree2(root.left);
        invertTree2(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {//InOrder
        if (root == null) return root;

        invertTree3(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree3(root.left);

        return root;
    }

    public TreeNode invertTree(TreeNode root) {//LevelOrder
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();

            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;

            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

        return root;
    }


}
