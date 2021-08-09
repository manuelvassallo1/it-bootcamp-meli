package java_3.practicaTT.src.com.meli;

import java.util.Comparator;

public interface Sorter<T> {
    public void sort(T[] arr, Comparator<T> c);
}
