package com.company.player;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
        int r = 2 + (int) (Math.random()*3);
        this.damage *= r;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        System.out.println("Warrior used " + superAbility);
    }




}
