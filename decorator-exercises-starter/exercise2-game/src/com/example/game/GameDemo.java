package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        GameCharacter base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        System.out.println("--- Base + SpeedBoost + DamageBoost ---");
        GameCharacter buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();

        System.out.println("--- Add GoldenAura ---");
        GameCharacter shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();

        System.out.println("--- Remove GoldenAura (recomposition) ---");
        GameCharacter withoutAura = buffed; // simply use the chain without GoldenAura
        withoutAura.move();
        withoutAura.attack();
    }
}
