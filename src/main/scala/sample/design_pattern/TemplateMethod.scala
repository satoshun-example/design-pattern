/*
 * Copyright 2013 SatoShun
 *
 * Abstract Factory Pattern
 */

package sample.design_pattern;


trait ITextProcess {
    def printHeader(): Unit;
    def printBody(): Unit;
    def printFooter(): Unit;
}


class HTMLDocument(val header: String, val body: String, val footer: String) extends ITextProcess {
    def printHeader() = {
        println("<head>")
        println("\t" + header)
        println("</head>")
    }

    def printBody = {
        println("<body>")
        println("\t" + body)
        println("</body>")
    }

    def printFooter = {
        println(footer)
    }
}


class DocumentOperator(val content: ITextProcess) {
    def operate() = {
        content.printHeader()
        content.printBody()
        content.printFooter()
    }
}


object TemplateMethod {
    def main(args: Array[String]) = {
        val client = new DocumentOperator(
            new HTMLDocument("head content", "body content", "footer content"));
        client.operate()
    }
}
