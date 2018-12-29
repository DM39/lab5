import java.util.*;

public class Task1 {

    public static void time(int size){

        ArrayList<Integer> arraylist = new ArrayList<>();
        LinkedList<Integer> linkedlist = new LinkedList<>();
        TreeSet<Integer> treeset = new TreeSet<>();
        HashSet<Integer> hashset = new HashSet<>();

        System.out.print("Add Time of:\n" +
                "Array List  - " + AddTime(arraylist,size) + " ns\n" +
                "Linked List - " + AddTime(linkedlist, size) + " ns\n" +
                "Treeset     - " + AddTime(treeset, size) + " ns\n" +
                "Hashset     - " + AddTime(hashset, size) + " ns\n");
        System.out.print("........................................................\n");

        Random rand = new Random();
        System.out.print("Search Time of:\n" +
                "Array List  - " + SearchTime(arraylist,rand.nextInt(size/10)) + " ns\n" +
                "Linked List - " + SearchTime(linkedlist, rand.nextInt(size/10)) + " ns\n" +
                "Treeset     - " + SearchTime(treeset, rand.nextInt(size/10)) + " ns\n" +
                "Hashset     - " + SearchTime(hashset, rand.nextInt(size/10)) + " ns\n");
        System.out.print("........................................................\n");

        System.out.print("Insert Time of:\n" +
                "Array List - " + InsertTime(arraylist,rand.nextInt(size/10)) + " ns\n" +
                "Linked List - " + InsertTime(linkedlist, rand.nextInt(size/10)) + " ns\n");
        System.out.print("........................................................\n");

        System.out.print("Remove Time of:\n" +
                "Array List  - " + RemoveTime(arraylist) + " ns\n" +
                "Linked List - " + RemoveTime(linkedlist) + " ns\n" +
                "Treeset     - " + RemoveTime(treeset) + " ns\n" +
                "Hashset     - " + RemoveTime(hashset) + " ns\n");
        System.out.print("........................................................\n");

    }

    private static long AddTime(Collection<Integer> collection, int count) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            collection.add(i);
        }
        long end = System.nanoTime();
        return  end - start;
    }

    private static long InsertTime(List<Integer> list, int count) {
        long start = System.nanoTime();
        list.add(count,count);
        long end = System.nanoTime();
        return  end - start;
    }

    private static long SearchTime(Collection<Integer> collection, int value) {
        long start = System.nanoTime();
        collection.contains(value);
        long end = System.nanoTime();
        return  end - start;
    }

    private static long RemoveTime(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i = 0; i <collection.size(); i++) {
            collection.remove(i);
        }
        long end = System.nanoTime();
        return  end - start;
    }


}
/* Выводы:
1. Время добавления. В порядке уменьшения скорости: HS, AL, LL, (пропасть), TS
1.1 Вставка. Вставка у LL и AL осуществляет за примерно равное время, хотя в AL все же быстрее
2. Поиск. Самый быстрый поиск, вне конкуренции, у HS, дальше идет AL, который на 25-50% быстрее LL. TS заметно отстает.
3. Удаление. Чемпион по самоочищению - LL. Второе место у HS. Третье у AL. Замыкает, как всегда TS.
Главный вывод: Зачем, блин, вообще нужен тогда TreeSet?
*/



// Эксперимент, освещенный кодом ниже, ничего существенно не изменил в выводе
/*System.out.print("Random Add Time of:\n" +
                "Array List  - " + RandomAddTime(arraylist,size) + " ns\n" +
                "Linked List - " + RandomAddTime(linkedlist, size) + " ns\n" +
                "Treeset     - " + RandomAddTime(treeset, size) + " ns\n" +
                "Hashset     - " + RandomAddTime(hashset, size) + " ns\n");
        System.out.print("........................................................\n");

        private static long RandomAddTime(Collection<Integer> collection, int count) {
        Random rand = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            collection.add(rand.nextInt());
        }
        long end = System.nanoTime();
        return  end - start - AverageRandom(count)*count;
    }
    private static long AverageRandom(int count){
        Random rand = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            rand.nextInt(count);
        }
        long end = System.nanoTime();
        return (end-start)/count;
    } */