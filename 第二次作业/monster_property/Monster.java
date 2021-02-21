package monster_property;

import personproperty.Person;
interface A<T>{
    public int ATK(T t);
}
public class Monster implements A<Person>{
    private String name;
    private int atk;
    private int hp;
    private int def;

    public Monster(String name,int hp,int atk,int def){
        this.name=name;
        this.atk=atk;
        this.hp=hp;
        this.def=def;
    }
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
    public int ATK(Person person) {//返回造成的伤害并修改攻击的对象的hp值
        int x= person.getDef();
        int y=this.atk;
        int i=person.getHp();
        if(y>x) {
            person.setHp(i-y+x);
            return y-x;
        }else{
            person.setHp(i-1);
            return 1;
        }

    }
}
