package com.dsaat;

public class Dome01 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node node1 = new Node(0, "张三");
        Node node2 = new Node(1, "李四");
        Node node3 = new Node(2, "王五");
        Node node4 = new Node(3, "赵六");

        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);
        singlyLinkedList.add(node4);

        System.out.println(singlyLinkedList);
    }
}

/**
 * 单链表
 */
class SinglyLinkedList{
    private static final Node HEAD_NODE = new Node(null,null);

    public SinglyLinkedList() {
    }

    /**
     * 添加
     * @param node
     */
    public void add(Node node){
        Node temp = HEAD_NODE;
        while(true){
            if(temp.next == null){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder linkedList = new StringBuilder();
        Node temp = HEAD_NODE;
        while(true){
            if(temp.next != null){
                linkedList.append("[").append(temp.next).append("]\n");
                temp = temp.next;
            }else {
                break;
            }

        }
        return linkedList.toString();
    }
}

/**
 * 节点类
 */
class Node{
    public Integer id;
    public String data;
    public Node next;

    public Node(Integer id, String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node = {" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
