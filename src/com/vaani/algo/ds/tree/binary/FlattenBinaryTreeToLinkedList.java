package com.vaani.algo.ds.tree.binary;

import com.vaani.algo.ds.core.TreeNode;

import java.util.Stack;

// @formatter:off
/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
*/

// @formatter:on
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null)
            root = root.right;
        root.right = right;
    }

    public void flatten2(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) {
            return;
        }

        Stack<TreeNode> rightStack = new Stack<TreeNode>();

        root = nextNode(root, rightStack);
    }

    public TreeNode nextNode(TreeNode node, Stack<TreeNode> rightStack) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack = (Stack<TreeNode>) rightStack.clone();
        if (node.right != null) {
            stack.push(node.right);
        }

        if (node.left == null) {
            if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                node.right = nextNode(temp, stack);
            }
        } else {
            node.right = nextNode(node.left, stack);
        }
        node.left = null;
        //System.out.println(node.val);
        return node;
    }
}
