package Lecture;

public class lecture2quicksort {
    int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};

    public static void sort(int[] array, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rigthPosition = endPosition;
        int pivot = array[(startPosition + endPosition)/ 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rigthPosition] > pivot) {
                rigthPosition--;
            }
            if (leftPosition <= rigthPosition) {
                if (leftPosition < rigthPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rigthPosition];
                    array[rigthPosition] = temp;
                }
                leftPosition++;
                rigthPosition--;
            }
        }
        while (leftPosition <= rigthPosition);
        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if (startPosition < rigthPosition) {
            sort(array, startPosition, rigthPosition);
        }
    }
}


