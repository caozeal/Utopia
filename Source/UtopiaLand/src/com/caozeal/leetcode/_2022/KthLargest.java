package com.caozeal.leetcode._2022;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author Zhiyong Cao
 * @since 1.0.0
 */
public class KthLargest {

    private int _k;

    public int kthLargest(TreeNode root, int k) {
        _k = k;
        return kthLargest(root);
    }

    public int kthLargest(TreeNode node) {
        if(node.right != null){
            int i = kthLargest(node.right);
            if(_k == 0){
                return i;
            }
        }
        if(--_k == 0){
            return node.val;
        }
        if(node.left != null){
            return kthLargest(node.left);
        }
        return -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
