// линейная сложность
// поиск суммы чисел от 1 до n

public class seminar11 {
    public static void main(String[]args){
        int n = 4;
        long start1 = System.nanoTime();
        sum(n);
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        sum(n);
        long end2 = System.nanoTime();
        long start3 = System.nanoTime();
        sum(n);
        long end3 = System.nanoTime();

        System.out.println(sum(n) + "   " + (end1 - start1));
        System.out.println(sumR(n) + "   " + (end2 - start2));
        System.out.println(sumC(n) + "   " + (end3 - start3));

        // для квадратичной сложности
        // для 1000 время практически одинаковое
        // для 100 первый метод быстрее
        int n = 1000;
        primaryNums(n);
        long start4 = System.nanoTime();
        primaryNums(n);
        long end4 = System.nanoTime();
        long start5 = System.nanoTime();
        primaryNums2(n);
        long end5 = System.nanoTime();

        System.out.println((end4 - start4)/1000);
        System.out.println((end5 - start5)/1000);
        System.out.println();
    }
//    public static int sum(int n){
//        int sum = 0;
//        int i = 1;
//        while (i <= n) {
//            sum += i;
//            i++;
//        }
//        return sum;
//    }
    public static int sum(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += i;

        }
        return sum;
    }

    public static int sumR(int n) {
        if (n < 2)   // оптимизировать меньше 2, возвращать 1, чтобы не считать до 0
            return 1;
        return n + sumR(n - 1);
    }
    // спец формула выведенная
    public static int sumC(int n) {
        return n * (n + 1) / 2;
    }

    public static int sumOpt(int n) {
        if (n < 20)
            return sumR(n);
        return sum(n);
    }
}


// квадратичная сложность
    // тут сложность O(n^2)

    public static void primaryNums(int n) {
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++){
                if (i % j == 0) {
                    flag = false;
                    break; // если хотя бы одно число делится, то оно не мб простым
                }
            }
            if (flag)
                System.out.print(i + " ");
        }
        System.out.println();
    }
    // тут сложность O((n/2)^2), т.к. сократили поиск чисел до половины
    public static void primaryNums2(int n) {
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j < i / 2; j++){
                if (i % j == 0) {
                    flag = false;
                    break; // если хотя бы одно число делится, то оно не мб простым
                }
            }
            if (flag)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}