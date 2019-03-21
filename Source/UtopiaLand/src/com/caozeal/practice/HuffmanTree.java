package com.caozeal.practice;

import java.util.*;

public class HuffmanTree {

    public static class Node<E> {
        E data;
        double weight;
        Node leftChild;
        Node rightChild;
        String code;

        Node(E data, double weight) {
            super();
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[data=" + data + ", weight=" + weight + "]";
        }
    }

    public static void main(String[] args) {
        String s = "abbcccdddd";
        List<Node> nodes = initNodes(s);

        Node root = HuffmanTree.createTree(nodes);
        Map<String, String> map = initCode(root);
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            String sub = s.substring(i, i + 1);
            result.append(map.get(sub));
        }
        System.out.println(result);
    }

    private static List<Node> initNodes(String s){
        Map<String, Double> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            String sub = s.substring(i, i+1);
            if(map.containsKey(s.substring(i, i+1))){
                Double value = map.get(sub);
                map.replace(sub, value+1);
                continue;
            }
            map.put(sub, 1d);
        }
        List<Node> nodes = new ArrayList<>();
        for(Map.Entry<String, Double> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 构造哈夫曼树
     *
     * @param nodes
     *            节点集合
     * @return 构造出来的哈夫曼树的根节点
     */
    private static Node createTree(List<Node> nodes) {
        // 只要nodes数组中还有2个以上的节点
        while (nodes.size() > 1) {
            quickSort(nodes);
            //获取权值最小的两个节点
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);

            //生成新节点，新节点的权值为两个子节点的权值之和
            Node parent = new Node(null, left.weight + right.weight);

            //让新节点作为两个权值最小节点的父节点
            parent.leftChild = left;
            parent.rightChild = right;

            //删除权值最小的两个节点
            nodes.remove(nodes.size()-1);
            nodes.remove(nodes.size()-1);

            //将新节点加入到集合中
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    private static Map<String, String> initCode(Node<String> root){
        StringBuilder sb = new StringBuilder();
        root.code = sb.toString();
        Queue<Node> queue = new ArrayDeque<>();
        Map<String, String> map = new HashMap<>();

        if(root!=null){
            //将根元素加入“队列”
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            Node<String> p = queue.poll();
            if(p.data != null){
                map.put(p.data, p.code);
            }

            //如果左子节点不为null，将它加入到队列
            if(p.leftChild != null){
                p.leftChild.code = new StringBuilder(p.code).append("0").toString();
                queue.offer(p.leftChild);
            }

            //如果右子节点不为null，将它加入到队列
            if(p.rightChild != null){
                p.rightChild.code = new StringBuilder(p.code).append("1").toString();
                queue.offer(p.rightChild);
            }
        }

        return map;
    }

    /**
     * 将指定集合中的i和j索引处的元素交换
     *
     * @param nodes
     * @param i
     * @param j
     */
    private static void swap(List<Node> nodes, int i, int j) {
        Node tmp;
        tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    /**
     * 实现快速排序算法，用于对节点进行排序
     *
     * @param nodes
     * @param start
     * @param end
     */
    private static void subSort(List<Node> nodes, int start, int end) {
        if (start < end) {
            // 以第一个元素作为分界值
            Node base = nodes.get(start);
            // i从左边搜索，搜索大于分界值的元素的索引
            int i = start;
            // j从右边开始搜索，搜索小于分界值的元素的索引
            int j = end + 1;
            while (true) {
                // 找到大于分界值的元素的索引，或者i已经到了end处
                while (i < end && nodes.get(++i).weight >= base.weight)
                    ;
                // 找到小于分界值的元素的索引，或者j已经到了start处
                while (j > start && nodes.get(--j).weight <= base.weight)
                    ;

                if (i < j) {
                    swap(nodes, i, j);
                } else {
                    break;
                }
            }

            swap(nodes, start, j);

            //递归左边子序列
            subSort(nodes, start, j - 1);
            //递归右边子序列
            subSort(nodes, j + 1, end);
        }
    }

    private static void quickSort(List<Node> nodes){
        subSort(nodes, 0, nodes.size()-1);
    }
}