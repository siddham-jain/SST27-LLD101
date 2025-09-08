package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int bonusDamage;

    public DamageBoost(GameCharacter wrapped, int bonusDamage) {
        super(wrapped);
        this.bonusDamage = bonusDamage;
    }

    @Override
    public int getDamage() { return wrapped.getDamage() + bonusDamage; }

    @Override
    public void attack() {
        System.out.println("[DamageBoost] damage +" + bonusDamage);
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}


