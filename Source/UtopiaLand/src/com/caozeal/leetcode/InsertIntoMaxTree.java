package com.caozeal.leetcode;

public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode target = new TreeNode(val);
        if(root == null){
            return target;
        }
        if(root.val < val){
            target.left = root;
            return target;
        }
        TreeNode current = root;
        while (current.right != null && current.right.val > val){
            current = current.right;
        }
        target.left = current.right;
        current.right = target;
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
