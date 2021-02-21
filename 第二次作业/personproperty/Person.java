package personproperty;

import monster_property.Monster;

interface A<T>{
    public int ATK(T t);
}
public class Person implements A<Monster> {
    private String name;
    private int atk;
    private int hp;
    private int def;

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int ATK(Monster monster) {//返回造成的伤害并修改攻击的对象的hp值
        int x = monster.getDef();
        int y = this.atk;
        int i=monster.getHp();
        if (y > x) {
            monster.setHp(i-y+x);
            return y - x;
        } else {
            monster.setHp(i-1);
            return 1;
        }
    }
}
