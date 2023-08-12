package Lecture3;

import org.w3c.dom.Node;

public class List {
    Node head;
    Node tail;
    // вставка элемента
    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else { // добавление в конец
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
// добавление value после интересующей node
    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode. previous = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    //удаление элемента
    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;
        // head - нода
        if(previous == null){
            next.previous = null;
            head = next;
        } else { // нода - tail
            if(next == null) {
                previous.next = null;
                tail = previous;
            } else {
                // нода в середине
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    // поиск элемента
    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    // разворот двухсвязного списка
    public void revert() {
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            // меняем местами
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public class Node{
        int value;
        Node next;
        Node previous;
    }
}
