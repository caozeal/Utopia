package com.caozeal.leetcode._2022;

public class LongestPath {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftLength = dfs(node.left)+1;
        int rightLength = dfs(node.right)+1;
        if(node.left == null || node.val != node.left.val){
            leftLength = 0;
        }
        if(node.right == null || node.val != node.right.val){
            rightLength = 0;
        }
        int nodeLength = leftLength + rightLength;
        if(nodeLength > max){
            max = nodeLength;
        }
        return Math.max(leftLength, rightLength);
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
