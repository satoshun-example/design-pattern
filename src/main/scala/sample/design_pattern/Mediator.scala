/*
 * Copyright 2013 SatoShun
 *
 * Adapter Pattern
 */

package sample.design_pattern;


class Game {
    private var count: Int = 0

    def change(player: IPlayer) = {
        if (player.isInstanceOf[Player]) {
            count += 1
        } else if (player.isInstanceOf[Enemy]) {
            count -= 1
        }
    }

    def getCount(): Int = count
}


trait IPlayer {
    def win(): Unit;
}


class Player(val game: Game) extends IPlayer {
    def win() = {
        game.change(this)
    }
}


class Enemy(val game: Game) extends IPlayer {
    def win() = {
        game.change(this)
    }
}


object Mediator {
    def main(args: Array[String]) = {
        val game: Game = new Game()
        val player: IPlayer = new Player(game)
        val enemy: IPlayer = new Enemy(game)

        player.win()
        player.win()
        println(game.getCount)

        enemy.win()
        println(game.getCount)
    }
}
