package com.company.player;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN_ENEMY);
        Random b = new Random();
        if (health != 0){
            boolean random = b.nextBoolean();
            System.out.println("Thor used " + superAbility + random);
        }
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {


    }




}
