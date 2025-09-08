package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int bonusSpeed;

    public SpeedBoost(GameCharacter wrapped, int bonusSpeed) {
        super(wrapped);
        this.bonusSpeed = bonusSpeed;
    }

    @Override
    public int getSpeed() { return wrapped.getSpeed() + bonusSpeed; }

    @Override
    public void move() {
        System.out.println("[SpeedBoost] speed +" + bonusSpeed);
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }
}


