package com.company.player;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        double r = (Math.random()+10);
        this.damage += r;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        System.out.println("Golem used " + superAbility);
    }




}
