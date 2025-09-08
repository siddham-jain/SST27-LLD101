package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private final String auraSprite = "golden.png";
    private final int speedBuff = 1;
    private final int damageBuff = 2;

    public GoldenAura(GameCharacter wrapped) {
        super(wrapped);
    }

    @Override
    public String getSprite() { return auraSprite; }

    @Override
    public int getSpeed() { return wrapped.getSpeed() + speedBuff; }

    @Override
    public int getDamage() { return wrapped.getDamage() + damageBuff; }

    @Override
    public void move() {
        System.out.println("[GoldenAura] shimmering movement");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[GoldenAura] radiant strike");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}


