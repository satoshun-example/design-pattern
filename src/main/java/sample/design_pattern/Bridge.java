/*
 * Copyright 2013 SatoShun
 *
 * Bridge Pattern
 */

package sample.design_pattern;

/*
 * Bridge Pattern
 *
 * interface: 1, class: 4
 */
interface IConnector {
    void showHeader();
}


class Document {
    protected IConnector connector;

    public Document(IConnector connector) {
        this.connector = connector;
    }

    public void show() {
        connector.showHeader();
    }
}


class NewDocument extends Document {
    public NewDocument(IConnector connector) {
        super(connector);
    }

    public void showThis() {
        System.out.println(this);
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

/*
 * no Bridge Pattern
 *
 * interface: 1, abstract class: 2, class 4
 */
interface IConnector2 {
    void showHeader();
}


abstract class Document2 {
    abstract public void show();
}


abstract class NewDocument2 extends Document2 {
    public void showThis() {
        System.out.println(this);
    }
}


class HTMLDocument2 extends Document2 {
    public void show() {
        System.out.println("<head></head>");
    }
}


class XMLDocument2 extends Document2 {
    public void show() {
        System.out.println("<?xml version='1.0'?>");
    }
}


class NewHTMLDocument2 extends NewDocument2 {
    public void show() {
        System.out.println("<head></head>");
    }
}


class NewXMLDocument2 extends NewDocument2 {
    public void show() {
        System.out.println("<?xml version='1.0'?>");
    }
}


class Bridge {
    public static void main(String[] args) {
        Document document = new Document(new PartsHTML());
        document.show();
        HTMLDocument2 document2 = new HTMLDocument2();
        document2.show();
        NewHTMLDocument2 newDocument2 = new NewHTMLDocument2();
        newDocument2.show();
    }
}
