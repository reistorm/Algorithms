//package Lecture3;
//
//// разворот односвязного списка
//
//import org.w3c.dom.Node;
//
//public class ReversalOfSingleLinkedList {
//    private Node head;
//    private Node tail;
//
//    public class List {
//        Node head;
//        Node tail;
//    }
//    public void revert(){
//        if( head != null && head.next != null){
//            Node temp = head;
//            revert(head.next, head);
//            temp.next = null;
//        }
//    }
//    private void revert(Node currentNode, Node previousNode){
//        //когда дойдем до конца надо обновить head
//        if(currentNode.next == null){
//            head = currentNode;
//        } else {
//            revert(currentNode.next, currentNode);
//        }
//        currentNode.next = previousNode;
//        previousNode.next = null;
//    }
//    public class Node {
//        public Node previous;
//        int value;
//        Node next;
//    }
//    public void push(int value){
//        // добавим элемент в начало списка
//        Node node = new Node();
//        node.value = value;
//        node.next = head;
//        head = node;
//    }
//
//    // СТЕК, pop - извлечение данных,не принимает аргументов, извлекает последний элемент
//    public Integer pop() {
//        Integer result = null;
//        if (head != null){
//            result = head.value;
//            head = head.next;
//        }
//        return result;
//    }
//    // ОЧЕРЕДЬ
//    public void push1(int value){
//        Node node = new Node();
//        node.value = value;
//        node.next = head;
//        head.previous = node;
//        head = node;
//    }
//    public Integer peek(){
//        Integer result = null;
//        if (tail != null ){
//            result = tail.value;
//            tail.previous.next = null;
//            tail = tail.previous;
//        }
//        return result;
//    }
//}
