package com.dsaat;

public class Dome01 {
    public static void main(String[] args) {
        CircularSinglyLinkedList linkedList = new CircularSinglyLinkedList();
        linkedList.add(4);
        linkedList.show();
        linkedList.countNode(3,2,4);
    }
}

/**
 * 环形单向链表
 */
class CircularSinglyLinkedList{
    private Node first = null;

    /**
     * 添加指定数量的链表
     * @param num 节点数量
     */
    public void add(int num){
        if(num < 0){
            System.out.println("请输入大于0的数");
            return;
        }

        Node curNode = null;
        // 循环num次，创建num个节点
        for(int i = 1; i <= num; i++){
            Node node = new Node(i);
            // 第一次first是null，所以把第一个节点给他
            if(first == null){
                first = node;
                first.setNode(first);
                curNode = first;
            }else {
                // 设置curNode指向的节点
                curNode.setNode(node);
                // 设置node的next指向first
                node.setNode(first);
                // 把curNode后移
                curNode = curNode.getNode();
            }
        }

    }

    /**
     * 遍历链表
     */
    public void show(){
        Node curNode = first;
        while (true){
            System.out.println("id=" + curNode.getId() + " " + curNode);
            if(curNode.getNode() == first){
                break;
            }
            curNode = curNode.getNode();

        }
    }

    /**
     * 数Node
     * @param startNode 开始的节点
     * @param countNum 数多少出一次
     * @param nodeNum 节点的个数
     */
    public void countNode (int startNode, int countNum, int nodeNum){
        // 判断是否满足数数条件
        if(startNode < 0 || startNode > nodeNum){
            System.out.println("输入不合法");
            return;
        }
        Node cur = null;
        Node first = this.first;
        while (first.getId() != startNode){
            cur = first;
            first = first.getNode();
        }
        while (cur != first){
            for(int i = 0; i < countNum - 1; i++){
                cur = first;
                first = first.getNode();
            }
            System.out.println(first);
            first = first.getNode();
            cur.setNode(first);
        }
        System.out.println(first);
    }
}

/**
 * 节点
 */
class Node{
    private Integer id;
    private Node node;

    public Node() {
    }

    public Node(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Node getNode() {
        return node;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
