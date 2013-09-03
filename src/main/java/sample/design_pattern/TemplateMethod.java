package sample.design_pattern;


interface ITextProcess {
    void printHeader();
    void printBody();
    void printFooter();
}


class HTMLDocument implements ITextProcess {
    private String header;
    private String body;
    private String footer;

    public HTMLDocument(String header, String body, String footer) {
        this.header = header;
        this.body = body;
        this.footer = footer;
    }

    public void printHeader() {
        System.out.println("<head>");
        System.out.println("\t" + header);
        System.out.println("</head>");
    }

    public void printBody() {
        System.out.println("<body>");
        System.out.println("\t" + body);
        System.out.println("</body>");
    }

    public void printFooter() {
        System.out.println(footer);
    }
}

class DocumentOperator {
    private ITextProcess content;

    public DocumentOperator(ITextProcess content) {
        this.content = content;
    }

    public void operate() {
        content.printHeader();
        content.printBody();
        content.printFooter();
    }
}


class TemplateMethod {
    public static void main(String[] args) {
        DocumentOperator client = new DocumentOperator(
            new HTMLDocument("head content", "body content", "footer content"));
        client.operate();
    }
}
