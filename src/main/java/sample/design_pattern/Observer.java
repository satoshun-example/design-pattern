package sample.design_pattern;

import java.util.*;


interface INotifyClient {
    void receive(String message);
}


class Publisher {
    List<INotifyClient> clients;

    public Publisher() {
        clients = new ArrayList<INotifyClient>();
    }

    public void allNotifyMessage(String message) {
        for (INotifyClient client : clients) {
            client.receive(message);
        }
    }

    public void subscribe(INotifyClient client) {
        clients.add(client);
    }
}

class Client implements INotifyClient {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void receive(String message) {
        System.out.println("receive message: " + name);
        System.out.println(message);
    }
}


class Observer {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.subscribe(new Client("ken"));
        publisher.subscribe(new Client("tom"));
        publisher.subscribe(new Client("Cathy"));

        publisher.allNotifyMessage("hello world");
    }
}
