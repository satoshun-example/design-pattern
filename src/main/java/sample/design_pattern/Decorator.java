/*
 * Copyright 2013 SatoShun
 *
 * Decorator Pattern
 */

package sample.design_pattern;

import java.util.*;


interface IProducts {
    List<String> getProductList();
    void showProductList();
}


class Products implements IProducts {
    private List<String> productList;

    public Products(List<String> productList) {
        this.productList = productList;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void showProductList() {
        System.out.println(getProductList());
    }
}


/*
 * wrap IProducts inteface instance
 */
class ProductsPrice implements IProducts {
    private static Map<String, Integer> productPriceDict = new HashMap<String, Integer>() {
        {put("meat", 200); put("fish", 150); put("book", 500);}
    };

    private IProducts products;

    public ProductsPrice(IProducts products) {
        this.products = products;
    }

    public List<String> getProductList() {
        List<String> productList = products.getProductList();
        return productList;
    }

    public void showProductList() {
        List<String> productList = getProductList();

        for (int i = 0; i < productList.size(); i++) {
            String product = productList.get(i);
            int price = productPriceDict.get(product) != null ? productPriceDict.get(product) : 100;

            System.out.println(product + " : " + price);
        }
    }
}


class Decorator {
    public static void main(String[] args) {
        IProducts products = new Products(new ArrayList<String>() {
            {add("meat"); add("book"); add("hogehoge");}
        });
        products.showProductList();

        IProducts products2 = new ProductsPrice(products);
        products2.showProductList();
    }
}
