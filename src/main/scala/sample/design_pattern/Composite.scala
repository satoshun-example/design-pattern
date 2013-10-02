/*
 * Copyright 2013 SatoShun
 *
 * Composite Pattern
 */

package sample.design_pattern;


trait Component {
    def printAll(): Unit;

    def getComponentList(): List[Component] = {
        List.empty[Component]
    }
}


class Directory(val name: String, val args: Component*) extends Component {
    def printAll() = {
        println("Directory name : " + name)

        args.foreach(_.printAll())
    }

    override def getComponentList(): List[Component] = {
        var result = List.empty[Component]

        args.map({e => result = result ::: e.getComponentList()})
        result
    }
}


class File(val name: String) extends Component {
    def printAll() = println("\tfile name : " + name)

    override def getComponentList(): List[Component] = {
        List(this)
    }
}


object Composite {
    def main(args: Array[String]) = {
        val root = new Directory("User",
            new Directory("hospital", new File("ouch")),
            new File("hello world"),
            new File("sorry")
        )
        root.printAll()

        println(root.getComponentList())
    }
}
