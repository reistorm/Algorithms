package Seminars.Seminar4;

public class HashTable<K, V> {
    // load_size - коэффициент заполненности таблицы
    // чем больше пустых ячеек, тем меньше шанс попасть в пустую
    private static  final double load_size = 0.75;
    private int size;
    // создадим массив buckets
    private Bucket<K, V>[] buckets;
    // выделим память для buckets
    HashTable() {
        // все ячейки будут заполнены null
        buckets = new Bucket[8];
    }
    private int calculateIndex(K key){
        // метод высчитывания хеш-кода. ограничим хеш-код длиной массива и берем модуль его
        return Math.abs(key.hashCode() % buckets.length);
    }
    public boolean add(K key, V value){
        // когда заполненных элементов станет больше, чем ячеек в массиве,
        // то увеличим количество ячеек функцией resize
        if(buckets.length * load_size <= size) {
            resize();
        }
        int index = calculateIndex(key);
        if(buckets[index]== null){
            buckets[index] = new Bucket<>();
        }
        boolean result = buckets[index].add(key, value);
        if (result) //если увеличиться, то увеличить длину массива
            size++;
        return result;
    }
    public boolean remove(K key){
        int index = calculateIndex(key);
        if(buckets[index] == null){
            return false;
        }
        boolean result = buckets[index].remove(key);
        if (result)
            size--;
        return result;
    }
    // в resize надо пересоздавать массив
    private void resize() {
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Bucket<K, V> bucket = old[i];
            if (bucket == null)
                continue;
            Bucket.Node node = bucket.root;
            while(node != null) {
                this.add((K) node.pair.key, (V) node.pair.value);
                node = node.next;
            }
            old[i] = null;
        }
        old = null;
    }
    public void print() {
        for (var item: buckets) {
            if (item != null){
                item.print();
                System.out.println();
            }else {
                System.out.println("-----");
            }

        }
    }


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
        public void print() {
            Node node = root;
            while(node != null ){
                System.out.println("[" + node.pair.key + ";" + node.pair.value + "]");
                node = node.next;
            }
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
