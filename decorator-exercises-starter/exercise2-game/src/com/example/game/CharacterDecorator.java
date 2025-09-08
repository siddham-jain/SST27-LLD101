package com.example.game;

public abstract class CharacterDecorator implements GameCharacter {
    protected final GameCharacter wrapped;

    protected CharacterDecorator(GameCharacter wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void move() { wrapped.move(); }

    @Override
    public void attack() { wrapped.attack(); }

    @Override
    public int getSpeed() { return wrapped.getSpeed(); }

    @Override
    public int getDamage() { return wrapped.getDamage(); }

    @Override
    public String getSprite() { return wrapped.getSprite(); }
}


