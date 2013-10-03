/*
 * Copyright 2013 SatoShun
 *
 * Chain of responsibility Pattern
 */

package sample.design_pattern;


trait IEventHandler {
    def process(key: String, message: String);
}


class HelpMessageBox extends IEventHandler {
    private var child: IEventHandler = null

    def addChild(child: IEventHandler) = this.child = child

    def process(key: String, message: String) = {
        if (key == "Help") {
            println("Operate HelpMessageBox " + message)
        } else {
            child.process(key, message)
        }
    }
}


class DefaultMessageBox extends IEventHandler {
    def process(key: String, message: String) = {
        println("Operate Default " + message)
    }
}


class MessageController(val messageBox: IEventHandler) {
    def sendMessage(key: String, message: String) = {
        messageBox.process(key, message)
    }
}


object ChainOfResponsibility {
    def main(args: Array[String]) = {
        val messageBox = new HelpMessageBox();
        messageBox.addChild(new DefaultMessageBox())
        val messageController = new MessageController(messageBox)
        messageController.sendMessage("Help", "please help me")
        messageController.sendMessage("Hoge", "hogehoge")
    }
}
