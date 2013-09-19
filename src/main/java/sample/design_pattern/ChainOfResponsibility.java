/*
 * Copyright 2013 SatoShun
 *
 * Chain of responsibility Pattern
 */

package sample.design_pattern;


import java.util.*;


interface IEventHandler {
    boolean process(String message);
}


class Boss implements IEventHandler {
    public boolean process(String message) {
        if (message.equals("boss")) {
            System.out.println("boss appears");
            return true;
        }
        return false;
    }
}


class Enemy implements IEventHandler {
    public boolean process(String message) {
        if (message.contains("enemy")) {
            System.out.println("enemy appears");
            return true;
        }

        return false;
    }
}


class EnemyController {
    List<IEventHandler> handlerList;

    public EnemyController() {
        handlerList = new ArrayList<IEventHandler>();
    }

    public void setEnemy(IEventHandler handler) {
        handlerList.add(handler);
    }

    public void sendMessage(String message) {
        for (IEventHandler handler : handlerList) {
            if (handler.process(message)) {
                break;
            }
        }
    }
}


class ChainOfResponsibility {
    public static void main(String[] args) {
        EnemyController controller = new EnemyController();

        controller.setEnemy(new Enemy());
        controller.setEnemy(new Boss());

        controller.sendMessage("enemy");
        controller.sendMessage("boss");
    }
}
