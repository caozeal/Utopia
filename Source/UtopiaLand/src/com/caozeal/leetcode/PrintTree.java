package com.caozeal.leetcode;

import java.util.ArrayList;
import java.util.List;

class PrintTree {
    public List<List<String>> printTree(TreeNode root) {
        int height = processHeight(root, -1);
        List<List<String>> matrix = initMatrix(height);
        processTree(root, height, 0, matrix);
        return matrix;
    }

    private  List<List<String>> initMatrix(int height){
        List<List<String>> matrix = new ArrayList<>(height+1);
        for (int i = 0; i < height+1; i++) {
            List<String> row = new ArrayList<>((1 << (height+1)) - 1);
            for (int j = 0; j < (1 << (height+1)) - 1; j++) {
                row.add("");
            }
            matrix.add(row);
        }
        return matrix;
    }

    private int processHeight(TreeNode node, int height){
        if(node == null){
            return height;
        }
        int leftHeight = processHeight(node.left, height+1);
        int rightHeight = processHeight(node.right, height+1);
        return Integer.max(leftHeight, rightHeight);
    }

    private void processTree(TreeNode node, int h, int order, List<List<String>> matrix){
        if(node == null){
            return;
        }
        List<String> row = matrix.get(matrix.size() - h);
        row.set((1 << h) - 1 + order*(1 << (h+1)), node.val+"");
        processTree(node.left, h-1, order*2, matrix);
        processTree(node.right, h-1, order*2 +1, matrix);
    }

   static class TreeNode {
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
