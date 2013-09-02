package sample.design_pattern;

import java.util.*;


abstract class Component {
    abstract public void printAll();
    public List<Component> getComponentList() {
        return new ArrayList<Component>();
    }
}


class Directory extends Component {
    private String name;
    private List<Component> children;

    public Directory(String name, Component... args) {
        this.name = name;

        children = new ArrayList<Component>();
        for (Component component : args) {
            children.add(component);
        }
    }

    public void printAll() {
        System.out.println("Directory name: " + name);

        for (Component component : children) {
            component.printAll();
        }
    }

    public List<Component> getComponentList() {
        List<Component> result = new ArrayList<Component>();

        for (Component component : children) {
            result.addAll(component.getComponentList());
        }

        return result;
    }
}

class File extends Component {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void printAll() {
        System.out.println("    file name: " + name);
    }
}


class Composite {
    public static void main(String[] args) {
        Component parent = new Directory("User",
            new Directory("hospital", new File("ouch")),
            new File("hello world"),
            new File("sorry")
        );
        parent.printAll();
    }
}
