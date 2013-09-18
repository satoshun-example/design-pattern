/*
 * Copyright 2013 SatoShun
 *
 * FlyWeight Pattern
 */

package sample.design_pattern;


import java.util.*;


class CharacterFactory {
    static Map<String, Letter> cacheCharacter = new HashMap<String, Letter>();

    public static Letter getInstance(char c) {
        if (!cacheCharacter.containsKey("" + c)) {
            cacheCharacter.put("" + c, new Letter(c));
        }
        return cacheCharacter.get(c);
    }
}


class Letter {
    private char character;

    public Letter(char character) {
        System.out.println("generate character : " + character);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}


class FlyWeight {
    public static void main(String[] args) {
        CharacterFactory.getInstance('a');
        CharacterFactory.getInstance('a');
        CharacterFactory.getInstance('b');
        CharacterFactory.getInstance('a');
        CharacterFactory.getInstance('p');
        CharacterFactory.getInstance('@');
        CharacterFactory.getInstance('@');
    }
}
