/*
 * Copyright 2013 SatoShun
 *
 * Iterator Pattern
 */

package sample.design_pattern;

import java.util.List;
import java.util.ArrayList;


class StoreList implements Iterable<Store> {
    private List<Store> storeList;

    public StoreList(Store... stores) {
        storeList = new ArrayList<Store>();

        for (Store store : stores) {
            storeList.add(store);
        }
    }

    public java.util.Iterator<Store> iterator() {
        return new StoreIterator(storeList);
    }
}


class Store {
    private String name;

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class StoreIterator implements java.util.Iterator<Store> {
    private List<Store> storeList;
    private int index;

    public StoreIterator(List<Store> storeList) {
        this.storeList = storeList;
        index = 0;
    }

    public boolean hasNext() {
        return storeList.size() > index;
    }

    public Store next() {
        return storeList.get(index++);
    }

    public void remove() {
    }
}


class Iterator {
    public static void main(String[] args) {
        StoreList storeList = new StoreList(
            new Store("Grocery"), new Store("Pharmacy"), new Store("Grocery"));

        for (Store store : storeList) {
            System.out.println(store.getName());
        }
    }
}
