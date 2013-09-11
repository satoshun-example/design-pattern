/*
 * Copyright 2013 SatoShun
 *
 * Strategy Pattern
 */

package sample.design_pattern;

import java.util.*;


interface ISort {
    void showOrderList(List<Integer> lst);
}


class OrderManager {
    private ISort sorter;
    private List<Integer> lst;

    public OrderManager(List<Integer> lst, ISort sorter) {
        this.lst = lst;
        this.sorter = sorter;
    }

    public void add(Integer other) {
        lst.add(other);
    }

    public void show() {
        sorter.showOrderList(lst);
    }
}


class SortOrder implements ISort {
    public void showOrderList(List<Integer> lst) {
        List<Integer> temp = new ArrayList<Integer>(lst);

        Collections.sort(temp);
        System.out.println(temp);
    }
}


class BubbleSortOrder implements ISort {
    public void showOrderList(List<Integer> lst) {
        List<Integer> temp = new ArrayList<Integer>(lst);

        for (int i = 0; i < temp.size(); i++) {
            for (int j = temp.size() - 1; j > i; j--) {
                if (temp.get(j-1) > temp.get(j)) {
                    Integer s = temp.get(j);
                    temp.set(j, temp.get(j-1));
                    temp.set(j-1, s);
                }
            }
        }

        System.out.println(temp);
    }
}


class Strategy {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager(
            new ArrayList<Integer>() {
                {add(3); add(2); add(1); add(5);}
            }, new SortOrder()
        );
        orderManager.show();

        orderManager = new OrderManager(
            new ArrayList<Integer>() {
                {add(3); add(2); add(1); add(5);}
            }, new BubbleSortOrder()
        );
        orderManager.show();
    }
}
