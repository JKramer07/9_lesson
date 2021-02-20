package com.company.game;

import com.company.player.*;

import java.util.Random;

public class RPG_Game {
    public static void start() {
        Boss boss = new Boss(1000, 70);
        Warrior warrior = new Warrior(250, 25);
        Hunter hunter = new Hunter(260, 15);
        Medic medic = new Medic(230, 10);
        Magic magic = new Magic(270, 20);
        Golem golem = new Golem(220, 20);
        Thor thor = new Thor(250, 20);
        Hero[] heroes = {warrior, hunter, medic, magic, golem, thor};

        printStatistics(boss, heroes);

        while (isGameFinished(boss, heroes) == false) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHit(boss, heroes);
        }
        heroesHit(boss, heroes);
        applySuper(boss, heroes);
        medicTreats(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void applySuper(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {

        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead == true) {
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("______________");
        System.out.println("Boss: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " gave damage: " + heroes[i].getDamage());
        }
        System.out.println("______________");

    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
            if (heroes[i].getHealth() <= 0){
                heroes[i].setHealth(0);
            }
        }
    }

    public static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth((boss.getHealth() - heroes[i].getDamage()));
            }
            if (boss.getHealth() <= 0){
                boss.setHealth(0);
            }
            Random r = new Random();
            int random = r.nextInt(40);
            heroes[i].setDamage(heroes[i].getDamage() + random);

        }

    }

    public static void medicTreats(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getHealth() < 100) {
                Random r = new Random();
                int random = r.nextInt(50);
                heroes[i].setHealth(heroes[i].getHealth() + random);
                System.out.println("Medic healed [" + random + "] HP!");
                break;
            }
        }
    }
}
