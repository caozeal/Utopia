package com.caozeal.leetcode.before20230224;

public class EvaluateTree {

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node){
        if(node.left == null){
            return node.val != 0;
        }
        if(node.val == 2){
            return dfs(node.left) || dfs(node.right);
        }
        return dfs(node.left) && dfs(node.right);
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
