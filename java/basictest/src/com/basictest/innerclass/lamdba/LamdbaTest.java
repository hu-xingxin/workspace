package com.basictest.innerclass.lamdba;

import java.util.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-16 17:00
 **/
public class LamdbaTest {
    public static void main(String[] args) {
        getHero4(initHero());
    }

    public static List<Hero> initHero(){
        ArrayList<Hero> heroes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            Hero hero = new Hero("hero" + i, random.nextInt(1000), random.nextInt(100));
            heroes.add(hero);
        }
        return heroes;
    }

    public static void getHero(List<Hero> heroes){
        for (Hero hero: heroes) {
            if(hero.getHp()>500){
                System.out.println(hero);
            }
        }
    }

    public static void getHero2(List<Hero> heroes){
        HeroChecker heroChecker = new HeroChecker() {
            @Override
            public Boolean check(Hero hero) {
                return hero.getHp() > 500;
            }
        };
        for (Hero hero : heroes){
            if (heroChecker.check(hero)){
                System.out.println(hero);
            }
        }
    }

    public static void getHero3(List<Hero> heroes){
        HeroChecker  heroChecker = hero->hero.getHp() > 500;
        for (Hero hero : heroes) {
           if(heroChecker.check(hero)){
               System.out.println(hero);
           }
        }
    }

    public static void getHero4(List<Hero> heroes){
        filter(heroes,hero -> hero.getHp() > 500);
    }

    public static void filter(List<Hero> heroes,HeroChecker heroChecker){
        for (Hero hero : heroes) {
            if (heroChecker.check(hero)){
                System.out.println(hero);
            }
        }
    }

}
