package com.dsaat;

import java.util.Objects;
import java.util.Stack;

public class Dome01 {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        Node node11 = new Node(0, "张三1");
        Node node12 = new Node(2, "李四1");
        Node node13 = new Node(4, "王五1");
        Node node21 = new Node(1, "张三2");
        Node node22 = new Node(3, "李四2");
        Node node23 = new Node(5, "王五2");

        // 按顺序添加测试
        singlyLinkedList1.addOderBy(node11);
        singlyLinkedList1.addOderBy(node12);
        singlyLinkedList1.addOderBy(node13);
        singlyLinkedList2.addOderBy(node21);
        singlyLinkedList2.addOderBy(node22);
        singlyLinkedList2.addOderBy(node23);
        System.out.println(singlyLinkedList1);
        System.out.println(singlyLinkedList2);

        // 合并后
        System.out.println("---合并后---");
        SinglyLinkedList singlyLinkedList = SinglyLinkedList.mergeLinkedList(singlyLinkedList1, singlyLinkedList2);
        System.out.println(singlyLinkedList);

    }
}

/**
 * 单链表
 */
class SinglyLinkedList{
    private final Node headNode;

    public SinglyLinkedList() {
        this.headNode = new Node(null,null);
    }
    public SinglyLinkedList(Node node){
        this.headNode = node;
    }

    /**
     * 不按顺序添加
     * @param node
     */
    public void add(Node node){
        Node temp = headNode;
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
        Node temp = headNode;
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

    /**
     * 删除数据
     * @param id 要删除数据对应的id
     * @return 删除的node
     */
    public Node delete(int id){
        Node temp = headNode;
        boolean flag = false;

        while (true){
            if(temp.next == null){break;}

            if(temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            Node oldNode = temp.next;
            temp.next = temp.next.next;
            System.out.printf("id为%d的Node已经删除\n", id);
            return oldNode;
        }else {
            System.out.printf("未找到id为%d的Node", id);
            return null;
        }
    }

    /**
     * 修改数据
     * @param node 修改的node
     */
    public void update(Node node){
        Node temp = headNode;
        boolean flag = false;

        while (true){
            // 遍历到空时，直接停止
            if(temp.next == null){break;}
            // 找到node.id和temp.id相同
            if(Objects.equals(node.id, temp.next.id)){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            // 如果id相同可以修改，就直接把找到的节点用新节点替换掉
            // 1. 把原来的节点的next赋给修改节点的next
            node.next = temp.next.next;
            // 2. 再把找到节点的上一个节点指向新的节点
            temp.next = node;
            System.out.printf("id为%d的Node修改成功!\n", node.id);
        }else {
            System.out.printf("id为%d的Node未找到!\n", node.id);
        }
    }

    /**
     * 查找数据
     * @param id 要查找数据的id
     * @return 查找的node
     */
    public Node findNode(int id){
        Node temp = headNode;
        boolean flag = false;

        while (true){
            if(temp.next == null){break;}

            if(temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.printf("id为%d的Node已找到\n", id);
            return temp.next;
        }else {
            System.out.printf("未找到id为%d的Node", id);
            return null;
        }
    }

    /**
     * 得到链表中的节点个数
     * @return 节点数
     */
    public int size(){
        Node temp = headNode;
        int length = 0;
        if(temp.next == null){return 0;}

        while (temp.next != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    

    /**
     * 获取倒数第K个节点
     * @param k 倒数K
     * @return 节点
     */
    public Node getLastKNode(int k){
        Node temp = headNode.next;
        if(temp == null || size() < k){return null;}
        for(int i = 0; i < size() - k; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取反转后的单链表
     * @return 返回反转后的单链表
     */
    public SinglyLinkedList reversal(){
        // 判断链表是否为空
        if(headNode.next == null){
            System.out.println("单链表为空，不能反转");
            return null;
        }

        Node node = headNode.next; // 节点
        Node next;  // 用来保存下一个节点
        Node reversalNode = new Node(null,null); // 反转后的节点头
        while (node != null){
            // 1. 把节点的指向赋给下一个节点的临时变量，用来保存该节点的下一个节点，防止单链表断开
            next = node.next;
            // 2. 把反转头节点的指向赋给节点的指向
            node.next = reversalNode.next;
            // 3. 让反转头的指向指向到节点
            reversalNode.next = node;
            node = next;
        }
        return new SinglyLinkedList(reversalNode);
    }

    /**
     * 从尾部打印单链表，反向遍历版
     */
    public void printFromTail(){
        Node temp;
        // 从头遍历到尾取最后一个进行打印
        for(int i = 0; i < size(); i++){
            temp = headNode;
            for (int j = 0; j < size() - i; j++) {
                temp = temp.next;
            }
            System.out.println(temp);
        }
    }

    /**
     * 从尾部打印单链表，栈版
     */
    public void printFromTailUserStack(){
        Node temp = headNode.next;
        Stack<Node> nodes = new Stack<>();
        while(temp != null){
            nodes.push(temp);
            temp = temp.next;
        }

        while(nodes.size() > 0){
            System.out.println(nodes.pop());
        }
    }


    @Override
    public String toString() {
        StringBuilder linkedList = new StringBuilder();
        Node temp = headNode;
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

    /**
     * 合并两个有顺序的单链表
     * @param linkedList1 链表1
     * @param linkedList2 链表2
     * @return 合并后的链表
     */
    public static SinglyLinkedList mergeLinkedList(SinglyLinkedList linkedList1, SinglyLinkedList linkedList2){
        // 首先看一下两个链表是否为空，如果是空的话，就直接返回另一个链表，都是空，则返回null
        if(linkedList1.size() == 0 || linkedList2.size() == 0){
            if(linkedList1.size() != 0){
                return linkedList1;
            } else if (linkedList2.size() != 0) {
                return linkedList2;
            }
            return null;
        }
        // 都不等于空就可以开始合并，遍历一个链表的节点插入到另一个链表中
        Node node2 = linkedList2.getHeadNode().next;
        Node next;
        // 可以直接利用有序插入的方法，遍历节点2然后插入到节点1中
        while (node2 != null) {
            next = node2.next;
            linkedList1.addOderBy(node2);
            node2 = next;
        }
        return linkedList1;

    }

    /**
     * 获取头节点
     * @return 头节点
     */
    public Node getHeadNode() {
        return headNode;
    }
}

/**
 * 节点类
 */
class Node{
    public Integer id;
    public String data;
    public Node next = null;

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
