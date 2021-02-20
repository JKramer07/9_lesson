package com.company.player;

public class Hunter extends Hero {
    public Hunter(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        double r = (Math.random()+5);
        this.damage += r;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        System.out.println("Hunter used " + superAbility);
    }
}
