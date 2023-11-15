package Seminars.Seminar4;

public class Main {
    public static void main(String[] args) {
//        String str = "Abc";
//        String str2 = "AGH";
//
//        Integer num = 91;
//        // дб Integer, с int не прокатит
//        //int number = 41;
//
//        System.out.println(num.hashCode());
//        //System.out.println(number.hashCode());
//        System.out.println(str.hashCode() % 4); //65602
//        System.out.println(str2.hashCode() % 4); //65602

        HashTable<String, Integer> table = new HashTable<>();
        table.add("D", 5);
        table.add("K", 9);
        table.add("H", 1);
        table.add("C", 6);
        table.add("Q", 3);
        table.add("U", 0);
        table.add("R", 7);


        table.print();
    }
}


