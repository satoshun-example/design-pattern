/*
 * Copyright 2013 SatoShun
 *
 * Bridge Pattern
 */

package sample.design_pattern;

// Bridge Pattern

interface IConnector {
    void showHeader();
}


class Document {
    private IConnector connector;

    public Document(IConnector connector) {
        this.connector = connector;
    }

    public void show() {
        connector.showHeader();
    }
}


class PartsHTML implements IConnector {
    public void showHeader() {
        System.out.println("<head></head>");
    }
}


class PartsXML implements IConnector {
    public void showHeader() {
        System.out.println("<?xml version='1.0'?>");
    }
}


class Bridge {
    public static void main(String[] args) {
        Document document = new Document(new PartsHTML());
        document.show();
    }
}
