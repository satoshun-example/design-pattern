/*
 * Copyright 2013 SatoShun
 *
 * Mediator Pattern
 */

package sample.design_pattern;

class Game {
    private IPlayer player;
    private IPlayer enemy;

    private int count;

    public Game() {
        count = 0;
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    public void setEnemy(IPlayer enemy) {
        this.enemy = enemy;
    }

    public void change(IPlayer actionPlayer) {
        if (actionPlayer instanceof Player) {
            count += 1;
        } else if (actionPlayer instanceof Enemy) {
            count -= 1;
        }
    }

    public int getCount() {
        return count;
    }
}


interface IPlayer {
    void win();
}


class Player implements IPlayer {
    private Game game;

    public Player(Game game) {
        this.game = game;
    }

    public void win() {
        game.change(this);
    }
}


class Enemy implements IPlayer {
    private Game game;

    public Enemy(Game game) {
        this.game = game;
    }

    public void win() {
        game.change(this);
    }
}


class Mediator {
    public static void main(String[] args) {
        Game game = new Game();
        IPlayer player = new Player(game);
        IPlayer enemy = new Enemy(game);

        enemy.win();
        System.out.println(game.getCount());

        enemy.win();
        System.out.println(game.getCount());

        player.win();
        System.out.println(game.getCount());
    }
}
