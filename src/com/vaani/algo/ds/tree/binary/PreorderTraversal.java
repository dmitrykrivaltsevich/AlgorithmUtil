package com.vaani.algo.ds.tree.binary;

import com.vaani.algo.ds.core.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * return [1,2,3].
 * <p>
 * Created by Xiaomeng on 8/7/2014.
 */
public class PreorderTraversal {
    List<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        PreorderTraversal test = new PreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(test.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}
