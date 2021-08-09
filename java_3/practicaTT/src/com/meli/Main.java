package java_3.practicaTT.src.com.meli;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main {
    private static final Timer timer = new Timer();

    public static void main(String[] args) {
        Sorter<Object> sorterBubble = MiFactory.getInstance("sorterBubble");
        Sorter<Object> sorterHeap = MiFactory.getInstance("sorterHeap");
        Sorter<Object> sorterQuick = MiFactory.getInstance("sorterQuick");

        Comparator<Object> c = Comparator.comparing(Object::hashCode);

        Integer[] arrInt = {2, 1, 3, 5, 4};
        String[] arrString = {"AA", "CC", "BB", "FF", "DD"};

        sorterHeap.sort(arrInt, c);
        sorterHeap.sort(arrString, c);
        printOrderedArray(arrInt);
        printOrderedArray(arrString);

        Object[] arrBig1 = createArray();
        System.out.println("BubbleSort tardo: " + getElapsedTime(sorterBubble, c, arrBig1) + " ms");
        Object[] arrBig2 = createArray();
        System.out.println("HeapSort tardo: " + getElapsedTime(sorterHeap, c, arrBig2) + " ms");
        Object[] arrBig3 = createArray();
        System.out.println("QuickSort tardo: " + getElapsedTime(sorterQuick, c, arrBig3) + " ms");

        printOrderedArray(arrBig2);
    }

    private static long getElapsedTime(Sorter<Object> sorter, Comparator<Object> c, Object[] arrBig) {
        timer.start();
        sorter.sort(arrBig, c);
        timer.stop();
        return timer.elapsedTime();
    }

    private static void printOrderedArray(Object[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static Object[] createArray() {
        return new Random()
                .ints(100000, 1, 100000)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray();
    }
}
