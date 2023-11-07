package Seminars.Seminar4;

public class HashTable<K, V> {
    private class Bucket<K, V> {
        // у связного списка дб root
        Node root;

        public boolean add(K key, V value) {
            if (root == null) {
                root = new Node(key, value);
                return true;
            }
            Node currentNode = root;
            while (currentNode.next != null) {
                // проверяем на добавление одинаковых ключей
                if (currentNode.pair.key == key) {
                    return false;
                }
                currentNode = currentNode.next;
            }
            // т.к. в while не проверится последний элемент, то проверим его здесь
            if (currentNode.pair.key == key) {
                return false;
            }
            // как проверили последний элемент, создаем новую ноду
            currentNode.next = new Node(key, value);
            return false;
        }

        public boolean remove(K key) {
            if (root == null) {
                return false;
            }
            // проверка на неудаление root
            if (root.pair.key == key) {
                root = root.next;
                return true;
            }
            Node currentNode = root;
            while (currentNode.next != null) {
                if (currentNode.next.pair.key == key) {
                    currentNode.next = currentNode.next.next;
                    return true;
                }
                currentNode = currentNode.next;
            }
            // если прошлись по всем значениям и ничего не удалили
            return false;
        }

        public V getValue(K key) {
            Node currentNode = root;
            while (currentNode != null)
                if (currentNode.pair.key == key) {
                    return currentNode.pair.value;
                } else {
                    currentNode = currentNode.next;
                }
            return null;
        }
        public boolean setValue(K key, V value){
            Node currentNode = root;
            while (currentNode != null) {
                if (currentNode.pair.key == key) {
                    currentNode.pair.value = value;
                    return true;
                }
                    currentNode = currentNode.next;
                }
            return false;
        }

        private class Node {
            Pair pair;
            Node next;

            Node(K key, V value) {
                pair = new Pair(key, value);
            }

            // конструктор - указание на след ноду
            Node(K key, V value, Node next) {
                pair = new Pair(key, value);
                this.next = next;
            }
        }

        private class Pair {
            K key;
            V value;

            Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }

}
