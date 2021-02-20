package com.company.player;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
    SuperAbility superAbility;

    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }
}
