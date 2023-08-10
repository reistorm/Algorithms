package Lecture;

public class lecture2 {
    public static void main(String[] args) {
        // пузырьковая сортировка
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        // сортировка выбором
        int[] arr = new int[]{4, 2, 2, 5, 66, 4, 7, 6};
        directSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // сортировка вставкой
        insertSort(array);
        System.out.println();
        // простой поиск
        System.out.println(find(arr, 66));
        // бинарный поиск
        System.out.println(binarySearch(array, 1, 0, array.length - 1));
    }

    // бинарный поиск
    public static int binarySearch(int[] array, int value){
        return binarySearch(array, value, 0, array.length - 1);
    }
    // пузырьковая сортировка

    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    finish = false;
                }
            }
        }
        while (!finish);

    }

    // сортировка выбором
    public static void directSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPosition]) {
                    minPosition = j;
                }
            }
            if ( i != minPosition) {
                int temp = arr[i];
                arr[i] = arr[minPosition];
                minPosition = temp;
            }
        }
    }
    // сортировка вставками
    public static void insertSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++){
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    // алгоритмы поиска. Простой перебор
    public static int find(int[] arr, int value){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    // бинарный поиск (лучше с помощью рекурсии)
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;
        if (max < min) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }
        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        } else {
            if (array[midPoint] > value) {
                return binarySearch(array, value, min, midPoint -1);
            } else {
                return midPoint;
            }
        }
    }

}
