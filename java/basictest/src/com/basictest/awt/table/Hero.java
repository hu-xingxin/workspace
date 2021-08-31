package com.basictest.awt.table;

/**
 * @author huxingxin
 * @ClassName Hero.java
 * @Description
 * @createTime 2021年07月20日 14:48:00
 */
public class Hero {
    private String id;
    private String name;
    private String hp;
    private String damage;

    public Hero(String id, String name, String hp, String damage) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", damage='" + damage + '\'' +
                '}';
    }
}
