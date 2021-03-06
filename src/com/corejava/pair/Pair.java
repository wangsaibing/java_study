package com.corejava.pair;

public class Pair<T> implements IPair<T> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    public void setFirst(T firstValue) {
        this.first = firstValue;
    }
    public void setSecond(T secondValue) {
        this.second = secondValue;
    }

}
