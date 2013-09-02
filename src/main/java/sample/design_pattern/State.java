package sample.design_pattern;


class BookFactory {
    public static Book factory(String type) {
        if (type.equals("novel")) {
            return new Novel();
        } else if (type.equals("fairyTale")) {
            return new FairyTale();
        }
        return null;
    }
}

abstract class Book {
    abstract void read();
}


class Novel extends Book {
    public void read() {
        System.out.println("A novel is a long prose narrative that describes fictional ...");
    }
}


class FairyTale extends Book {
    public void read() {
        System.out.println("For a comparison of fairy tale with other kinds of stories ...");
    }
}


class State {
    public static void main(String[] args) {
        Book book = BookFactory.factory("novel");
        book.read();

        Book book2 = BookFactory.factory("fairyTale");
        book2.read();
    }
}
