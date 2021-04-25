package com.corejava.pair;

public class PairTest {

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }

            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Pair<>(min, max);

    }

    public static void main(String[] args) {
        Double[] number = {
                13.0, 39.0, 6.22, 90.3, 12.5, 22.7, 92.2, 78.0
        };
        Pair<Double> pair = minmax(number);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
