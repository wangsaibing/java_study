package com.corejava.pair;

public interface IPair<T> {
    public T getFirst();
    public T getSecond();

    public void setFirst(T firstValue);
    public void setSecond(T secondValue);
}
