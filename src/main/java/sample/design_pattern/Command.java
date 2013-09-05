/*
 * Copyright 2013 SatoShun
 *
 * State Pattern
 */

package sample.design_pattern;

/*
 * Command pattern, Example of general
 */

interface ICommand {
    void execute();
}

class ConcreateCommand implements ICommand {
    private Receiver receiver;

    public ConcreateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.create();
    }
}

class ConcreateCommand2 implements ICommand {
    private Receiver receiver;

    public ConcreateCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.delete();
    }
}

class Receiver {
    public void create() {
        System.out.println("create");
    }

    public void delete() {
        System.out.println("delete");
    }
}


class Command {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        (new ConcreateCommand(receiver)).execute();
        (new ConcreateCommand2(receiver)).execute();
    }
}
