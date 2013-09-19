/*
 * Copyright 2013 SatoShun
 *
 * Facade Pattern
 */

package sample.design_pattern;

import java.util.*;


class Basket {
    private List<String> productList;

    public Basket() {
        productList = new ArrayList<String>();
    }

    public void add(String product) {
        productList.add(product);
    }

    public void clear() {
        productList.clear();
    }

    public List<String> getAll() {
        return productList;
    }
}

class Customer {
    private Basket basket;

    public Customer() {
        basket = new Basket();
    }

    public void add(String product) {
        basket.add(product);
    }

    public Map<String,Integer> getAll() {
        List<String> basketContents = basket.getAll();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String content : basketContents) {
            if (map.containsKey(content)) {
                map.put(content, map.get(content) + 1);
            } else {
                map.put(content, 1);
            }
        }

        return map;
    }
}


class Buying {
    /*
     * facade method
     */
    public void process() {
        Customer customer = new Customer();

        customer.add("meat");
        customer.add("wine");
        customer.add("meat");
        customer.add("meat");

        System.out.println(customer.getAll());
    }
}



class Facade {
    public static void main(String[] args) {
        Buying buying = new Buying();
        buying.process();
    }
}
