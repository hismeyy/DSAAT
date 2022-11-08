package com.dsaat;

public class Dome01 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node node1 = new Node(0, "张三");
        Node node2 = new Node(1, "李四");
        Node node3 = new Node(2, "王五");
        Node node4 = new Node(3, "赵六");
        Node node5 = new Node(2, "赵器");

        // 不按顺序添加测试
//        singlyLinkedList.add(node1);
//        singlyLinkedList.add(node2);
//        singlyLinkedList.add(node3);
//        singlyLinkedList.add(node4);

        // 按顺序添加测试
        singlyLinkedList.addOderBy(node1);
        singlyLinkedList.addOderBy(node4);
        singlyLinkedList.addOderBy(node5);
        singlyLinkedList.addOderBy(node2);
        singlyLinkedList.addOderBy(node3);

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
     * 不按顺序添加
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

    /**
     * 按顺序添加添加
     * @param node
     */
    public void addOderBy(Node node){
        Node temp = HEAD_NODE;
        boolean flag = false;   //表示id是否存在
        while(true){
            if(temp.next == null){
                // 如果是空说明到了最后一个
                break;
            }

            if(temp.next.id > node.id){
                break;
            }else if(temp.next.id.equals(node.id)){
                // 如果相等，就不添加
                flag = true;
                break;
            }
            // 向后移动
            temp = temp.next;
        }

        if(!flag){
            // 1. 先把原先的temp的next放到node的next
            node.next = temp.next;
            // 2. 再把temp的next变为node
            temp.next = node;
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
