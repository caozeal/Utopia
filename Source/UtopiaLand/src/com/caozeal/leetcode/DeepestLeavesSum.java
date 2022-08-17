package com.caozeal.leetcode;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

class DeepestLeavesSum {

    private int deepestLevel = 0;

    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return sum;
    }

    private void deepestLeavesSum(TreeNode node, int level){
        if(node == null){
            return;
        }
        if(level > deepestLevel){
            deepestLevel = level;
            sum = node.val;
        } else if (level == deepestLevel) {
            sum += node.val;
        }
        deepestLeavesSum(node.left, level+1);
        deepestLeavesSum(node.right, level+1);
    }

    public static class TreeNode {
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