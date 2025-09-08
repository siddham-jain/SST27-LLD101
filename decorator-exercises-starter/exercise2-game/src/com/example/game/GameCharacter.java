package com.example.game;

public interface GameCharacter {
    void move();                // prints action including current speed/sprite
    void attack();              // prints action including current damage/sprite
    int getSpeed();
    int getDamage();
    String getSprite();         // current "image" id/path/name
}
